package allclasses.prokofev;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Потокобезопасный кошелёк.
 * - Хранит баланс и историю транзакций.
 * - Поддерживает deposit/withdraw/transfer с валидацией.
 */
public class WalletProkofev {

    // ==== Поля ====
    private final UUID id;
    private final String owner;
    private BigDecimal balance;
    private final List<Transaction> history;
    private final ReentrantLock lock = new ReentrantLock();

    // ==== Конструкторы ====
    public WalletProkofev(String owner) {
        this(UUID.randomUUID(), owner, BigDecimal.ZERO);
    }

    public WalletProkofev(UUID id, String owner, BigDecimal initialBalance) {
        if (owner == null || owner.isBlank()) {
            throw new IllegalArgumentException("owner is blank");
        }
        if (initialBalance == null || initialBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("initialBalance must be >= 0");
        }
        this.id = id == null ? UUID.randomUUID() : id;
        this.owner = owner;
        this.balance = initialBalance;
        this.history = new ArrayList<>();
        if (initialBalance.signum() > 0) {
            history.add(Transaction.deposit(initialBalance, "Initial balance"));
        }
    }

    // ==== Методы экземпляра ====

    /** Положить деньги на кошелёк. */
    public void deposit(BigDecimal amount, String note) {
        requirePositive(amount);
        lock.lock();
        try {
            balance = balance.add(amount);
            history.add(Transaction.deposit(amount, note));
        } finally {
            lock.unlock();
        }
    }

    /** Снять деньги с кошелька. Бросает IllegalStateException, если не хватает средств. */
    public void withdraw(BigDecimal amount, String note) {
        requirePositive(amount);
        lock.lock();
        try {
            ensureSufficientFunds(amount);
            balance = balance.subtract(amount);
            history.add(Transaction.withdraw(amount, note));
        } finally {
            lock.unlock();
        }
    }

    /** Снимок текущего баланса. */
    public BigDecimal getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }

    /** Невидоизменяемая копия истории. */
    public List<Transaction> getHistorySnapshot() {
        lock.lock();
        try {
            return List.copyOf(history);
        } finally {
            lock.unlock();
        }
    }

    public UUID getId() { return id; }
    public String getOwner() { return owner; }

    @Override
    public String toString() {
        return "Wallet{" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                ", balance=" + getBalance() +
                '}';
    }

   /* @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WalletProkofev wallet)) {
            return false;
        }
        return id.equals(wallet.id);
    }*/

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // ==== Статические методы ====

    /**
     * Перевод между кошельками c упорядоченной блокировкой, чтобы избежать deadlock.
     */
    public static void transfer(WalletProkofev from, WalletProkofev to, BigDecimal amount, String note) {
        if (from == null || to == null) {
            throw new IllegalArgumentException("from/to is null");
        }
        if (from == to) {
            throw new IllegalArgumentException("Cannot transfer to the same wallet");
        }
        requirePositive(amount);

        // Упорядочиваем блокировку по UUID, чтобы не было взаимной блокировки.
        WalletProkofev first = from.id.compareTo(to.id) < 0 ? from : to;
        WalletProkofev second = (first == from) ? to : from;

        first.lock.lock();
        second.lock.lock();
        try {
            if (from.balance.compareTo(amount) < 0) {
                throw new IllegalStateException("Insufficient funds");
            }
            from.balance = from.balance.subtract(amount);
            to.balance = to.balance.add(amount);
            from.history.add(Transaction.transferOut(amount, note, to.id));
            to.history.add(Transaction.transferIn(amount, note, from.id));
        } finally {
            second.lock.unlock();
            first.lock.unlock();
        }
    }

    // ==== Вспомогательные ====
    private static void requirePositive(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("amount must be > 0");
        }
    }

    private void ensureSufficientFunds(BigDecimal amount) {
        if (balance.compareTo(amount) < 0) {
            throw new IllegalStateException("Insufficient funds");
        }
    }

    // ==== Модель транзакции ====
    public static final class Transaction {
        public enum Type { DEPOSIT, WITHDRAW, TRANSFER_IN, TRANSFER_OUT }

        private final Type type;
        private final BigDecimal amount;
        private final Instant at;
        private final String note;
        private final UUID counterparty; // для переводов: id другого кошелька (может быть null)

        private Transaction(Type type, BigDecimal amount, String note, UUID counterparty) {
            this.type = Objects.requireNonNull(type);
            this.amount = amount;
            this.at = Instant.now();
            this.note = note;
            this.counterparty = counterparty;
        }

        public static Transaction deposit(BigDecimal amount, String note) {
            return new Transaction(Type.DEPOSIT, amount, note, null);
        }

        public static Transaction withdraw(BigDecimal amount, String note) {
            return new Transaction(Type.WITHDRAW, amount, note, null);
        }

        public static Transaction transferIn(BigDecimal amount, String note, UUID fromId) {
            return new Transaction(Type.TRANSFER_IN, amount, note, fromId);
        }

        public static Transaction transferOut(BigDecimal amount, String note, UUID toId) {
            return new Transaction(Type.TRANSFER_OUT, amount, note, toId);
        }

        public Type getType() { return type; }
        public BigDecimal getAmount() { return amount; }
        public Instant getAt() { return at; }
        public String getNote() { return note; }
        public UUID getCounterparty() { return counterparty; }

        @Override
        public String toString() {
            return "Transaction{" +
                    "type=" + type +
                    ", amount=" + amount +
                    ", at=" + at +
                    (counterparty != null ? ", counterparty=" + counterparty : "") +
                    (note != null && !note.isBlank() ? ", note='" + note + '\'' : "") +
                    '}';
        }
    }

    // ==== Пример использования ====
    public static void main(String[] args) {
        WalletProkofev a = new WalletProkofev("Alice");
        WalletProkofev b = new WalletProkofev("Bob");

        a.deposit(new BigDecimal("100.00"), "Top up");
        transfer(a, b, new BigDecimal("30.50"), "Dinner");
        b.withdraw(new BigDecimal("10.00"), "Taxi");

        System.out.println(a); // баланс Alice
        System.out.println(b); // баланс Bob

        // Печать истории Bob
        b.getHistorySnapshot().forEach(System.out::println);
    }
}

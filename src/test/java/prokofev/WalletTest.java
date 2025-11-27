package prokofev;

import allclasses.prokofev.WalletProkofev;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import java.math.BigDecimal;
import java.util.UUID;

public class WalletTest {
    
    @Test
    @DisplayName("Создание кошелька")
    @Description("Тест создания нового кошелька с проверкой владельца и начального баланса")
    public void testСозданиеКошелька() {
        WalletProkofev wallet = new WalletProkofev("TestUser");
        Assert.assertNotNull(wallet);
        Assert.assertEquals("TestUser", wallet.getOwner());
        Assert.assertEquals(BigDecimal.ZERO, wallet.getBalance());
    }
    
    @Test
    @DisplayName("Пополнение кошелька")
    @Description("Тест пополнения кошелька с проверкой изменения баланса и добавления записи в историю")
    public void testПополнениеКошелька() {
        WalletProkofev wallet = new WalletProkofev("TestUser");
        wallet.deposit(new BigDecimal("100.00"), "Test deposit");
        
        Assert.assertEquals(new BigDecimal("100.00"), wallet.getBalance());
        Assert.assertEquals(1, wallet.getHistorySnapshot().size());
    }
    
    @Test
    @DisplayName("Снятие средств")
    @Description("Тест снятия средств с кошелька с проверкой уменьшения баланса и добавления записи в историю")
    public void testСнятиеСредств() {
        WalletProkofev wallet = new WalletProkofev("TestUser");
        wallet.deposit(new BigDecimal("100.00"), "Initial deposit");
        wallet.withdraw(new BigDecimal("30.00"), "Test withdraw");
        
        Assert.assertEquals(new BigDecimal("70.00"), wallet.getBalance());
        Assert.assertEquals(2, wallet.getHistorySnapshot().size());
    }
    
    @Test(expected = IllegalStateException.class)
    @DisplayName("Снятие при недостаточных средствах")
    @Description("Тест снятия средств при недостаточном балансе - должна выбрасываться исключение")
    public void testСнятиеПриНедостаточныхСредствах() {
        WalletProkofev wallet = new WalletProkofev("TestUser");
        wallet.withdraw(new BigDecimal("100.00"), "Should fail");
    }
    
    @Test
    @DisplayName("Перевод между кошельками")
    @Description("Тест перевода средств между двумя кошельками с проверкой изменения балансов обоих кошельков")
    public void testПереводМеждуКошельками() {
        WalletProkofev from = new WalletProkofev("Alice");
        WalletProkofev to = new WalletProkofev("Bob");
        
        from.deposit(new BigDecimal("100.00"), "Initial");
        WalletProkofev.transfer(from, to, new BigDecimal("50.00"), "Transfer test");
        
        Assert.assertEquals(new BigDecimal("50.00"), from.getBalance());
        Assert.assertEquals(new BigDecimal("50.00"), to.getBalance());
    }
    
    @Test
    @DisplayName("История транзакций")
    @Description("Тест получения истории транзакций с проверкой количества записей и типов операций")
    public void testИсторияТранзакций() {
        WalletProkofev wallet = new WalletProkofev("TestUser");
        wallet.deposit(new BigDecimal("100.00"), "First deposit");
        wallet.withdraw(new BigDecimal("50.00"), "First withdraw");
        
        var history = wallet.getHistorySnapshot();
        Assert.assertEquals(2, history.size());
        Assert.assertEquals(WalletProkofev.Transaction.Type.DEPOSIT, history.get(0).getType());
        Assert.assertEquals(WalletProkofev.Transaction.Type.WITHDRAW, history.get(1).getType());
    }
    
    @Test
    @DisplayName("Начальный баланс")
    @Description("Тест создания кошелька с начальным балансом и проверка добавления записи в историю")
    public void testНачальныйБаланс() {
        WalletProkofev wallet = new WalletProkofev(UUID.randomUUID(), "TestUser", new BigDecimal("200.00"));
        Assert.assertEquals(new BigDecimal("200.00"), wallet.getBalance());
        Assert.assertEquals(1, wallet.getHistorySnapshot().size());
    }
    
    @Test(expected = IllegalArgumentException.class)
    @DisplayName("Отрицательный начальный баланс")
    @Description("Тест создания кошелька с отрицательным начальным балансом - должна выбрасываться исключение")
    public void testОтрицательныйНачальныйБаланс() {
        new WalletProkofev(UUID.randomUUID(), "TestUser", new BigDecimal("-100.00"));
    }
    
    @Test
    @DisplayName("Строковое представление")
    @Description("Тест метода toString с проверкой наличия информации о владельце в строковом представлении")
    public void testСтроковоеПредставление() {
        WalletProkofev wallet = new WalletProkofev("TestUser");
        String str = wallet.toString();
        Assert.assertNotNull(str);
        Assert.assertTrue(str.contains("TestUser"));
    }
    
    @Test
    @DisplayName("Равенство кошельков")
    @Description("Тест метода equals с проверкой равенства кошельков с одинаковым идентификатором")
    public void testРавенствоКошельков() {
        UUID id = UUID.randomUUID();
        WalletProkofev wallet1 = new WalletProkofev(id, "User1", BigDecimal.ZERO);
        WalletProkofev wallet2 = new WalletProkofev(id, "User2", BigDecimal.ZERO);
        
        Assert.assertEquals(wallet1, wallet2);
    }
}


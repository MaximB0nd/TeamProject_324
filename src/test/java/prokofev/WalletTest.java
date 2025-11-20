package prokofev;

import allclasses.prokofev.WalletProkofev;
import org.junit.Assert;
import org.junit.Test;
import java.math.BigDecimal;
import java.util.UUID;

public class WalletTest {
    
    @Test
    public void testCreateWallet() {
        WalletProkofev wallet = new WalletProkofev("TestUser");
        Assert.assertNotNull(wallet);
        Assert.assertEquals("TestUser", wallet.getOwner());
        Assert.assertEquals(BigDecimal.ZERO, wallet.getBalance());
    }
    
    @Test
    public void testDeposit() {
        WalletProkofev wallet = new WalletProkofev("TestUser");
        wallet.deposit(new BigDecimal("100.00"), "Test deposit");
        
        Assert.assertEquals(new BigDecimal("100.00"), wallet.getBalance());
        Assert.assertEquals(1, wallet.getHistorySnapshot().size());
    }// new
    
    @Test
    public void testWithdraw() {
        WalletProkofev wallet = new WalletProkofev("TestUser");
        wallet.deposit(new BigDecimal("100.00"), "Initial deposit");
        wallet.withdraw(new BigDecimal("30.00"), "Test withdraw");
        
        Assert.assertEquals(new BigDecimal("70.00"), wallet.getBalance());
        Assert.assertEquals(2, wallet.getHistorySnapshot().size());
    }
    
    @Test(expected = IllegalStateException.class)
    public void testWithdrawInsufficientFunds() {
        WalletProkofev wallet = new WalletProkofev("TestUser");
        wallet.withdraw(new BigDecimal("100.00"), "Should fail");
    }
    
    @Test
    public void testTransfer() {
        WalletProkofev from = new WalletProkofev("Alice");
        WalletProkofev to = new WalletProkofev("Bob");
        
        from.deposit(new BigDecimal("100.00"), "Initial");
        WalletProkofev.transfer(from, to, new BigDecimal("50.00"), "Transfer test");
        
        Assert.assertEquals(new BigDecimal("50.00"), from.getBalance());
        Assert.assertEquals(new BigDecimal("50.00"), to.getBalance());
    }
    
    @Test
    public void testHistory() {
        WalletProkofev wallet = new WalletProkofev("TestUser");
        wallet.deposit(new BigDecimal("100.00"), "First deposit");
        wallet.withdraw(new BigDecimal("50.00"), "First withdraw");
        
        var history = wallet.getHistorySnapshot();
        Assert.assertEquals(2, history.size());
        Assert.assertEquals(WalletProkofev.Transaction.Type.DEPOSIT, history.get(0).getType());
        Assert.assertEquals(WalletProkofev.Transaction.Type.WITHDRAW, history.get(1).getType());
    }
    
    @Test
    public void testInitialBalance() {
        WalletProkofev wallet = new WalletProkofev(UUID.randomUUID(), "TestUser", new BigDecimal("200.00"));
        Assert.assertEquals(new BigDecimal("200.00"), wallet.getBalance());
        Assert.assertEquals(1, wallet.getHistorySnapshot().size());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testNegativeInitialBalance() {
        new WalletProkofev(UUID.randomUUID(), "TestUser", new BigDecimal("-100.00"));
    }
    
    @Test
    public void testToString() {
        WalletProkofev wallet = new WalletProkofev("TestUser");
        String str = wallet.toString();
        Assert.assertNotNull(str);
        Assert.assertTrue(str.contains("TestUser"));
    }
    
    @Test
    public void testEquals() {
        UUID id = UUID.randomUUID();
        WalletProkofev wallet1 = new WalletProkofev(id, "User1", BigDecimal.ZERO);
        WalletProkofev wallet2 = new WalletProkofev(id, "User2", BigDecimal.ZERO);
        
        Assert.assertEquals(wallet1, wallet2);
    }
}


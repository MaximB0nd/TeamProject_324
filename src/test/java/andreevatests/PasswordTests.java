package andreevatests;

import allclasses.andreeva.Password;
import allclasses.bartasevich.Complex;
import org.junit.Assert;
import org.junit.Test;

import static java.lang.Math.sqrt;

public class PasswordTests {
    @Test
    public void isPowerful_PasswordIsStrong_ReturnsTrue()
    {
        Password testPassword = new Password("SuperStrongP@ssw0rd!");
        boolean expected = true;
        Assert.assertEquals(expected, testPassword.isPowerful());
    }

    @Test
    public void isPowerful_PasswordIsTooShort_ReturnsFalse()
    {
        Password testPassword = new Password("Short1!");
        boolean expected = false;
        Assert.assertEquals(expected, testPassword.isPowerful());
    }

    @Test
    public void isPowerful_PasswordNoSpecialSymbols_ReturnsFalse()
    {
        Password testPassword = new Password("StrongPassword123");
        boolean expected = false;
        Assert.assertEquals(expected, testPassword.isPowerful());
    }

    @Test
    public void isPowerful_PasswordContainsKeyboardSequence_ReturnsFalse()
    {
        Password testPassword = new Password("QwertyStrong123!");
        boolean expected = false;
        Assert.assertEquals(expected, testPassword.isPowerful());
    }

    @Test
    public void isPowerful_PasswordNoDigits_ReturnsFalse()
    {
        Password testPassword = new Password("StrongPassword!!!");
        boolean expected = false;
        Assert.assertEquals(expected, testPassword.isPowerful());
    }

    @Test
    public void isPowerful_PasswordNoUpperCase_ReturnsFalse()
    {
        Password testPassword = new Password("strongpassword123!");
        boolean expected = false;
        Assert.assertEquals(expected, testPassword.isPowerful());
    }

    @Test
    public void isPowerful_PasswordNoLowerCase_ReturnsFalse()
    {
        Password testPassword = new Password("STRONGPASSWORD123!");
        boolean expected = false;
        Assert.assertEquals(expected, testPassword.isPowerful());
    }

    @Test
    public void isPowerful_PasswordContains123Sequence_ReturnsFalse()
    {
        Password testPassword = new Password("MyPassword123!");
        boolean expected = false;
        Assert.assertEquals(expected, testPassword.isPowerful());
    }
}

package andreevatests;

import allclasses.andreeva.Password;
import org.junit.Assert;
import org.junit.Test;
import jdk.jfr.Name;

public class PasswordTests {
    @Test
    @Name("Проверка сильного пароля")
    public void isPowerful_PasswordIsStrong_ReturnsTrue()
    {
        Password testPassword = new Password("SuperStrongP@ssw0rd!");
        boolean expected = true;
        Assert.assertEquals(expected, testPassword.isPowerful());
    }

    @Test
    @Name("Проверка слишком короткого пароля")
    public void isPowerful_PasswordIsTooShort_ReturnsFalse()
    {
        Password testPassword = new Password("Short1!");
        boolean expected = false;
        Assert.assertEquals(expected, testPassword.isPowerful());
    }

    @Test
    @Name("Проверка пароля без спецсимволов")
    public void isPowerful_PasswordNoSpecialSymbols_ReturnsFalse()
    {
        Password testPassword = new Password("StrongPassword123");
        boolean expected = false;
        Assert.assertEquals(expected, testPassword.isPowerful());
    }

    @Test
    @Name("Проверка пароля с qwerty")
    public void isPowerful_PasswordContainsKeyboardSequence_ReturnsFalse()
    {
        Password testPassword = new Password("QwertyStrong123!");
        boolean expected = false;
        Assert.assertEquals(expected, testPassword.isPowerful());
    }

    @Test
    @Name("Проверка пароля без цифр")
    public void isPowerful_PasswordNoDigits_ReturnsFalse()
    {
        Password testPassword = new Password("StrongPassword!!!");
        boolean expected = false;
        Assert.assertEquals(expected, testPassword.isPowerful());
    }

    @Test
    @Name("Проверка пароля без заглавных букв")
    public void isPowerful_PasswordNoUpperCase_ReturnsFalse()
    {
        Password testPassword = new Password("strongpassword123!");
        boolean expected = false;
        Assert.assertEquals(expected, testPassword.isPowerful());
    }

    @Test
    @Name("Проверка пароля без строчных букв")
    public void isPowerful_PasswordNoLowerCase_ReturnsFalse()
    {
        Password testPassword = new Password("STRONGPASSWORD123!");
        boolean expected = false;
        Assert.assertEquals(expected, testPassword.isPowerful());
    }

    @Test
    @Name("Проверка пароля с 123")
    public void isPowerful_PasswordContains123Sequence_ReturnsFalse()
    {
        Password testPassword = new Password("MyPassword123!");
        boolean expected = false;
        Assert.assertEquals(expected, testPassword.isPowerful());
    }
}
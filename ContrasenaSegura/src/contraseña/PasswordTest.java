package contraseña;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordTest {
    private Passwords password;

    @Before
    public void setUp() {
        password = new Passwords();
    }
    @Test
    public void test00EmptyPasswordIsNotSafe(){
        password.registerPassword("");
        assertFalse(password.isSafe());
        assertEquals(1,password.getPasswordsSubmitted());
        assertEquals(0,password.getSafePasswordsSubmitted());
    }
    @Test public void test01PasswordWithLessThan8CharactersIsNotSafe(){
        password.registerPassword("1234567");
        assertFalse(password.isSafe());
        assertEquals(1,password.getPasswordsSubmitted());
        assertEquals(0,password.getSafePasswordsSubmitted());
    }
    @Test public void test02PasswordWithNoUppercaseLetterIsNotSafe(){
        password.registerPassword("123u45678");
        assertFalse(password.isSafe());
        assertEquals(1,password.getPasswordsSubmitted());
        assertEquals(0,password.getSafePasswordsSubmitted());
    }
    @Test public void test03PasswordWithNoLowercaseLetterIsNotSafe(){
        password.registerPassword("12345678A");
        assertFalse(password.isSafe());
        assertEquals(1,password.getPasswordsSubmitted());
        assertEquals(0,password.getSafePasswordsSubmitted());
    }
    @Test public void test04PasswordWithNoNumberIsNotSafe(){
        password.registerPassword("abcdefghi");
        assertFalse(password.isSafe());
        assertEquals(1,password.getPasswordsSubmitted());
        assertEquals(0,password.getSafePasswordsSubmitted());
    }
    @Test public void test05PasswordWithNoSpecialCharacterIsNotSafe(){
        password.registerPassword("12345678Aa");
        assertFalse(password.isSafe());
        assertEquals(1,password.getPasswordsSubmitted());
        assertEquals(0,password.getSafePasswordsSubmitted());
    }
    @Test public void test06PasswordWithLessThan8DigitsAndNoUppercaseLetterIsNotSafe(){
        password.registerPassword("1234!7a");
        assertFalse(password.isSafe());
        assertEquals(1,password.getPasswordsSubmitted());
        assertEquals(0,password.getSafePasswordsSubmitted());
    }
    @Test public void test07PasswordWithLessThan8DigitsAndNoLowercaseLetterIsNotSafe(){
        password.registerPassword("1234!7A");
        assertFalse(password.isSafe());
        assertEquals(1,password.getPasswordsSubmitted());
        assertEquals(0,password.getSafePasswordsSubmitted());
    }
    @Test public void test08PasswordWithNoNumberAndNoSpecialCharacterIsNotSafe(){
        password.registerPassword("abcd4efgGGGG");
        assertFalse(password.isSafe());
        assertEquals(1,password.getPasswordsSubmitted());
        assertEquals(0,password.getSafePasswordsSubmitted());
    }
    @Test public void test20PasswordWithOnlySpecialCharactersIsNotSafe() {
        password.registerPassword("!@#$%^&*");
        assertFalse(password.isSafe());
        assertEquals(1, password.getPasswordsSubmitted());
        assertEquals(0, password.getSafePasswordsSubmitted());
    }
    @Test public void test09PasswordWithNoNumberAndNoUppercaseLetterIsNotSafe(){
        password.registerPassword("abcd!efgGGGG");
        assertFalse(password.isSafe());
        assertEquals(1,password.getPasswordsSubmitted());
        assertEquals(0,password.getSafePasswordsSubmitted());
    }
    @Test public void test10PasswordWithNoNumberAndNoLowercaseLetterIsNotSafe(){
        password.registerPassword("THISISASAFEPASSWORD!!!!");
        assertFalse(password.isSafe());
        assertEquals(1,password.getPasswordsSubmitted());
        assertEquals(0,password.getSafePasswordsSubmitted());
    }
    @Test public void test11PasswordWithNoSpecialCharacterAndNoUppercaseLetterIsNotSafe(){
        password.registerPassword("abcd4efg");
        assertFalse(password.isSafe());
        assertEquals(1,password.getPasswordsSubmitted());
        assertEquals(0,password.getSafePasswordsSubmitted());
    }
    @Test public void test12PasswordWithAllRequirementsIsSafe(){
        password.registerPassword("Aabcd4efg%GGGG!");
        assertTrue(password.isSafe());
        assertEquals(1,password.getPasswordsSubmitted());
        assertEquals(1,password.getSafePasswordsSubmitted());
    }
    @Test public void test13CanSubmitMultipleNotSafePasswords(){
        password.registerPassword("12345678");
        assertFalse(password.isSafe());
        assertEquals(1,password.getPasswordsSubmitted());
        assertEquals(0,password.getSafePasswordsSubmitted());
        password.registerPassword("12345678A");
        assertFalse(password.isSafe());
        assertEquals(2,password.getPasswordsSubmitted());
        assertEquals(0,password.getSafePasswordsSubmitted());
        password.registerPassword("abcdefghi");
        assertFalse(password.isSafe());
        assertEquals(3,password.getPasswordsSubmitted());
        assertEquals(0,password.getSafePasswordsSubmitted());
    }
    @Test public void test14CanSubmitMultipleSafePasswords(){
        password.registerPassword("Aabcd774efg%GGGG!");
        assertTrue(password.isSafe());
        assertEquals(1,password.getPasswordsSubmitted());
        assertEquals(1,password.getSafePasswordsSubmitted());
        password.registerPassword("Aabcd4efg%GGGG!");
        assertTrue(password.isSafe());
        assertEquals(2,password.getPasswordsSubmitted());
        assertEquals(2,password.getSafePasswordsSubmitted());
        password.registerPassword("Aabcd4efg%GGGG!");
        assertTrue(password.isSafe());
        assertEquals(3,password.getPasswordsSubmitted());
        assertEquals(3,password.getSafePasswordsSubmitted());
    }
    @Test public void test15CanSubmitMultiplePasswords(){
        Passwords password = new Passwords();
        password.registerPassword("12345678");
        assertFalse(password.isSafe());
        assertEquals(1,password.getPasswordsSubmitted());
        assertEquals(0,password.getSafePasswordsSubmitted());
        password.registerPassword("abcd4ef%gGGGG!");
        assertTrue(password.isSafe());
        assertEquals(2,password.getPasswordsSubmitted());
        assertEquals(1,password.getSafePasswordsSubmitted());
        password.registerPassword("12345678A");
        assertFalse(password.isSafe());
        assertEquals(3,password.getPasswordsSubmitted());
        assertEquals(1,password.getSafePasswordsSubmitted());
        password.registerPassword("abcd4efgGGGG!");
        assertTrue(password.isSafe());
        assertEquals(4,password.getPasswordsSubmitted());
        assertEquals(2,password.getSafePasswordsSubmitted());
        password.registerPassword("abcdefghi");
        assertFalse(password.isSafe());
        assertEquals(5,password.getPasswordsSubmitted());
        assertEquals(2,password.getSafePasswordsSubmitted());
        password.registerPassword("abcd4efgHHH!");
        assertTrue(password.isSafe());
        assertEquals(6,password.getPasswordsSubmitted());
        assertEquals(3,password.getSafePasswordsSubmitted());
    }

}

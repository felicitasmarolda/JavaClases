package contraseña;

import java.util.regex.Pattern;

public class ValidatesLowercase extends PasswordRequirements{

    public void isSafeInEachRequirement(Pattern password, Passwords passwordsClass) {
        passwordsClass.newPasswordIsSafe(password.toString().matches(".*[a-z].*"));
    }
}

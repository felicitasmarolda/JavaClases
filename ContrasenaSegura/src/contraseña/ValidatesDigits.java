package contraseña;

import java.util.regex.Pattern;

public class ValidatesDigits extends PasswordRequirements{

    public void isSafeInEachRequirement(Pattern password, Passwords passwordsClass) {
        passwordsClass.newPasswordIsSafe(password.toString().matches(".*[0-9].*"));
    }
}

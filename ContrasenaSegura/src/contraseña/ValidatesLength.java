package contraseña;

import java.util.regex.Pattern;

public class ValidatesLength extends PasswordRequirements{

    public void isSafeInEachRequirement(Pattern password, Passwords passwordsClass) {
        passwordsClass.newPasswordIsSafe(password.toString().length() >= 8);
    }
}

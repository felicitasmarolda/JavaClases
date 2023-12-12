package contraseña;

import java.util.regex.Pattern;

public class ValidatesSpecialCharacter extends PasswordRequirements{

    public void isSafeInEachRequirement(Pattern password, Passwords passwordsClass) {
        passwordsClass.newPasswordIsSafe(password.toString().matches(".*[!@#$%^&*()_+=-].*"));
    }
}

package contraseña;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public abstract class PasswordRequirements {
    static List<PasswordRequirements> requirements = new ArrayList<>(Arrays.asList(
            new ValidatesLength(),
            new ValidatesUppercase(),
            new ValidatesLowercase(),
            new ValidatesDigits(),
            new ValidatesSpecialCharacter()));


    public void isSafeInEachRequirement(Pattern password, Passwords passwordsClass) {
    }

}

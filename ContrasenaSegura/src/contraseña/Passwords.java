package contraseña;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Passwords {
    private int passwordsSubmitted;
    private int safePasswordsSubmitted;
    private Pattern pattern;
    private boolean passwordIsSafe;

    static List<PasswordRequirements> requirements = new ArrayList<>(Arrays.asList(
            new ValidatesLength(),
            new ValidatesUppercase(),
            new ValidatesLowercase(),
            new ValidatesDigits(),
            new ValidatesSpecialCharacter()));

    public Passwords() {
        this.passwordsSubmitted = 0;
        this.safePasswordsSubmitted = 0;
        this.passwordIsSafe = true;
    }
    public void registerPassword(String password) {
        pattern = Pattern.compile(password);
        passwordsSubmitted += 1;

        for (PasswordRequirements requirement : requirements) {
            requirement.isSafeInEachRequirement(pattern, this);
        }

        if (passwordIsSafe) {
            safePasswordsSubmitted += 1;
        }
    }

    public int getPasswordsSubmitted() {
        return this.passwordsSubmitted;
    }
    public int getSafePasswordsSubmitted() {
        return this.safePasswordsSubmitted;
    }
    public boolean isSafe(){
        return passwordIsSafe;
    }

    public void newPasswordIsSafe(boolean matches) {
        if(!matches){
            passwordIsSafe = false;
        }
    }
}

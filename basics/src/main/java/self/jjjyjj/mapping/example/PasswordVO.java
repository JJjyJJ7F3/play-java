package self.jjjyjj.mapping.example;

import lombok.Value;

@Value
public class PasswordVO {
    String hashedValue;

    public static PasswordVO fromPlainText(String plainText) {
        return new PasswordVO(hashPassword(plainText));
    }

    private static String hashPassword(String password) {
        // Implementation of password hashing
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public boolean matches(String plainText) {
        return BCrypt.checkpw(plainText, hashedValue);
    }
}
package self.jjjyjj.mapping.example;

import lombok.Value;

@Value
public class EmailVO {
    String value;

    public EmailVO(String email) {
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.value = email;
    }

    private boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
}
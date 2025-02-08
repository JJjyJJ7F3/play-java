package self.jjjyjj.mapping.example.bo;

import lombok.Data;

@Data
public class UserBO {
    private Long id;
    private String username;
    private String email;
    private String password;
    
    public boolean isValid() {
        return username != null && email != null && password != null &&
               email.contains("@") && password.length() >= 8;
    }
}
package self.jjjyjj.mapping.example;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UserSearchCriteria {
    private String username;
    private String email;
    private UserStatus status;
    private LocalDateTime createdAfter;
    private LocalDateTime createdBefore;
}
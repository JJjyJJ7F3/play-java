package self.jjjyjj.mapping.example;

import lombok.Getter;

@Getter
public class UserBO {
    private final UserEntity user;

    public UserBO(UserEntity user) {
        this.user = user;
    }

    public boolean isActive() {
        return UserStatus.ACTIVE.equals(user.getStatus());
    }

    public boolean canLogin() {
        return isActive() && !isLocked();
    }

    public boolean isLocked() {
        return UserStatus.LOCKED.equals(user.getStatus());
    }

    public void activate() {
        if (!isActive()) {
            user.setStatus(UserStatus.ACTIVE);
        }
    }

    public void lock() {
        if (!isLocked()) {
            user.setStatus(UserStatus.LOCKED);
        }
    }

    public boolean verifyPassword(String plainTextPassword) {
        return new PasswordVO(user.getPasswordHash())
                .matches(plainTextPassword);
    }

    public String getFullName() {
        return String.format("%s %s",
                user.getFirstName(),
                user.getLastName()).trim();
    }
}
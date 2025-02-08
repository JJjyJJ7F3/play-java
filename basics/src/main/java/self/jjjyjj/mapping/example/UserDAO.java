package self.jjjyjj.mapping.example;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserDAO {
    private final EntityManager entityManager;

    public List<UserEntity> findActiveUsers() {
        return entityManager.createQuery(
                        "SELECT u FROM UserEntity u WHERE u.status = :status",
                        UserEntity.class)
                .setParameter("status", UserStatus.ACTIVE)
                .getResultList();
    }

    public List<UserEntity> findUsersCreatedAfter(LocalDateTime date) {
        return entityManager.createQuery(
                        "SELECT u FROM UserEntity u WHERE u.createdAt > :date",
                        UserEntity.class)
                .setParameter("date", date)
                .getResultList();
    }
}
package self.jjjyjj.mapping.example.dao;

import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;
import self.jjjyjj.mapping.example.entity.UserEntity;
import self.jjjyjj.mapping.example.repository.UserRepository;

@Component
@RequiredArgsConstructor
public class UserDAO {
    private final UserRepository userRepository;
    
    public UserEntity save(UserEntity user) {
        return userRepository.save(user);
    }
    
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
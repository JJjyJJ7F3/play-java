package self.jjjyjj.mapping.example.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import self.jjjyjj.mapping.example.bo.UserBO;
import self.jjjyjj.mapping.example.dao.UserDAO;
import self.jjjyjj.mapping.example.dto.UserDTO;
import self.jjjyjj.mapping.example.entity.UserEntity;
import self.jjjyjj.mapping.example.vo.UserVO;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDAO userDAO;
    
    public UserVO createUser(UserDTO userDTO) {
        // Convert DTO to BO
        UserBO userBO = new UserBO();
        userBO.setUsername(userDTO.getUsername());
        userBO.setEmail(userDTO.getEmail());
        userBO.setPassword(userDTO.getPassword());
        
        // Validate business rules
        if (!userBO.isValid()) {
            throw new IllegalArgumentException("Invalid user data");
        }
        
        // Check if email already exists
        if (userDAO.existsByEmail(userBO.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }
        
        // Convert BO to Entity
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userBO.getUsername());
        userEntity.setEmail(userBO.getEmail());
        userEntity.setPassword(userBO.getPassword()); // In real application, encrypt password
        
        // Save and convert to VO
        UserEntity savedUser = userDAO.save(userEntity);
        return new UserVO(
            savedUser.getId(),
            savedUser.getUsername(),
            savedUser.getEmail()
        );
    }
}
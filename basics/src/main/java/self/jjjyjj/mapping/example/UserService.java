package self.jjjyjj.mapping.example;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    public static interface UserRepository extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {
        boolean existsByEmail(String email);
        boolean existsByUsername(String username);
    }
    private final UserRepository userRepository;
    private final JpaSpecificationExecutor<UserEntity> userSpecificationExecutor;
    private final UserDAO userDAO;
    private final UserMapper userMapper;

    public UserResponseDTO registerUser(UserRegistrationDTO registrationDTO) {
        // Validate unique constraints
        validateUniqueConstraints(registrationDTO);

        // Create user entity
        UserEntity user = new UserEntity();
        user.setUsername(registrationDTO.getUsername());
        user.setEmail(new EmailVO(registrationDTO.getEmail()).getValue());
        user.setPasswordHash(PasswordVO.fromPlainText(
                registrationDTO.getPassword()).getHashedValue());
        user.setFirstName(registrationDTO.getFirstName());
        user.setLastName(registrationDTO.getLastName());
        user.setStatus(UserStatus.PENDING);

        // Save user
        UserEntity savedUser = userRepository.save(user);

        // Create business object and activate user
        UserBO userBO = new UserBO(savedUser);
        userBO.activate();

        // Save changes and return response
        return userMapper.toResponseDTO(userRepository.save(savedUser));
    }

    public UserResponseDTO getUserById(Long id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        return userMapper.toResponseDTO(user);
    }

    public List<UserResponseDTO> getActiveUsers() {
        return userDAO.findActiveUsers().stream()
                .map(userMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    private void validateUniqueConstraints(UserRegistrationDTO dto) {
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new EmailAlreadyExistsException(dto.getEmail());
        }
        if (userRepository.existsByUsername(dto.getUsername())) {
            throw new UsernameAlreadyExistsException(dto.getUsername());
        }
    }

    @Transactional(readOnly = true)
    public Page<UserResponseDTO> searchUsers(UserSearchCriteria criteria, Pageable pageable) {
        Specification<UserEntity> spec = UserSpecifications.withCriteria(criteria);
        Page<UserEntity> users = userRepository.findAll(spec, pageable);
        return users.map(userMapper::toResponseDTO);
    }

    public UserResponseDTO updateUser(Long id, UserUpdateDTO updateDTO) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        // Update only non-null fields
        if (updateDTO.getUsername() != null) {
            validateUsernameUpdate(user, updateDTO.getUsername());
            user.setUsername(updateDTO.getUsername());
        }

        if (updateDTO.getEmail() != null) {
            validateEmailUpdate(user, updateDTO.getEmail());
            user.setEmail(new EmailVO(updateDTO.getEmail()).getValue());
        }

        if (updateDTO.getFirstName() != null) {
            user.setFirstName(updateDTO.getFirstName());
        }

        if (updateDTO.getLastName() != null) {
            user.setLastName(updateDTO.getLastName());
        }

        return userMapper.toResponseDTO(userRepository.save(user));
    }

    private void validateUsernameUpdate(UserEntity user, String newUsername) {
        if (!user.getUsername().equals(newUsername) &&
                userRepository.existsByUsername(newUsername)) {
            throw new UsernameAlreadyExistsException(newUsername);
        }
    }

    private void validateEmailUpdate(UserEntity user, String newEmail) {
        if (!user.getEmail().equals(newEmail) &&
                userRepository.existsByEmail(newEmail)) {
            throw new EmailAlreadyExistsException(newEmail);
        }
    }
}
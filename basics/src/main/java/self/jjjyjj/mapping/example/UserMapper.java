package self.jjjyjj.mapping.example;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponseDTO toResponseDTO(UserEntity user);
    
    @Mapping(target = "fullName",
        expression = "java(new UserBO(user).getFullName())")
    UserResponseDTO toResponseDTOWithFullName(UserEntity user);
}
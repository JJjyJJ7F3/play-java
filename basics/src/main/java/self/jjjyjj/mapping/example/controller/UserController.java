package self.jjjyjj.mapping.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import self.jjjyjj.mapping.example.service.UserService;
import self.jjjyjj.mapping.example.dto.UserDTO;
import self.jjjyjj.mapping.example.vo.UserVO;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    
    @PostMapping
    public ResponseEntity<UserVO> createUser(@RequestBody UserDTO userDTO) {
        try {
            UserVO userVO = userService.createUser(userDTO);
            return ResponseEntity.ok(userVO);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
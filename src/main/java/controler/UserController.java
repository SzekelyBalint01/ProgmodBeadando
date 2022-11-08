package controler;

import dto.UpdateUserDto;
import model.User;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Optional<User>> getUser(User newUser){
        Optional<User> user = userService.getUser(newUser);
        return ResponseEntity.ok(user);
    }

    @PostMapping(produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> loginUser(@RequestBody @Valid UpdateUserDto updateUserDto){
        boolean isCreated = userService.createUser(updateUserDto);
        return ResponseEntity.ok(isCreated);
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deleteUser(User newUser){
        boolean user = userService.deleteUser(newUser);
        return ResponseEntity.ok(user);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(User newUser){
        User user = userService.updateUser(newUser);
        return ResponseEntity.ok(user);
    }
}

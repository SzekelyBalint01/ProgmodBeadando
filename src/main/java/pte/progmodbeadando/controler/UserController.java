package pte.progmodbeadando.controler;

import pte.progmodbeadando.dto.UpdateUserDto;
import pte.progmodbeadando.model.User;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pte.progmodbeadando.service.UserService;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable Integer id){
        Optional<User> user = userService.getUser(id);
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

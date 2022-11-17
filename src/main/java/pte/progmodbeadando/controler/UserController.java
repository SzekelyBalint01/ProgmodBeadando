package pte.progmodbeadando.controler;

import org.springframework.http.MediaType;
import pte.progmodbeadando.dto.CreateUserDto;
import pte.progmodbeadando.dto.UpdateUserDto;
import pte.progmodbeadando.model.User;
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

    @PostMapping
    public ResponseEntity<Boolean> registerUser(@RequestBody CreateUserDto createUserDto){
        boolean isCreated = userService.createUser(createUserDto);
        return ResponseEntity.ok(isCreated);
    }

    @DeleteMapping(path ="/{id}" )
    public ResponseEntity<Boolean> deleteUser(@PathVariable Integer id){
        boolean user = userService.deleteUser(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(UpdateUserDto updateUserDto){
        User user = userService.updateUser(updateUserDto);
        return ResponseEntity.ok(user);
    }
}

package pte.progmodbeadando.controler;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pte.progmodbeadando.dto.AuthorizeUserDto;
import pte.progmodbeadando.model.User;
import pte.progmodbeadando.service.UserService;


@RestController
@RequestMapping("/api")
public class Authorize {

    UserService userService;

    public Authorize(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> verifyUser(@RequestBody AuthorizeUserDto authorizeUserDto){
        User user = userService.verifyUser(authorizeUserDto);
        return ResponseEntity.ok(user);
    }
}

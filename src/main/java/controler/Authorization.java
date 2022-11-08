package controler;


import model.User;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import service.UserService;

import java.util.Optional;

public class Authorization {

    UserService userService;

    public Authorization(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path="/login", produces = "application/json", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<Optional<User>> signupUser(@RequestBody MultiValueMap<String, String> formData){
        Optional<User> verify = userService.verifyUser(formData.getFirst("email"),formData.getFirst("password"));
        return ResponseEntity.ok(verify);
    }
}

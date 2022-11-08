package service;

import dto.UpdateUserDto;
import model.User;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Transactional
    public boolean createUser(UpdateUserDto newUser){
        checkIfEmailUnique(newUser.getEmail());
        User user = User.builder()
                .password(newUser.getPassword())
                .email(newUser.getEmail())
                .name(newUser.getName())
                .build();
        userRepository.save(user);
        return true;
    }

    public void checkIfEmailUnique(String email){
        if (userRepository.existsByEmail(email)){
            throw new RuntimeException("This email is already in use");
        }
    }

    public Optional<User> getUser(User newUser){
       return getUserById(newUser.getId());
    }
    @Transactional
    public User updateUser(User newUser){
        User user = userRepository.save(newUser);
        return user;
    }

    @Transactional
    public boolean deleteUser(User newUser){
        userRepository.deleteById(newUser.getId());
        return true;
    }

    public Optional<User> getUserById(Integer id){
        return userRepository.findById(id);
    }

    public Optional<User> getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public Optional<User> verifyUser(String email, String password){
        Optional<User> user = null;
        for (int i = 0; i < findAll().size(); i++) {

            String tempEmail = findAll().get(i).getEmail();
            String tempPassword = findAll().get(i).getPassword();
            Integer id = findAll().get(i).getId();

            if (tempEmail.equals(email) && tempPassword.equals(password)) {

                 user = userRepository.findById(id);

                return user;
            }
        }
        return user;
    }

    public List<User> findAll() {

        List<User> users = userRepository.findAll();
        return users;
    }
}

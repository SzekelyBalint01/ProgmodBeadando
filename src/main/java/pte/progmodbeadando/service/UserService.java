package pte.progmodbeadando.service;

import pte.progmodbeadando.dto.AuthorizeUserDto;
import pte.progmodbeadando.dto.CreateUserDto;
import pte.progmodbeadando.dto.UpdateUserDto;
import pte.progmodbeadando.model.User;
import org.springframework.stereotype.Service;
import pte.progmodbeadando.repository.UserRepository;

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
    public boolean createUser(CreateUserDto createUserDto){
        checkIfEmailUnique(createUserDto.getEmail());
        User user = User.builder()
                .password(createUserDto.getPassword())
                .email(createUserDto.getEmail())
                .name(createUserDto.getName())
                .build();
        userRepository.save(user);
        return true;
    }


    public void checkIfEmailUnique(String email){
        if (userRepository.existsByEmail(email)){
            throw new RuntimeException("This email is already in use");
        }
    }

    public Optional<User> getUser(Integer id){
       return getUserById(id);
    }
    @Transactional
    public User updateUser(UpdateUserDto updateUserDto){
        User user = User.builder()
            .password(updateUserDto.getPassword())
            .email(updateUserDto.getEmail())
            .name(updateUserDto.getName())
            .build();
        userRepository.save(user);
        return user;
    }

    @Transactional
    public boolean deleteUser(Integer id){
        userRepository.deleteById(id);
        return true;
    }

    public Optional<User> getUserById(Integer id){
        return userRepository.findById(id);
    }

    public Optional<User> getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public User verifyUser(AuthorizeUserDto authorizeUserDto){
        User user = null;
        for (int i = 0; i < findAll().size(); i++) {

            String tempEmail = findAll().get(i).getEmail();
            String tempPassword = findAll().get(i).getPassword();
            Integer id = findAll().get(i).getId();

            if (tempEmail.equals(authorizeUserDto.getEmail()) && tempPassword.equals(authorizeUserDto.getPassword())) {

                user = userRepository.findById(id).orElseThrow();
                
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

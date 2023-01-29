package com.einkaufswagen.Service;

import com.einkaufswagen.User.User;
import com.einkaufswagen.User.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No User found!"));
    }

    public User getUserByUsername(String username){
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new NoSuchElementException("No User found!"));
    }

    public User getUserByEmail(String email){
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new NoSuchElementException("No User found!"));
    }

    public User addUser(User user) {
        User newUser = User.builder()
                .username(user.getUsername())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();
        return userRepository.save(newUser);
    }

    public User editUser(User user){
        User currentUser = getUserById(user.getId());

        currentUser.setUsername(user.getUsername());
        currentUser.setFirstName(user.getFirstName());
        currentUser.setLastName(user.getLastName());
        currentUser.setEmail(user.getEmail());

        return userRepository.save(currentUser);


    }






}

package org.example.trivia_server_spring.Service;


import org.example.trivia_server_spring.DTO.CreateUserForm;
import org.example.trivia_server_spring.Model.User;
import org.example.trivia_server_spring.Repository.UserRepository;
import org.example.trivia_server_spring.Util.HashHelper;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        List<User> users = new LinkedList<>();
        userRepository.findAll().forEach(users::add);
        return users.isEmpty() ? users : null;
    }

    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

    public int createUser(CreateUserForm form) throws NoSuchAlgorithmException {
        if(userRepository.findByUsername(form.getUsername()).isPresent()){
            return 409;
        }
        User newUser = new User();
        newUser.setUsername(form.getUsername());
        newUser.setPassword(HashHelper.hashPassword(form.getPassword()));
        newUser.setNum_of_wins(0);

        userRepository.save(newUser);
        return 201;
    }

   public void updateUser(User user){
       User updatedUser = userRepository.save(user);
   }

   public Optional<User> findByUsername(String username){
        Optional<User> user = userRepository.findByUsername(username);
        if(user.isPresent()){
            return user;
        }else{
            return Optional.empty();
        }
   }
}

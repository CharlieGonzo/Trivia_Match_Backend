package org.example.trivia_server_spring.Service;


import org.example.trivia_server_spring.Model.User;
import org.example.trivia_server_spring.Repository.UserRepository;
import org.springframework.stereotype.Service;

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

   public boolean updateUser(User user){
       User updatedUser = userRepository.save(user);
//       if(updatedUser == null || updatedUser.equals(user))

   }
}

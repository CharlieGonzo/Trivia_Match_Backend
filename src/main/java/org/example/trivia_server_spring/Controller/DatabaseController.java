package org.example.trivia_server_spring.Controller;

import org.example.trivia_server_spring.DTO.CreateUserForm;
import org.example.trivia_server_spring.DTO.UserDTO;
import org.example.trivia_server_spring.Model.Question;
import org.example.trivia_server_spring.Model.User;
import org.example.trivia_server_spring.Service.QuestionService;
import org.example.trivia_server_spring.Service.UserService;
import org.example.trivia_server_spring.Util.HashHelper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DatabaseController {

    private final UserService userService;
    private final QuestionService questionService;

    public DatabaseController(UserService userService, QuestionService questionService) {
        this.userService = userService;
        this.questionService = questionService;
    }

    @PostMapping("/test")
    public ResponseEntity<String> test(){
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody CreateUserForm form) throws NoSuchAlgorithmException {
        int status =  userService.createUser(form);
        return ResponseEntity.status(status).build();
    }

    @GetMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody CreateUserForm form) throws NoSuchAlgorithmException {
        String username = form.getUsername();
        String password = form.getPassword();
        Optional<User> user = userService.findByUsername(username);
        if(user.isPresent()){
            if(!HashHelper.hashPassword(password).equals(user.get().getPassword()))
                return ResponseEntity.status(401).build(); // invalid credentials
            UserDTO userDTO = new UserDTO();
            userDTO.setUsername(user.get().getUsername());
            userDTO.setNum_of_wins(user.get().getNum_of_wins());
            userDTO.setId(user.get().getId());
            return ResponseEntity.status(200).body(userDTO);
        }
        return ResponseEntity.status(401).build(); // invalid credentials
    }

    @GetMapping("/randomQuestion")
    public ResponseEntity<Question> getRandomQuestion(){
        Optional<Question> question = questionService.getRandomQuestion();
        return question.map(value -> ResponseEntity.status(200).body(value)).orElseGet(() -> ResponseEntity.status(500).build());
    }

    @PatchMapping("/update")
    public ResponseEntity<String> updateUser(@RequestBody UserDTO userDTO){
        Optional<User> user = userService.findById(userDTO.getId());
        if(user.isPresent()){
            if(!userDTO.getUsername().equals(user.get().getUsername())){
                return ResponseEntity.status(401).build();
            }
            userService.updateUser(user.get());
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(500).build();
    }








}

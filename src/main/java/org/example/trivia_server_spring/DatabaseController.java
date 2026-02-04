package org.example.trivia_server_spring;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DatabaseController {

    @PostMapping("/test")
    public ResponseEntity<String> createAccount(){
        return ResponseEntity.status(201).build();
    }


}

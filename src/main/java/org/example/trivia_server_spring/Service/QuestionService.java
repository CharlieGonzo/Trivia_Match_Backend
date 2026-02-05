package org.example.trivia_server_spring.Service;

import org.example.trivia_server_spring.Model.Question;
import org.example.trivia_server_spring.Repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Optional<Question> getRandomQuestion(){
        return questionRepository.findRandomQuestion();
    }
}

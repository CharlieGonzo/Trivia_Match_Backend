package org.example.trivia_server_spring.Repository;

import org.example.trivia_server_spring.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuestionRepository extends CrudRepository<Question,Long> {

    public Optional<Question> findById(long id);

    @Query(value = "SELECT * FROM QUESTION ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Optional<Question> findRandomQuestion(); // finds random question
}

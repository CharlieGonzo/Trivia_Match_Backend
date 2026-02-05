package org.example.trivia_server_spring.Repository;

import org.example.trivia_server_spring.Model.User;
import org.hibernate.annotations.processing.SQL;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {

    Optional<User> findByUsername(String username);

//    // Native SQL query with a named parameter
//    @Query(value = "SELECT * FROM tutorials t WHERE t.title LIKE %:title%", nativeQuery = true)
//    List<Tutorial> findByTitleUsingNativeQuery(@Param("title") String title);
}

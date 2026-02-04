package org.example.trivia_server_spring.Repository;

import org.example.trivia_server_spring.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}

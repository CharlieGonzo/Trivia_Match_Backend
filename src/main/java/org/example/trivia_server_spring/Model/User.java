package org.example.trivia_server_spring.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "USER_ACCOUNT")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    int num_of_wins;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getNum_of_wins() {
        return num_of_wins;
    }

    public void setNum_of_wins(int num_of_wins) {
        this.num_of_wins = num_of_wins;
    }
}

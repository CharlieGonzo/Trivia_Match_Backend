package org.example.trivia_server_spring.Model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "USER_ACCOUNT")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    int num_of_wins;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return num_of_wins == user.num_of_wins && Objects.equals(id, user.id) && Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, num_of_wins);
    }

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

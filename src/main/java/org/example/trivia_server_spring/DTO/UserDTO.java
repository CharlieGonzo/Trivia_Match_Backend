package org.example.trivia_server_spring.DTO;

public class UserDTO {

     long id;
     String username;
     int num_of_wins;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

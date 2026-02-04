package org.example.trivia_server_spring.web_socket_stuff;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@Controller
public class SocketController {

    private final SimpMessagingTemplate template;

    // dependency injection
    public SocketController(SimpMessagingTemplate template) {
        this.template = template;
    }

    // test unique rooms
    @MessageMapping("{id}")
    public void test(@DestinationVariable String id){
        System.out.println("this method worked");
        template.convertAndSend("/topic/" + id,"hello");
    }
}

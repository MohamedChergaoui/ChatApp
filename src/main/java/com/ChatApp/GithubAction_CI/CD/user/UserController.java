package com.ChatApp.GithubAction_CI.CD.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserServices sservice;
    @MessageMapping("/user.addUser")
    @SendTo("/user/topic")
    public void addUser( @Payload  User user) {
        sservice.saveUser(user);
    }
    @MessageMapping("/user.disconnectUser")
    @SendTo("/user/topic")
    public User disconnect(@Payload User user) {
        sservice.disconnect(user);
        return user;
    }
    @GetMapping("/users")
    public ResponseEntity<List<User>> getConcetedUser() {
        return ResponseEntity.ok(sservice.getConcetedUser());
    }
}

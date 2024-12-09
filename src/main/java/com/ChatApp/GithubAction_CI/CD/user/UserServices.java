package com.ChatApp.GithubAction_CI.CD.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServices  {
      private final UserRepository userRepository;
    public void saveUser(User user) {
        user.setStatus(Status.ONLINE);
        userRepository.save(user);

    }
    public void disconnect(User user)   {
        User userlogedin = userRepository.findById(user.getNakename()).orElse(null);
        if(userlogedin != null) {
            userlogedin.setStatus(Status.OFFLINE);
            userRepository.save(userlogedin);
        }

    }
    public List<User> getConcetedUser() {
        return userRepository.findByStatus(Status.ONLINE);

    }
}

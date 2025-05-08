package com.example.hello.messaging.app;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class UserService {

    public final List<User> users = new ArrayList<>();
    public void add(User user) {
        users.add(user);
    }
    public String getGreeting (String name) {
        return "Hello"+name;
    }
    public String sendMessage (String message) {
        return message;
    }

}

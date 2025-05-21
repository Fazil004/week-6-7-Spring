package com.example.userdetail;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/users")

public class router {

    private List<user> users = new ArrayList<>();

    @PostMapping
    public user addUser(@RequestBody user user) {
        users.add(user);
        return user;

    }
    @GetMapping
    public List<user> getUsers() {
        return users;
    }
    @GetMapping("/{name}")
    public user getUser(@PathVariable String name) {
        for (user user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }
    @DeleteMapping("/{name}")
    public String deleteUser(@RequestParam String name) {
        for (user user : users) {
            if (user.getName().equals(name)) {
                users.remove(user);
                return name+" deleted";
            }
        }
        return "user not found";
    }
}

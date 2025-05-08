package com.example.hello.messaging.app;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping("/hello")
    public String sayHello(@RequestParam(required = false) String name) {
        if (name != null) {
            return "Hello " + name;
        }
        return "Hello World";
    }

    @GetMapping("/hello/{name}")
    public String sayHelloPath(@PathVariable String name) {
        return "Hello " + name;
    }

    // 3. Hello with request body
    @PostMapping("/hello")
    public String sayHelloBody(@RequestBody User user) {
        return "Hello " + user.getFirstName();
    }
}

package com.example.greetingapp.controller;

import com.example.greetingapp.model.Greeting;
import com.example.greetingapp.model.User;
import com.example.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/greetings")
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/hello")
    public String sayHello(@RequestParam(required = false) String name) {
        return greetingService.getSimpleGreeting(name);
    }

    @GetMapping("/hello/{name}")
    public String sayHelloPath(@PathVariable String name) {
        return greetingService.getSimpleGreeting(name);
    }

    @PostMapping("/hello")
    public String sayHelloBody(@RequestBody User user) {
        return greetingService.getPersonalGreeting(user);
    }

    @PostMapping
    public Greeting saveGreeting(@RequestBody Greeting greeting) {
        return greetingService.saveGreeting(greeting);
    }

    @GetMapping("/{id}")
    public Greeting getGreetingById(@PathVariable Long id) {
        return greetingService.getGreetingById(id);
    }

    @GetMapping
    public List<Greeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    @PutMapping("/{id}")
    public Greeting updateGreeting(@PathVariable Long id, @RequestBody Greeting updatedGreeting) {
        return greetingService.updateGreeting(id, updatedGreeting);
    }

    @DeleteMapping("/{id}")
    public void deleteGreeting(@PathVariable Long id) {
        greetingService.deleteGreeting(id);
    }
}
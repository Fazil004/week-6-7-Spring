package com.example.greetingapp.service;

import com.example.greetingapp.model.Greeting;
import com.example.greetingapp.model.User;
import com.example.greetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;

    public String getSimpleGreeting(String name) {
        return (name != null && !name.isEmpty()) ? "Hello " + name : "Hello World";
    }

    public String getPersonalGreeting(User user) {
        if (user.getFirstName() != null && user.getLastName() != null) {
            return "Hello " + user.getFirstName() + " " + user.getLastName();
        } else if (user.getFirstName() != null) {
            return "Hello " + user.getFirstName();
        } else if (user.getLastName() != null) {
            return "Hello " + user.getLastName();
        } else {
            return "Hello World";
        }
    }

    public Greeting saveGreeting(Greeting greeting) {
        return greetingRepository.save(greeting);
    }

    public Greeting getGreetingById(Long id) {
        return greetingRepository.findById(id).orElse(null);
    }

    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    public Greeting updateGreeting(Long id, Greeting updatedGreeting) {
        return greetingRepository.findById(id).map(greeting -> {
            greeting.setMessage(updatedGreeting.getMessage());
            return greetingRepository.save(greeting);
        }).orElse(null);
    }

    public void deleteGreeting(Long id) {
        greetingRepository.deleteById(id);
    }
}
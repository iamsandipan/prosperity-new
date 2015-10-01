package com.prosperity.api.controller;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prosperity.api.model.Greeting;
import com.prosperity.api.model.UserDTO;

@RestController
public class AuthenticationController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greet(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping("/add")
    public UserDTO addUser() {
    	UserDTO user1 = new UserDTO();
    	user1.setEmail("aaa@gmail.com");
        return user1;
    }

}








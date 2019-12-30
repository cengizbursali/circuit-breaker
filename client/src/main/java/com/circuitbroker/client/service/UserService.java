package com.circuitbroker.client.service;

import com.circuitbroker.client.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class UserService {

    private final RestTemplate restTemplate;

    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "fallbackGetUser")
    public User getUserById(Integer id) {
        URI uri = URI.create("http://localhost:4444/users/" + id);
        return this.restTemplate.getForObject(uri, User.class);
    }

    public User fallbackGetUser(Integer id) {
        return new User();
    }
}

package com.springrestjsonapi.user.service;

import com.springrestjsonapi.user.model.User;
import com.springrestjsonapi.user.repository.UserRepository;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final RestTemplate restTemplate;
    private final UserRepository postRepository;

    private final String API_URL = "https://jsonplaceholder.typicode.com/users";

    public UserServiceImpl(RestTemplate restTemplate, UserRepository postRepository) {
        this.restTemplate = restTemplate;
        this.postRepository = postRepository;
    }

    public List<User> getAllUsers() {
        ResponseEntity<User[]> users = restTemplate.getForEntity(API_URL, User[].class);
        return Arrays.asList(users.getBody());
    }
    public User getUserById(Long id) {
        ResponseEntity<User> response = restTemplate.getForEntity(API_URL + "/" + id, User.class);
        return response.getBody();
    }

    public User createUser(User user) {
        ResponseEntity<User> response = restTemplate.postForEntity(API_URL, user, User.class);
        return response.getBody();

    }

    public User updateUser(Long id, User user) {
        user.setId(id);
        restTemplate.put(API_URL + "/" + id, user);
        return getUserById(id);
    }

    public void deleteUser(Long id) {
        restTemplate.delete(API_URL + "/" + id);
    }








}

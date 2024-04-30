package com.example.rakul_socialmedia.service;

import com.example.rakul_socialmedia.dto.*;
import com.example.rakul_socialmedia.model.User;
import com.example.rakul_socialmedia.model.Post;
import com.example.rakul_socialmedia.repository.PostRepository;
import com.example.rakul_socialmedia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.reverse;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Autowired
    public UserService(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public String login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return "User does not exist";
        } else if (!user.getPassword().equals(password)) {
            return "Username/Password Incorrect";
        } else {
            return "Login Successful";
        }
    }

    public String signUp(String email, String name, String password) {
        User existingUser = userRepository.findByEmail(email);
        if (existingUser != null) {
            return "Forbidden, Account already exists";
        } else {
            User newUser = new User();
            newUser.setEmail(email);
            newUser.setName(name);
            newUser.setPassword(password);
            userRepository.save(newUser);
            return "Account Creation Successful";
        }
    }

    public UserDetailResponse getUserDetails(int userID) {
        User user = userRepository.findById(userID).orElse(null);
        if (user == null) {
            return null;
        } else {
            UserDetailResponse response = new UserDetailResponse();
            response.setName(user.getName());
            response.setUserID(user.getId());
            response.setEmail(user.getEmail());
            return response;
        }
    }

    public List<AllUsersResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<AllUsersResponse> userResponses = new ArrayList<>();
        for (User user : users) {
            AllUsersResponse allusersResponse = new AllUsersResponse(user);
            userResponses.add(allusersResponse);
        }
        return userResponses;
    }

    public List<PostResponse> getUserFeed() {
        List<Post> posts = postRepository.findAll();
        reverse(posts);
        List<PostResponse> userResponses = new ArrayList<>();
        for (Post post : posts) {
            PostResponse postResponse = new PostResponse(post);
            userResponses.add(postResponse);
        }
        return userResponses;
    }
}

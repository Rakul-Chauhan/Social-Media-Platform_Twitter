package com.example.rakul_socialmedia.controller;

import com.example.rakul_socialmedia.dto.*;
import com.example.rakul_socialmedia.model.User;
import com.example.rakul_socialmedia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLogin userLogin) {
        String result = userService.login(userLogin.getEmail(), userLogin.getPassword());
        if (result.equals("Login Successful")) {
            return ResponseEntity.ok(result);
        } else {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("Error", result);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody UserSignUp userSignup) {
        String result = userService.signUp(userSignup.getEmail(), userSignup.getName(), userSignup.getPassword());
        if (result.equals("Account Creation Successful")) {
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } else {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("Error", result);
            return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
        }
    }

    @GetMapping("/user")
    public ResponseEntity<?> getUserDetails(@RequestParam int userID) {
        UserDetailResponse userDetailResponse = userService.getUserDetails(userID);
        if (userDetailResponse == null) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("Error", "User does not exist");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        } else {
            return ResponseEntity.ok(userDetailResponse);
        }
    }

    @GetMapping("/users")
    public ResponseEntity<List<AllUsersResponse>> getAllUsers() {
        List<AllUsersResponse> userResponses = userService.getAllUsers();
        return ResponseEntity.ok(userResponses);
    }

    @GetMapping("/")
    public ResponseEntity<?> getUserFeed() {
        List<PostResponse> PostResponse = userService.getUserFeed();
            return ResponseEntity.ok(PostResponse);
    }

}

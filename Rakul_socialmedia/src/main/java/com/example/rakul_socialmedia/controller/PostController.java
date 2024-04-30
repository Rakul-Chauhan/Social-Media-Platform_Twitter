package com.example.rakul_socialmedia.controller;

import com.example.rakul_socialmedia.dto.*;
import com.example.rakul_socialmedia.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/post")
    public ResponseEntity<?> createPost(@RequestBody PostRequest postRequest) {
        String result = postService.createPost(postRequest);
        if (result.equals("Post created successfully")) {
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } else {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("Error", result);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @PatchMapping("/post")
    public ResponseEntity<?> editPost(@RequestBody EditPostRequest editPostRequest) {
        String result = postService.editPost(editPostRequest);
        if (result.equals("Post edited successfully")) {
            return ResponseEntity.ok(result);
        } else {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("Error", result);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @DeleteMapping("/post")
    public ResponseEntity<?> deletePost(@RequestParam int postID) {
        String result = postService.deletePost(postID);
        if (result.equals("Post deleted")) {
            return ResponseEntity.ok(result);
        } else {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("Error", result);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @PostMapping("/comment")
    public ResponseEntity<?> createComment(@RequestBody CommentRequest commentRequest) {
        String result = postService.createComment(commentRequest);
        if (result.equals("Comment created successfully")) {
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } else {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("Error", result);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @GetMapping("/comment")
    public ResponseEntity<?> getComment(@RequestParam int commentID) {
        CommentResponse commentResponse = postService.getComment(commentID);
        if (commentResponse == null) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("Error", "Comment does not exist");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        } else {
            return ResponseEntity.ok(commentResponse);
        }
    }

    @PatchMapping("/comment")
    public ResponseEntity<?> editComment(@RequestBody EditCommentRequest editCommentRequest) {
        String result = postService.editComment(editCommentRequest);
        if (result.equals("Comment edited successfully")) {
            return ResponseEntity.ok(result);
        } else {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("Error", result);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @DeleteMapping("/comment")
    public ResponseEntity<?> deleteComment(@RequestParam int commentID) {
        String result = postService.deleteComment(commentID);
        if (result.equals("Comment deleted")) {
            return ResponseEntity.ok(result);
        } else {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("Error", result);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @GetMapping("/post")
    public ResponseEntity<?> getPost(@RequestParam int postID) {
        PostResponse postResponse = postService.getPost(postID);
        if (postResponse == null) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("Error", "Post does not exist");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        } else {
            return ResponseEntity.ok(postResponse);
        }
    }
}

package com.example.rakul_socialmedia.service;

import com.example.rakul_socialmedia.dto.*;
import com.example.rakul_socialmedia.model.Comment;
import com.example.rakul_socialmedia.model.Post;
import com.example.rakul_socialmedia.model.User;
import com.example.rakul_socialmedia.repository.CommentRepository;
import com.example.rakul_socialmedia.repository.UserRepository;
import com.example.rakul_socialmedia.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class PostService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;


    @Autowired
    public PostService(UserRepository userRepository, PostRepository postRepository, CommentRepository commentRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }


    public String createPost(PostRequest postRequest) {
        User user = userRepository.findById(postRequest.getUserID()).orElse(null);
        if (user == null) {
            return "User does not exist";
        } else {
            Post post = new Post();
            post.setPostBody(postRequest.getPostBody());
            post.setUser(user);

            post.setDate(new Date());
            postRepository.save(post);
            return "Post created successfully";
        }
    }

    public String editPost(EditPostRequest editPostRequest) {
        Post post = postRepository.findById(editPostRequest.getPostID()).orElse(null);
        if (post == null) {
            return "Post does not exist";
        } else {
            post.setPostBody(editPostRequest.getPostBody());
            postRepository.save(post);
            return "Post edited successfully";
        }
    }

    public String deletePost(int postID) {
        Optional<Post> optionalPost = postRepository.findById(postID);
        if (optionalPost.isEmpty()) {
            return "Post does not exist";
        } else {
            postRepository.delete(optionalPost.get());
            return "Post deleted";
        }
    }

    public String createComment(CommentRequest commentRequest) {
        User user = userRepository.findById(commentRequest.getUserID()).orElse(null);
        if (user == null) {
            return "User does not exist";
        }

        Post post = postRepository.findById(commentRequest.getPostID()).orElse(null);
        if (post == null) {
            return "Post does not exist";
        }

        Comment comment = new Comment();
        comment.setCommentBody(commentRequest.getCommentBody());
        comment.setUser(user);
        comment.setPost(post);
        commentRepository.save(comment);

        return "Comment created successfully";
    }

    public CommentResponse getComment(int commentID) {
        Comment comment = commentRepository.findById(commentID).orElse(null);
        if (comment == null) {
            return null;
        } else {
            return new CommentResponse(comment);
        }
    }

    public String editComment(EditCommentRequest editCommentRequest) {
        Comment comment = commentRepository.findById(editCommentRequest.getCommentID()).orElse(null);
        if (comment == null) {
            return "Comment does not exist";
        } else {
            comment.setCommentBody(editCommentRequest.getCommentBody());
            commentRepository.save(comment);
            return "Comment edited successfully";
        }
    }

    public String deleteComment(int commentID) {
        Comment comment = commentRepository.findById(commentID).orElse(null);
        if (comment == null) {
            return "Comment does not exist";
        } else {
            commentRepository.delete(comment);
            return "Comment deleted";
        }
    }

    public PostResponse getPost(int postID) {
        Post post = postRepository.findById(postID).orElse(null);
        if (post == null) {
            return null;
        } else {
            return new PostResponse(post);
        }
    }
}

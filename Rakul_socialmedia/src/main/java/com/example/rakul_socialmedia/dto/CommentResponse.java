package com.example.rakul_socialmedia.dto;

import com.example.rakul_socialmedia.model.Comment;

public class CommentResponse {

    private int commentID;
    private String commentBody;
    private UserCommentResponse commentCreator;

    public CommentResponse(Comment comment) {
        this.commentID = comment.getCommentID();
        this.commentBody = comment.getCommentBody();
        this.commentCreator = new UserCommentResponse(comment.getUser());
    }

    // Getters and setters

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public String getCommentBody() {
        return commentBody;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }

    public UserCommentResponse getCommentCreator() {
        return commentCreator;
    }

    public void setCommentCreator(UserCommentResponse commentCreator) {
        this.commentCreator = commentCreator;
    }
}


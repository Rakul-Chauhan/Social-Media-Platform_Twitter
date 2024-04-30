package com.example.rakul_socialmedia.dto;

public class EditCommentRequest {

    private int commentID;
    private String commentBody;

    // Constructors, getters, and setters

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
}


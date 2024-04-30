package com.example.rakul_socialmedia.dto;

public class EditPostRequest {

    private int postID;
    private String postBody;

    // Constructors, getters, and setters

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }
}


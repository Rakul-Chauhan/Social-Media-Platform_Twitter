package com.example.rakul_socialmedia.dto;

public class PostRequest {

    private String postBody;
    private int userID;

    // Constructors, getters, and setters

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}

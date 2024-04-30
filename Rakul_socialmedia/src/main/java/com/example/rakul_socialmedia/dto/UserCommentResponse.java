package com.example.rakul_socialmedia.dto;

import com.example.rakul_socialmedia.model.User;

public class UserCommentResponse {

    private int userID;
    private String name;

    public UserCommentResponse(User user) {
        this.userID = user.getId();
        this.name = user.getName();
    }


    // Getters and setters

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


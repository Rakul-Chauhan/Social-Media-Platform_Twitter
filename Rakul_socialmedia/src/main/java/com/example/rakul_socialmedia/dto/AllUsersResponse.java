package com.example.rakul_socialmedia.dto;

import com.example.rakul_socialmedia.model.User;

public class AllUsersResponse {

    private String name;
    private int userID;
    private String email;

    public AllUsersResponse(User user) {

        this.name = user.getName();
        this.userID = user.getId();
        this.email = user.getEmail();
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


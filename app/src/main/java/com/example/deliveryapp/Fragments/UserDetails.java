package com.example.deliveryapp.Fragments;

public class UserDetails {
    private String username;


    public UserDetails(){

    }
    public UserDetails(String username){
        this.username=username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}


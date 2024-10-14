package com.example.loginandroid_29_09_2023.beans;

public class User {
    private String id;
    private String password; // Puedes agregar otros campos según tus necesidades

    public User(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getters y setters
}

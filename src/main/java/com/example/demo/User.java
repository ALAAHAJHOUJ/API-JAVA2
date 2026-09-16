package com.example.demo;

import jakarta.validation.constraints.NotBlank;

public class User {

    @NotBlank
    private String nom;

    @NotBlank
    private String password;

    public User(String nom, String password) {
        this.nom = nom;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}

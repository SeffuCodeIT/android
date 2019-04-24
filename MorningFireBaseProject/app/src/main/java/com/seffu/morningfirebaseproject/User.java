package com.seffu.morningfirebaseproject;

public class User {
     String name,email,idNo,key;

    public User(String name, String email, String idNo, String key) {
        this.name = name;
        this.email = email;
        this.idNo = idNo;
        this.key = key;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getIdNo() {
        return idNo;
    }

    public String getKey() {
        return key;
    }
}





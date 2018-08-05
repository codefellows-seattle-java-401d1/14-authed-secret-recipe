package com.example.AuthorizationDemo.models;

import server.pojo.UserPojo;
import org.mindrot.jbcrypt.BCrypt;

public class User {
    private static final String DEFAULT_NAME = "Unknown name";
    private static final String DEFAULT_PASS = "Unknown password";

    public int id;
    public String username;
    private String passhash;

    public User(){
        this(DEFAULT_NAME, DEFAULT_PASS);
    }

    public User(String username, String password) {

        this(username, password, "");
    }

    public User(UserPojo user) {
        this(user.username, user.password, user.bio);
    }
    public User(String username, String password) {

        this(-1, username, password);
    }

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.passhash = password;
    }

    public boolean checkPassword(String attempt) {
        boolean result = BCrypt.checkpw(attempt, this.passhash);
        return result;
    }
}

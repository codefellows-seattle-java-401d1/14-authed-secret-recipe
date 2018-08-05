package com.example.AuthDemo.models;

import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;

import javax.validation.constraints.AssertTrue;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void checkPassword() {
        // Known bug: Per class and review of Brandon Fenty's project
        // Database was returning values with lots of empty whitespace
        // at the end. of password field
        String hashed = BCrypt.hashpw("test", BCrypt.gensalt(12));
        hashed = "$2a$12$hFoFQ6LlPy5rNYDeB85Qu.XQDxPtIKtvhKuLptsP1mrXI6DiIHGLO                    ";
        User user = new User(1, "test", hashed, "test");
        boolean isPass = user.checkPassword("test");
        assertFalse(isPass);
    }
}
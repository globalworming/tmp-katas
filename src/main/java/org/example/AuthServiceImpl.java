package org.example;

import org.example.api.AuthService;

import java.util.List;

public class AuthServiceImpl implements AuthService {

    private final List<String> validUsers = List.of("admin", "peter", "lisa");
    public void validate(String user) {
        if (!validUsers.contains(user)) {
            throw new IllegalStateException("invalid user");
        }
    }
}

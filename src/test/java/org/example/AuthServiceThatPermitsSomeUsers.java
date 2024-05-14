package org.example;

import org.example.api.AuthService;

import java.util.List;

public class AuthServiceThatPermitsSomeUsers implements AuthService {
    
    private final List<String> validUsers;

    public AuthServiceThatPermitsSomeUsers(List<String> validUsers) {
        this.validUsers = validUsers;
    }

    @Override
    public void validate(String user) throws IllegalStateException {
        if (!validUsers.contains(user)) {
            throw new IllegalStateException("invalid user");
        }
    }
}

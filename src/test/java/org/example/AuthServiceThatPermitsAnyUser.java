package org.example;

import org.example.api.AuthService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;

public class AuthServiceThatPermitsAnyUser implements AuthService {
    @Override
    public void validate(String user) throws IllegalStateException {

    }
}

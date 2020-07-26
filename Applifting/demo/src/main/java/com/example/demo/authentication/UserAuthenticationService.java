package com.example.demo.authentication;

import com.example.demo.models.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface UserAuthenticationService {

    /** Logs in with the given {@code username} and {@code password}.
     * @param username username
     * @param password password
     * @return an {@link Optional} of a user when login succeeds
     */
    String login(String username, String password);

    /**
     * Finds a user by its dao-key.
     *
     * @param token user dao key
     * @return User object or null
     */
    Optional<User> findByToken(String token);


}

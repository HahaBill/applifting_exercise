package com.example.demo.authentication;

import com.example.demo.authentication.UserAuthenticationService;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@Service
@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = PRIVATE)
public class UUIDAuthenticationService implements UserAuthenticationService {

    @NonNull
    @Autowired
    UserRepository userRepository;

    @Override
    public String login(String username, String password) {
        final String uuid = UUID.randomUUID().toString();

//        User loginUser = userRepository.findByName(username);
//        loginUser.setAccessToken(uuid);
//        userRepository.save(loginUser);

        return uuid;
    }

    @Override
    public Optional<User> findByToken(String token) {
        return Optional.empty();
    }
}

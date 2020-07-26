package com.example.demo.service;

import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.models.User;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    /**
    This method find all the users in
    the database - not in the requirement
     */
    public List<User> findAll() {
        return userRepository.findAll();
    }

    /**
    CRUD operations on users not required, therefore creating
    a user and adding it into the database
     */
    public void addUsers() {

        /**
        if there are already users in the database, do not
        create more users
         */
        if(userRepository.count() > 0) {
            return;
        }

        String forFirst = UUID.randomUUID().toString();
        User first = new User(1, "Appfliting", "applifting@gmail.com", forFirst );

        userRepository.save(first);
    }

}

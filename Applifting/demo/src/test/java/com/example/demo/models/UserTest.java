package com.example.demo.models;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing "User" model
 */
public class UserTest {

    User first;
    User second;


    @BeforeEach
    public void setUp(){
        first = new User(1, "alex", "alex@alex", "aleex");
        first.setId(0);
        second = first = new User(1, "alex", "alex@alex", "aleex");
        second.setId(0);
    }

    @Test
    public void testConstructor()
    {
        int id = 1;
        String name = "t";
        String email = "a@a.com";
        String accessToken = "e";

        User user = new User(id ,name,email, accessToken);

        assertThat(id).isEqualTo(user.getId());
        assertEquals(name, user.getUserName());
        assertEquals(email, user.getEmail());
        assertEquals(accessToken, user.getAccessToken());
    }

    @Test
    public void nullTest(){
        assertFalse(first.equals(null));
    }

    @Test
    public void sameUserTest(){
        assertTrue(first.equals(first));
    }

    @Test
    public void diffClassTest(){
        assertFalse(first.equals(5));
    }

    @Test
    public void sameIdTest(){
        assertTrue(first.equals(second));
    }

    @Test
    public void diffIdTest(){
        User third = new User(0, "alex", "alex@alex", "aleex");
        third.setId(20000);
        assertFalse(first.equals(third));
    }

}

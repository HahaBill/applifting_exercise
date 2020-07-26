package com.example.demo.repository;

import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

//    /** findByName.
//     *
//     * @param name of the USER that you want to fetch from DB
//     * @return USER OBJECT corresponding with the given name of the user
//     */
////    @Query()
////    User findByName(String name);

//    @Query("SELECT * FROM user")
    List<User> findAll();

}

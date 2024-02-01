package com.CustomerManagement.customerManagement.DAO;

import com.CustomerManagement.customerManagement.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//This is Repository for user
@Repository
public interface UserRepository extends JpaRepository<User, String> {

    //custom query for searching user with username
    @Query(value = "SELECT * FROM user u WHERE u.username = :username", nativeQuery = true)
    Optional<User> findByUsername(@Param("username") String username);
}

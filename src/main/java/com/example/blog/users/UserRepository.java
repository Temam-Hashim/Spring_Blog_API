package com.example.blog.users;

import org.aspectj.apache.bcel.util.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users,Long> {

    @Query("SELECT u from Users u where u.email=?1")
    Optional<Users> findUsersByEmail(String email);

}

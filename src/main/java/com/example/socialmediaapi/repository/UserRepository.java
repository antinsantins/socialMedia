package com.example.socialmediaapi.repository;

import com.example.socialmediaapi.entity.StatusEnum;
import com.example.socialmediaapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByStatus(StatusEnum status);
    public Optional<User> findByName(String name);
}
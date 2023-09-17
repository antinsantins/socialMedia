package com.example.socialmediaapi.repository;

import com.example.socialmediaapi.entity.StatusEnum;
import com.example.socialmediaapi.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, PagingAndSortingRepository<User, Long>, JpaSpecificationExecutor<User> {
    public Optional<User> findByName(String name);
    List<User> findAllByStatus(String status, Pageable pageable);
}
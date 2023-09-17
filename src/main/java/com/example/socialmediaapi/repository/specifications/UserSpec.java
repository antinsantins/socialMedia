package com.example.socialmediaapi.repository.specifications;

import com.example.socialmediaapi.entity.StatusEnum;
import com.example.socialmediaapi.entity.User;
import org.springframework.data.jpa.domain.Specification;

public class UserSpec {
    public static Specification<User> statusContains(String status) {
        return (Specification<User>) (root, criteriaQuery, criteriaBuilder)
            -> criteriaBuilder.like(root.get("status"), status);
    }
}

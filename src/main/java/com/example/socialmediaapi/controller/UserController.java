package com.example.socialmediaapi.controller;

import com.example.socialmediaapi.entity.User;
import com.example.socialmediaapi.repository.specifications.UserSpec;
import com.example.socialmediaapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
//    @GetMapping()
//    public String showUserList(Model model,
//                               @RequestParam(value = "status", required = false) String status) {
//        Specification<User> specification = Specification.where(null);
//        if (status != null) {
//            specification = specification.and(UserSpec.statusContains(status));
//        }
//        User user = new User();
//        model.addAttribute("user", user);
//        model.addAttribute("status",status);
//        return "users";
//    }
@GetMapping()
public String showUserList(Model model,
                           @RequestParam(value = "status", required = false) String status) {
    Specification<User> filter = Specification.where(null);
    if (status != null) {
        filter = filter.and(UserSpec.statusContains(status));
    }
    List<User> users = userService.getUserWithPagingAndFiltering(filter, PageRequest.of(1, 5)).getContent();
    User user = new User();
    model.addAttribute("users",users);
    model.addAttribute("user", user);
    model.addAttribute("status",status);
    return "users";
}


}

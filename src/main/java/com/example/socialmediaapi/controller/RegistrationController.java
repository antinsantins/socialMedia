package com.example.socialmediaapi.controller;

import com.example.socialmediaapi.entity.StatusEnum;
import com.example.socialmediaapi.entity.User;
import com.example.socialmediaapi.entity.UserRoleEnum;
import com.example.socialmediaapi.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@AllArgsConstructor
@RequestMapping("/registration")
public class RegistrationController {
    UserService userService;
    @GetMapping()
    public String registration(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }
    @PostMapping()
    public String registration(@ModelAttribute("user") @Validated User user, Model model) {
        userService.saveUser(user);
        return "redirect:/login";
    }

}

package com.example.socialmediaapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @GetMapping("/")
    public String main() {
        return "main";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }


}

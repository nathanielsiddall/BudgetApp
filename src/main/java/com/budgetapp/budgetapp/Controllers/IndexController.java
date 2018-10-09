package com.budgetapp.budgetapp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @GetMapping("/")
    public String hello() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}

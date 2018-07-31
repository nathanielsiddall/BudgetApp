package com.siddall.budgetapp.Controllers;

import com.siddall.budgetapp.DAOs.UserDataAccess;
import com.siddall.budgetapp.Models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {


    @GetMapping("/")


    public String home(Model model, User user){
        model.addAttribute("User", user);
        return "index";

    }



    @PostMapping("/")
    public String login(
            @RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password
            ){

        UserDataAccess dao = new UserDataAccess();
       User user = dao.findByUsername(username);
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        return "home";
    }
}

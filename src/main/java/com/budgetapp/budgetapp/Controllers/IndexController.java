package com.budgetapp.budgetapp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class IndexController {

    private String data = "";

    @GetMapping("/")
    public String hello() {return "index";}

    @GetMapping("/login")
    public String login() {return "login";}

    @PostMapping("/login")
    public void authenticate(
            @RequestParam(name = "username") String username,
            @RequestParam(name= "password") String password
    ){
        System.out.println("working");
        System.out.println(username);
        System.out.println(password);
        data = "very nice";

//        if (username.equalsIgnoreCase("fuck") && password.equalsIgnoreCase("yes")){
//            System.out.println("this worked");
//        }else {
//
//        }
    }
    @GetMapping("/logincheck")
    @ResponseBody
    public String wrongPassword(){
        return data;

    }

}

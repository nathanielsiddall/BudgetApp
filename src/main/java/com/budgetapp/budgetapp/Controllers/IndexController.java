package com.budgetapp.budgetapp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {
    private String getResponse() {
        return response;
    }

    private void setResponse(String response) {
        this.response = response;
    }

    private String response = "deafult ryerytertertertyertyrtyerty";

    @GetMapping("/")
    public String hello() {return "index";}

    @GetMapping("/login")
    public String login() {return "login";}

    @PostMapping("/login")
    public void authenticate(
            @RequestParam(name = "username") String username,
            @RequestParam(name= "password") String password
    ){
        setResponse("authenicate response set");
        System.out.println("authenicate run test");
        System.out.println(username);
        System.out.println(password);


//        if (username.equalsIgnoreCase("fuck") && password.equalsIgnoreCase("yes")){
//            System.out.println("this worked");
//        }else {
//
//        }
    }
    @ResponseBody()
    @RequestMapping(value = "/logincheck", method = RequestMethod.GET, produces = "application/json")
    public String wrongPassword(){
        System.out.println("wrongPassword run test");
        System.out.println(getResponse());
        System.out.println("-------------------------");
        return getResponse();
    }
}

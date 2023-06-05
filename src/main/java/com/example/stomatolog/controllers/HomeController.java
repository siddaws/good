package com.example.stomatolog.controllers;


import com.example.stomatolog.EmailMessage;
import com.example.stomatolog.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model){

        return "home";
    }
    @GetMapping("/services")
    public String services(){

        return "services";
    }  @GetMapping("/contacts")
    public String contacts(){
        return "contacts";
    }
    @GetMapping("/message")
    public String message(){

        return "message";
    }
    @PostMapping("/message")
    private   String message(@RequestParam String name,@RequestParam String number,Model model){
        User user = new User(name,number);
        model.addAttribute("user",user);
        EmailMessage emailMessage = new EmailMessage();
        emailMessage.message(user.getName(), user.getNumber());
        return "redirect:/";

    }
    @PostMapping("/addReviews")
    private String addReviews(@RequestParam String name,@RequestParam String text, Model model){


        return "addReviews";
    }


}

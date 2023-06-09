package com.example.stomatolog.controllers;


import com.example.stomatolog.EmailMessage;
import com.example.stomatolog.models.Reviews;
import com.example.stomatolog.repo.AddReviewsRepository;
import com.example.stomatolog.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    private AddReviewsRepository addReviewsRepository;

    @Autowired
    public void setAddReviewsRepository(AddReviewsRepository addReviewsRepository) {
        this.addReviewsRepository = addReviewsRepository;
    }
    @GetMapping("/")
    public String home(){

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
    public String message(@RequestParam String name,@RequestParam String number,Model model){
        User user = new User(name,number);
        model.addAttribute("user",user);
        EmailMessage emailMessage = new EmailMessage();
        emailMessage.message(user.getName(), user.getNumber());
        return "redirect:/";

    }   @GetMapping("/addReviews")
    public String addReviews(){

        return "addReviews";
    }
    @PostMapping("/addReviews")
    public String addReviews(@RequestParam String name,@RequestParam String text,Model model){
        Reviews reviews = new Reviews(name,text);
        addReviewsRepository.save(reviews);
        return "redirect:/reviews";
        }
    @GetMapping("/reviews")
    public String review(Model model){
        List<Reviews> reviews = (List<Reviews>) addReviewsRepository.findAll();
        model.addAttribute("reviews", reviews);
        return "reviews";
    }





}

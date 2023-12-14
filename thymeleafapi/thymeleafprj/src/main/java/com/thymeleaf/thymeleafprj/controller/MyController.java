package com.thymeleaf.thymeleafprj.controller;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MyController {

    @RequestMapping(value="/about",method = RequestMethod.GET)
    public String about(Model model)
    {
        System.out.println("about handler...");
model.addAttribute("name", "Nikhil");
model.addAttribute("date", new Date().toString());
        return "about";
    }

        @GetMapping("/iterate")
    public String iterateHandler(Model model)
    {
        System.out.println("iterate handler...");
        List<String> list=List.of("N","I","K","H","I","Ls");
model.addAttribute("list",list);
        return "iterate";
    }

    @GetMapping("/condition")
    public String conditionHandler(Model model)
    {
        System.out.println("condition handler...");
        model.addAttribute("isActive", true);
        model.addAttribute("gender", 'M');
        List<String> list=List.of("xx");
        model.addAttribute("mylist", list);
        return "condition";
    }

    @GetMapping("/services")
    public String fragmentHandler(Model model)
    {
        System.out.println("fragment handler...");
        model.addAttribute("title", "nikhil");
        model.addAttribute("subtitle", "I'm SE");
        return "services";
    }

    @GetMapping("/aboutnew")
    public String aboutnewHandler(Model model)
    {
        System.out.println("about new handler...");
        return "aboutnew";
    }

    @GetMapping("/contact")
    public String contactHandler(Model model)
    {
        System.out.println("contact handler...");
        return "contact";
    }
    
}

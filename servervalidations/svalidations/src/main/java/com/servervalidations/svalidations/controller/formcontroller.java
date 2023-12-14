package com.servervalidations.svalidations.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.servervalidations.svalidations.entities.LoginData;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class formcontroller {
 
    @GetMapping("/form")
    public String formHandler(Model model)
    {
        System.out.println("form handler...");
        model.addAttribute("loginData", new LoginData());
        return "form";
    }
    @PostMapping("/process")
    public String processformHandler(@Valid @ModelAttribute("loginData") LoginData loginData,BindingResult result) {
       if(result.hasErrors()){System.out.println(result);return "form";}
       System.out.println(loginData);
        return "success";
    }

    @RequestMapping("/addcssandjs")
    public String addCssAndJs() {
  System.out.println("here we go for add css and js");
        return "addcssandjs" ;
    }
    
    
}

package com.example.demo.business;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/languages")
public class LanguageController {

    @RequestMapping("/greeting")
    public String greeting(Model model) {
        model.addAttribute("message", "error");
        return "error";
    }
}

package com.example.demospringboot.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HelloController {


    @GetMapping("/pedulikanker")
    public String index(){
    return "pedulikanker";
    }
    @GetMapping("/lakukandonasi")
    public String mendonasi(){
    return "lakukandonasi";
    }

    @GetMapping("/contact")
    public String kontak(){
    return "contact";
    }


}
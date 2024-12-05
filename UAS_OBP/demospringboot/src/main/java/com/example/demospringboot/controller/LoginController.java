package com.example.demospringboot.controller;

import com.example.demospringboot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Menampilkan halaman login.html
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {
        if (loginService.validateUser(username, password)) {
            return "redirect:/admin"; // Jika login berhasil, redirect ke /admin
        } else {
            model.addAttribute("error", "Username atau Password salah");
            return "login"; // Kembali ke halaman login dengan pesan error
        }
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin"; // Menampilkan halaman admin.html
    }
}

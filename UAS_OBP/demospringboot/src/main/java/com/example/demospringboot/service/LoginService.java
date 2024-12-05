package com.example.demospringboot.service;

import com.example.demospringboot.entity.Login;
import com.example.demospringboot.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public boolean validateUser(String username, String password) {
        Login user = loginRepository.findByUsername(username);
        // Validasi jika user ditemukan dan password cocok
        return user != null && user.getPassword().equals(password);
    }
}

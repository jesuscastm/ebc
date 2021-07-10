package com.ebc.ventas.controller;

import com.ebc.ventas.entity.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ventas")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/mensaje")
    public String mensaje() {
        return "mensaje";
    }

    @RequestMapping("viewUsers")
    public String viewUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "view-users";
    }
}

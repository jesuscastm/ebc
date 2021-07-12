package com.ebc.ventas.controller;

import com.ebc.ventas.entity.User;
import com.ebc.ventas.entity.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


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

    @RequestMapping("newUser")
    public String newUser(Model model)  {
        model.addAttribute("user", new User());
        return "new-user";
    }

    @PostMapping(value="newUser")
    public RedirectView newUser(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {
            final RedirectView redirectView= new RedirectView("/ventas/newUser", true); 
            user.setDeleted(Boolean.FALSE);
            user.setVisits(0);
            User savedUser = userRepository.save(user);
            redirectAttributes.addFlashAttribute("newUser", savedUser);
            redirectAttributes.addFlashAttribute("newUserSuccess", true);
            return redirectView;
    }
    
}

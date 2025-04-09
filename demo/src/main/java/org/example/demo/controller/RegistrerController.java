package org.example.demo.controller;

import org.example.demo.model.User;
import org.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegistrerController {

    @Autowired
    private UserService userService;

    @GetMapping("/registrer")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "registrer";
    }

    @PostMapping("/registrer")
    public String processRegistration(
            @ModelAttribute("user") User user,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "registrer";
        }
        try {
            userService.registerUser(user);
            redirectAttributes.addFlashAttribute("registrationSuccess",
                    "Bruker " + user.getPhone() + " ble registrert! Du kan nå logge inn.");

            return "redirect:/login";
        } catch (Exception e) {
            model.addAttribute("registrationError", "Registrering feilet: " + e.getMessage());
            user.setPassword(null);
            return "registrer";
        }
    }
}
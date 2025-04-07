package org.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistrerController {

    @GetMapping("/registrer")
    public String showRegisterForm() {
        return "registrer";
    }
}

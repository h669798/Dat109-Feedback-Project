package org.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard"; // Laster dashboard.html fra templates/
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin"; // Laster admin.html
    }

    @GetMapping("/stats")
    public String stats() {
        return "stats"; // Laster stats.html
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Laster login.html
    }

    @GetMapping("/registrer")
    public String registrerPage() {
        return "registrer"; // Laster registrer.html
    }
}

package org.example.demo.controller;

import org.example.demo.service.FeedbackService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        // Retrieve feedback from the database and add to model
        model.addAttribute("feedbacks", FeedbackService.getAllFeedback());
        return "dashboard";  // This will render dashboard.html
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login";  // Redirect to login page after logout
    }
}

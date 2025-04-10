package org.example.demo.controller;

import org.example.demo.model.Lecture;
import org.example.demo.model.User;
import org.example.demo.service.FeedbackService;
import org.example.demo.service.LectureService;
import org.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    private LectureService lectureService;

    @Autowired
    private UserService userService;

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        // 1. Finn innlogget bruker:
        String phone = SecurityContextHolder.getContext().getAuthentication().getName();
        User currentUser = userService.getUserByPhone(phone);

        // 2. Hent forelesninger for denne læreren:
        List<Lecture> lectures = lectureService.getLecturesByLecturer(currentUser);

        // 3. Legg forelesningene i model:
        model.addAttribute("lectures", lectures);

        return "dashboard";
    }
}

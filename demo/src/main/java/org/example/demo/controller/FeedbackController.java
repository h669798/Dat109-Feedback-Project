package org.example.demo.controller;

import org.example.demo.service.FeedbackService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/give")
    public String giveFeedback(@RequestParam Long lectureId,
                               @RequestParam String type,
                               Model model) {
        feedbackService.submitFeedback(lectureId, type);
        model.addAttribute("message", "Takk for tilbakemeldingen!");
        return "feedback"; // templates/feedbackSuccess.html
    }

    @GetMapping("/lecture/{lectureId}")
    public String getFeedbackForLecture(@PathVariable Long lectureId, Model model) {
        model.addAttribute("feedbackList", feedbackService.getFeedbackForLecture(lectureId));
        return "feedback"; // templates/feedbackForLecture.html
    }

    @GetMapping("/student/{studentId}")
    public String getFeedbackByStudent(@PathVariable Long studentId, Model model) {
        model.addAttribute("feedbackList", feedbackService.getFeedbackByStudent(studentId));
        return "feedback"; // templates/feedbackByStudent.html
    }
}

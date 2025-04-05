package org.example.demo.controller;

import org.example.demo.model.Feedback;
import org.example.demo.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    // Gi anonym tilbakemelding på en forelesning (kun studenter)
    @PostMapping("/give")
    public String giveFeedback(@RequestParam Long lectureId,
                               @RequestParam String type,
                               Model model) {
        feedbackService.submitFeedback(lectureId, type);
        model.addAttribute("message", "Takk for tilbakemeldingen!");
        return "feedbackSuccess"; // JSP-siden som skal vises etter innsendelse
    }

    
    @GetMapping("/lecture/{lectureId}")
    public String getFeedbackForLecture(@PathVariable Long lectureId, Model model) {
        List<Feedback> feedbackList = feedbackService.getFeedbackForLecture(lectureId);
        model.addAttribute("feedbackList", feedbackList);
        return "feedbackForLecture";
    }

    @GetMapping("/student/{studentId}")
    public String getFeedbackByStudent(@PathVariable Long studentId, Model model) {
        List<Feedback> feedbackList = feedbackService.getFeedbackByStudent(studentId);
        model.addAttribute("feedbackList", feedbackList);
        return "feedbackByStudent";
    }
}

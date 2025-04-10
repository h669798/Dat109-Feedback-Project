package org.example.demo.controller;

import org.example.demo.model.Feedback;
import org.example.demo.model.FeedbackType;
import org.example.demo.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    // Gi tilbakemelding (uten student = anonym)
    @PostMapping("/give")
    public String giveFeedback(@RequestParam Long lectureId,
                               @RequestParam String type,
                               @RequestParam(required = false) String phone,
                               @RequestParam(required = false) String comment,
                               Model model) {
        Feedback feedback = new Feedback();
        feedback.setType(FeedbackType.valueOf(type.toUpperCase())); // Konverterer string til enum
        feedback.setComment(comment);

        feedbackService.submitFeedback(lectureId, phone, feedback);

        model.addAttribute("message", "Takk for tilbakemeldingen!");
        return "feedback"; // f.eks. feedback.html
    }

    @GetMapping
    public String showFeedbackPage() {
        return "feedback";
    }

    // Vis tilbakemeldinger for én forelesning
    @GetMapping("/lecture/{lectureId}")
    public String getFeedbackForLecture(@PathVariable Long lectureId, Model model) {
        model.addAttribute("feedbackList", feedbackService.getFeedbackForLecture(lectureId));
        return "feedbackForLecture"; // f.eks. feedbackForLecture.html
    }

    // Vis tilbakemeldinger for én student (basert på mobil)
    @GetMapping("/student/{phone}")
    public String getFeedbackByStudent(@PathVariable String phone, Model model) {
        model.addAttribute("feedbackList", feedbackService.getFeedbackByStudent(phone));
        return "feedbackByStudent"; // f.eks. feedbackByStudent.html
    }
}
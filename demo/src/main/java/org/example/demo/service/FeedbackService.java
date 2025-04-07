package org.example.demo.service;

import org.example.demo.model.Feedback;

import org.example.demo.model.Lecture;
import org.example.demo.model.Student;
import org.example.demo.repository.FeedbackRepository;
import org.example.demo.repository.LectureRepository;
import org.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class FeedbackService {

    @Autowired
    private static FeedbackRepository feedbackRepository;
    
        @Autowired
        private LectureRepository lectureRepository;
    
        @Autowired
        private StudentRepository studentRepository;
    
        // Legg til anonym tilbakemelding
        @Transactional
        public Feedback addAnonymousFeedback(Long lectureId, Feedback feedback) {
            Lecture lecture = lectureRepository.findById(lectureId)
                    .orElseThrow(() -> new RuntimeException("Lecture not found"));
            
            feedback.setLecture(lecture);
            feedback.setStudent(null); // Ingen student = anonym
            return feedbackRepository.save(feedback);
        }
    
        // Hent tilbakemeldinger for en forelesning
        public List<Feedback> getFeedbackForLecture(Long lectureId) {
            Lecture lecture = lectureRepository.findById(lectureId)
                    .orElseThrow(() -> new RuntimeException("Lecture not found"));
    
            return feedbackRepository.findByLecture(lecture);
        }
    
      
        
    
        // Slett tilbakemelding
        public void deleteFeedback(Long id) {
            feedbackRepository.deleteById(id);
        }
    
        // Lagre en tilbakemelding
        @Transactional
        public Feedback submitFeedback(Long lectureId, Long studentId, Feedback feedback) {
            Lecture lecture = lectureRepository.findById(lectureId)
                    .orElseThrow(() -> new RuntimeException("Lecture not found"));
    
            if (studentId != null) {
                Student student = studentRepository.findById(studentId)
                        .orElseThrow(() -> new RuntimeException("Student not found"));
                feedback.setStudent(student);
            } else {
                feedback.setStudent(null); // Anonym tilbakemelding
            }
    
            feedback.setLecture(lecture);
            return feedbackRepository.save(feedback);
        }
    
        public Feedback submitFeedback(Feedback feedback) {
            if (feedback.getStudent() == null) {
                return addAnonymousFeedback(feedback.getLecture().getId(), feedback);
            } else {
                return feedbackRepository.save(feedback);
            }
        }
    
       // 1. Submit feedback for a lecture
       public void submitFeedback(Long lectureId, String type) {
        // Sjekk om undervisningen eksisterer
        Optional<Lecture> lectureOpt = lectureRepository.findById(lectureId);
        if (!lectureOpt.isPresent()) {
            throw new RuntimeException("Lecture not found");
        }
    
        // Sjekk om tilbakemeldingen er gyldig (f.eks. grønn, gul, rød)
        if (!type.equals("green") && !type.equals("yellow") && !type.equals("red")) {
            throw new IllegalArgumentException("Invalid feedback type");
        }
    
        // Oprette en ny tilbakemelding (antatt at du har en Student som er logget inn)
        Student currentStudent = getCurrentStudent(); // Implementer logikk for å få gjeldende student
        Feedback feedback = new Feedback();
        feedback.setLecture(lectureOpt.get());
        feedback.setStudent(currentStudent);
        
    
        // Lagre tilbakemeldingen i databasen
        feedbackRepository.save(feedback);
    }
    
    // 2. Hent tilbakemeldinger gitt av en spesifikk student
    public Optional<Feedback> getFeedbackByStudent(Long studentId) {
        // Hente alle tilbakemeldinger for student ID
        return feedbackRepository.findById(studentId);
    }
    
    // 3. Hent alle tilbakemeldinger
    public static List<Feedback> getAllFeedback() {
        // Hente alle tilbakemeldinger fra databasen
        return feedbackRepository.findAll();
}

// Hjelpemetode for å hente nåværende student (må implementeres basert på ditt sikkerhetssystem)
private Student getCurrentStudent() {
    // Dette kan være basert på sesjon eller sikkerhetstjenester
    // Eksempel: return studentRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
    throw new UnsupportedOperationException("Implement logic to get the current student");
}
}
    



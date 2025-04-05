
package org.example.demo.controller;

import org.example.demo.model.Lecture;
import org.example.demo.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/lectures")
public class LectureController {

    @Autowired
    private LectureService lectureService;

    // Legge til forelesning (kun forelesere)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Lecture createLecture(@RequestBody Lecture lecture) {
        return lectureService.createLecture(lecture);
    }

    // Hente alle forelesninger
    @GetMapping
    public List<Lecture> getAllLectures() {
        return lectureService.getAllLectures();
    }

    // Hente forelesning
    @GetMapping("/{id}")
    public Lecture getLectureById(@PathVariable Long id) {
        return lectureService.getLectureById(id);
    }

    // Oppdater forelesning
    @PutMapping("/{id}")
    public Lecture updateLecture(@PathVariable Long id, @RequestBody Lecture updatedLecture) {
        return lectureService.updateLecture(id, updatedLecture);
    }

    // Slett forelesning
    @DeleteMapping("/{id}")
    public void deleteLecture(@PathVariable Long id) {
        lectureService.deleteLecture(id);
    }
}

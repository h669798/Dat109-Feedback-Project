package org.example.demo.service;

import java.util.List;

import org.example.demo.model.Admin;
import org.example.demo.model.Lecture;
import org.example.demo.model.User;
import org.example.demo.repository.UserRepository;
import org.example.demo.repository.LectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LectureRepository lectureRepository;

    

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public void createLecture(Lecture lecture) {
        lectureRepository.save(lecture);
    }

    public void deleteLecture(Long id) {
        lectureRepository.deleteById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createAdmin(User user) {
        // Sjekk om brukeren er admin og sett rolle
        if (user instanceof Admin) {
            user.setRole();
        }
        return userRepository.save(user);
    }

    public User createUser(User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createUser'");
    }
    
}

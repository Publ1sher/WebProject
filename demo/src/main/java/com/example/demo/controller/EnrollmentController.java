package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.dto.Userrequest;
import com.example.demo.entity.EntryCourse;
import com.example.demo.entity.Enrollment;
import com.example.demo.repository.EnrollmentRepository;
import com.example.demo.repository.EntryCourseRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/courses")
public class EnrollmentController {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EntryCourseRepository entryCourseRepository;

    @PostMapping("/api/courses")
    public ResponseEntity<Enrollment> enroll(@RequestBody Userrequest userrequest, @RequestParam Long courseId){
        User user = userRepository.findById(userrequest.getUserId()).orElse(null);
        EntryCourse course = entryCourseRepository.findById(courseId).orElse(null);

        if (user == null || course == null) {
            return ResponseEntity.badRequest().build();
        }

        // Создаем объект Enrollment и заполняем его данными
        Enrollment enrollment = new Enrollment();
        enrollment.setUser(user);
        enrollment.setCourse(course);
        enrollment.setFullName(userrequest.getFullName());
        enrollment.setEmail(userrequest.getEmail());
        enrollment.setEnrollmentDate(LocalDateTime.now());

        // Сохраняем запись
      Enrollment enrollment1 =   enrollmentRepository.save(enrollment);

        return ResponseEntity.ok(enrollment1);
    }


}

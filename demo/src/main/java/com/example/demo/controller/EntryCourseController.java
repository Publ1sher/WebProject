package com.example.demo.controller;

import com.example.demo.entity.EntryCourse;
import com.example.demo.repository.EntryCourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")

public class EntryCourseController {

    @Autowired
    private EntryCourseRepository entryCourseRepository;


    @GetMapping
    public List<EntryCourse> getAllCourses() {
        return entryCourseRepository.findAll();
    }

    @PostMapping("/api/courses")

    public ResponseEntity<EntryCourse> addCourse(@RequestBody EntryCourse course) {
       EntryCourse entryCourse= entryCourseRepository.save(course);
        return ResponseEntity.ok(entryCourse);
    }

    public EntryCourseRepository getEntryCourseRepository() {
        return entryCourseRepository;
    }

    public void setEntryCourseRepository(EntryCourseRepository entryCourseRepository) {
        this.entryCourseRepository = entryCourseRepository;
    }
}

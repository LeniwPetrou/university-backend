package com.app.uni.controller;


import com.app.uni.dto.CourseDTO;
import com.app.uni.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/addUserCourse")
    public CourseDTO addCourse(@RequestBody CourseDTO courseDTO) {
        return courseService.addCourse(courseDTO);
    }

    @GetMapping("/findUserCourseById/{id}")
    public CourseDTO findCourseById(@PathVariable Long id) {
        return courseService.findCourseById(id);
    }

    @GetMapping("/findAllUserCourses")
    public List<CourseDTO> findAllCourses() {
        return courseService.findAllCourses();
    }

    @PutMapping("/updateUserCourse")
    public CourseDTO updateCourse(@RequestBody CourseDTO courseDTO) {
        return courseService.updateCourse(courseDTO);
    }

    @DeleteMapping("/deleteUserCourseById/{id}")
    public String deleteCourseById(@PathVariable Long id) {
        return courseService.deleteCourseById(id);
    }
}

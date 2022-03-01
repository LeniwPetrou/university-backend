package com.app.uni.controller;

import com.app.uni.dto.CoursesDTO;
import com.app.uni.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CoursesController {

    @Autowired
    private CoursesService coursesService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/addCourses")
    public CoursesDTO addCourses(@RequestBody CoursesDTO coursesDTO) {
        return coursesService.addCourses(coursesDTO);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/findAllCourses")
    public List<CoursesDTO> findAllCourses() {
        return coursesService.findAllCourses();
    }

}

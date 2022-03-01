package com.app.uni.service;

import com.app.uni.dto.CoursesDTO;
import com.app.uni.model.Courses;

import java.util.List;

public interface CoursesService {
    public CoursesDTO addCourses(CoursesDTO coursesDTO);
    public CoursesDTO findCoursesById(Long id);
    public List<CoursesDTO> findAllCourses();
    public Courses toEntity (CoursesDTO courseDTO, String status);
    public CoursesDTO toDTO (Courses courses);
}

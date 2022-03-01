package com.app.uni.service;

import com.app.uni.dto.CourseDTO;
import com.app.uni.model.Course;

import java.util.List;

public interface CourseService {
    public CourseDTO addCourse(CourseDTO courseDTO);
    public CourseDTO updateCourse(CourseDTO courseDTO);
    public CourseDTO findCourseById(Long id);
    public List<CourseDTO> findAllCourses();
    public String deleteCourseById(Long id);
    public Course toEntity (CourseDTO courseDTO, String status);
    public CourseDTO toDTO (Course course);
}

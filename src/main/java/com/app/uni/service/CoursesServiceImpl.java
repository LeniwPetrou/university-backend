package com.app.uni.service;

import com.app.uni.dto.CoursesDTO;
import com.app.uni.model.Courses;
import com.app.uni.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoursesServiceImpl implements CoursesService{

    @Autowired
    private CoursesRepository coursesRepository;

    @Override
    public CoursesDTO addCourses(CoursesDTO coursesDTO){
        Courses course = this.toEntity(coursesDTO, "add");
        Courses newCourse = coursesRepository.save(course);
        CoursesDTO newCourseDTO = this.toDTO(newCourse);
        return newCourseDTO;
    }

    @Override
    public CoursesDTO findCoursesById(Long id){
        Courses courses = coursesRepository.findById(id).orElse(null);
        CoursesDTO coursesDTO = this.toDTO(courses);
        return coursesDTO;
    }

    @Override
    public List<CoursesDTO> findAllCourses(){
        List<Courses> courses = coursesRepository.findAll();
        List<CoursesDTO> coursesDTO = new ArrayList<>();
        for (Courses course:courses){
            coursesDTO.add(this.toDTO(course));
        }
        return coursesDTO;
    }

    @Override
    @Transactional
    public Courses toEntity (CoursesDTO coursesDTO, String status){
        Courses courses = null;
        if (status == "add") {
            courses = new Courses();
        }
        else {
            courses = coursesRepository.findById(coursesDTO.getId()).get();
        }
        courses.setDescription(coursesDTO.getDescription());
        courses.setStartDate(coursesDTO.getStartDate());
        courses.setEndDate(coursesDTO.getEndDate());

        return courses;
    }

    @Override
    public CoursesDTO toDTO (Courses courses){
        CoursesDTO coursesDTO = new CoursesDTO();
        coursesDTO.setId(courses.getId());
        coursesDTO.setDescription(courses.getDescription());
        coursesDTO.setStartDate(courses.getStartDate());
        coursesDTO.setEndDate(courses.getEndDate());
        return coursesDTO;
    }

}

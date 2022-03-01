package com.app.uni.service;

import com.app.uni.dto.CourseDTO;
import com.app.uni.dto.UserDTO;
import com.app.uni.model.Course;
import com.app.uni.model.User;
import com.app.uni.repository.CourseRepository;
import com.app.uni.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserRepository studentRepository;

    @Override
    public CourseDTO addCourse(CourseDTO courseDTO){
        Course course = this.toEntity(courseDTO, "add");
        Course newCourse = courseRepository.save(course);
        CourseDTO newCourseDTO = this.toDTO(newCourse);
        return newCourseDTO;
    }

    @Override
    public CourseDTO findCourseById(Long id){
        Course course = courseRepository.findById(id).orElse(null);
        CourseDTO courseDTO = this.toDTO(course);
        return courseDTO;
    }

    @Override
    public List<CourseDTO> findAllCourses(){
        List<Course> courses = courseRepository.findAll();
        List<CourseDTO> coursesDTO = new ArrayList<>();
        for (Course course:courses){
            coursesDTO.add(this.toDTO(course));
        }
        return coursesDTO;
    }


    @Override
    public CourseDTO updateCourse(CourseDTO courseDTO) {
        Course course = this.toEntity(courseDTO, "update");
        Course updatedCourse = courseRepository.save(course);
        CourseDTO updatedCourseDTO = this.toDTO(updatedCourse);
        return updatedCourseDTO;
    }

    @Override
    public String deleteCourseById(Long id){
        courseRepository.deleteById(id);
        return "The course with id = " + id + " has been deleted.";
    }

    @Override
    @Transactional
    public Course toEntity (CourseDTO courseDTO, String status){
        Course course = null;
        if (status == "add") {
            course = new Course();
        }
        else {
            course = courseRepository.findById(courseDTO.getId()).get();
        }
        course.setCode(courseDTO.getCode());
        course.setDescription(courseDTO.getDescription());
        UserDTO usersDTO = courseDTO.getUserDTO();
        if (usersDTO != null) {
                User user = studentRepository.findById(courseDTO.getUserDTO().getId()).get();
                course.setUser(user);
        }
        return course;
    }

    @Override
    public CourseDTO toDTO (Course course){
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(course.getId());
        courseDTO.setCode(course.getCode());
        courseDTO.setDescription(course.getDescription());
        UserDTO userDTO = new UserDTO(course.getUser());
        courseDTO.setUserDTO(userDTO);
        return courseDTO;
    }

}

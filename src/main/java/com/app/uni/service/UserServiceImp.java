package com.app.uni.service;

import com.app.uni.dto.CourseDTO;
import com.app.uni.dto.UserDTO;
import com.app.uni.model.Course;
import com.app.uni.model.User;
import com.app.uni.repository.CourseRepository;
import com.app.uni.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<UserDTO> findAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDTO> usersDTO = new ArrayList<>();
        for (User user:users){
            usersDTO.add(this.toDTO(user));
        }
        return usersDTO;
    }

    @Override
    public UserDTO addUser(UserDTO userDTO){
        User user = this.toEntity(userDTO);
        User newUser = userRepository.save(user);
        UserDTO newUserDTO = this.toDTO(newUser);
        return newUserDTO;
    }

    @Override
    public UserDTO findUserById(Long id){
        User user = userRepository.findById(id).orElse(null);
        UserDTO userDTO = this.toDTO(user);
        return userDTO;
    }

    @Override
    public UserDTO findUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        UserDTO userDTO = this.toDTO(user);
        return userDTO;
    }

    @Override
    public List<UserDTO> deleteUserById (List <UserDTO> usersDTO) {
        List <Long> listIds = new ArrayList<>();
        for (int i =0; i< usersDTO.size();i++){
            listIds.add(usersDTO.get(i).getId());
        }
        userRepository.deleteUserByIds(listIds);
        return usersDTO;
    }

    @Override
    public UserDTO updateUser (UserDTO userDTO){
        User user = this.toEntity(userDTO);
        User updatedUser = userRepository.findById(user.getId()).get();
        updatedUser.setFirstname(user.getFirstname());
        updatedUser.setLastname(user.getLastname());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setCourses(user.getCourses());
        updatedUser.setUsername(user.getUsername());
        updatedUser.setPassword(user.getPassword());
        updatedUser.setRole_id(user.getRole_id());
        userRepository.save(updatedUser);
        UserDTO updatedUserDTO = this.toDTO(updatedUser);
        return updatedUserDTO;
    }

    public UserDTO toDTO (User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstname(user.getFirstname());
        userDTO.setLastname(user.getLastname());
        userDTO.setEmail(user.getEmail());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setRoleId(user.getRole_id());

        List<Course> courses = user.getCourses();
        if (courses != null){
            List<CourseDTO> coursesDTO = new ArrayList<>();
            for(Course course:courses){
                CourseDTO courseDTO = new CourseDTO();
                courseDTO.setId(course.getId());
                courseDTO.setCode(course.getCode());
                courseDTO.setDescription(course.getDescription());
                coursesDTO.add(courseDTO);
            }
            userDTO.setCourseDTO(coursesDTO);
        }
        return userDTO;
    }

    public User toEntity (UserDTO userDTO){
        User user = new User();
        user.setId(userDTO.getId());
        user.setFirstname(userDTO.getFirstname());
        user.setLastname(userDTO.getLastname());
        user.setEmail(userDTO.getEmail());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setRole_id(userDTO.getRoleId());

        List<CourseDTO> coursesDTO = userDTO.getCourseDTO();
        if (coursesDTO != null){
            List<Course> courses = new ArrayList<>();
            for (CourseDTO courseDTO:coursesDTO){
                Course course = new Course();
                course.setId(courseDTO.getId());
                course.setCode(courseDTO.getCode());
                course.setDescription(courseDTO.getDescription());
                courses.add(course);
            }
            user.setCourses(courses);
        }
        return user;
    }

    @Override
    public UserDTO authenticateUser(String username, String password ) {
        User user = userRepository.findUserByUsernameAndPassword(username, password);
        UserDTO authenticatedUserDTO = this.toDTO(user);
        return authenticatedUserDTO;
    }
}

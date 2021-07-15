package com.app.uni.controller;

import com.app.uni.model.Student;
import com.app.uni.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/findAllStudents")
    public List<Student> findAllStudents() {
        return studentService.findAllStudents();
    }

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping("/findStudentById/{id}")
    public Student findStudentById (@PathVariable Long id){
        return studentService.findStudentById(id);
    }

    @GetMapping("/findStudentByEmail/{email}")
    public Student findStudentByEmail (@PathVariable String email){
        return studentService.findStudentByEmail(email);
    }

    @DeleteMapping("/deleteStudentById/{id}")
    public String deleteStudentById (@PathVariable Long id){
        return studentService.deleteStudentById(id);
    }

    @PutMapping("/updateStudent")
    public Student updateStudent (@RequestBody Student student){
        return studentService.updateStudent(student);
    }
}
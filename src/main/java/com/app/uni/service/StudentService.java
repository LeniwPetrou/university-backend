package com.app.uni.service;

import com.app.uni.model.Student;
import java.util.List;

public interface StudentService {

    public List<Student> findAllStudents();
    public Student addStudent(Student student);
    public Student findStudentById(Long id);
    public Student findStudentByEmail(String email);
    public String deleteStudentById (Long id);
    public Student updateStudent(Student student);
}

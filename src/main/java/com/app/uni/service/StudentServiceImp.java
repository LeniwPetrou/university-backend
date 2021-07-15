package com.app.uni.service;

import com.app.uni.model.Student;
import com.app.uni.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImp implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students;
    }

    @Override
    public Student addStudent(Student student){
        Student newStudent = studentRepository.save(student);
        return newStudent;
    }

    @Override
    public Student findStudentById(Long id){
        Student student = studentRepository.findById(id).orElse(null);
        return student;
    }

    @Override
    public Student findStudentByEmail(String email) {
        Student student = studentRepository.findByEmail(email);
        return student;
    }

    @Override
    public String deleteStudentById (Long id) {
        studentRepository.deleteById(id);
        return "Student with id: " + id + " has been deleted!";
    }

    @Override
    public Student updateStudent (Student student){
        Student updatedStudent = studentRepository.findById(student.getId()).get();
        updatedStudent.setFirstname(student.getFirstname());
        updatedStudent.setLastname(student.getLastname());
        updatedStudent.setEmail(student.getEmail());
        return studentRepository.save(updatedStudent);
    }
}

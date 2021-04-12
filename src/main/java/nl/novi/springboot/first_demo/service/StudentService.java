package nl.novi.springboot.first_demo.service;

import nl.novi.springboot.first_demo.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();
    List<Student> getStudentsByName(String name);
    Student getStudentById(long id);
    long addStudent(Student student);
    void deleteStudent(long id);
    void updateStudent(long id, Student student);

}

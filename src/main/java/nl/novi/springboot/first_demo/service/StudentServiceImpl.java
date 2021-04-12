package nl.novi.springboot.first_demo.service;

import nl.novi.springboot.first_demo.exception.RecordNotFoundException;
import nl.novi.springboot.first_demo.model.Student;
import nl.novi.springboot.first_demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getStudentsByName(String name) {
        if (name == null || name.isEmpty())
            return studentRepository.findAll();
        else
            return studentRepository.findByAchternaamStartingWithOrderByAchternaam(name);
    }

    @Override
    public Student getStudentById(long id) {
        if (studentRepository.existsById(id)) {
            return studentRepository.findById(id).get();
        }
        else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public long addStudent(Student student) {
        Student newStudent = studentRepository.save(student);
        return newStudent.getId();
    }

    @Override
    public void deleteStudent(long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        }
        else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public void updateStudent(long id, Student student) {
        if (studentRepository.existsById(id)) {
            Student existingStudent = studentRepository.findById(id).get();
            existingStudent.setVoornaam(student.getVoornaam());
            existingStudent.setAchternaam(student.getAchternaam());
            existingStudent.setStudienummer(student.getStudienummer());
            existingStudent.setWoonplaats(student.getWoonplaats());
            existingStudent.setTelefoonnummer(student.getTelefoonnummer());
            studentRepository.save(existingStudent);

        }
        else {
            throw new RecordNotFoundException();
        }
    }

}

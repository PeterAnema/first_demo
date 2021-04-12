package nl.novi.springboot.first_demo.repository;

import nl.novi.springboot.first_demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByAchternaamIs(String name);
    List<Student> findByAchternaamStartingWithOrderByAchternaam(String name);

    @Query("SELECT * FROM students;")
    List<Student> getAllStudents();

}

package nl.novi.springboot.first_demo.controller;

import nl.novi.springboot.first_demo.model.Student;
import nl.novi.springboot.first_demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/v1")
public class StudentController {

    @Autowired
    StudentService studentService;

//    @GetMapping(value = "/students")
//    public ResponseEntity<Object> getStudents() {
//        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
//    }

    @GetMapping(value = "/students")
    @PreAuthorize("USER")
    public ResponseEntity<Object> getStudents(@RequestParam(required = false) String name) {
        return new ResponseEntity<>(studentService.getStudentsByName(name), HttpStatus.OK);
    }

    @GetMapping(value = "/students/{id}")
    public ResponseEntity<Object> getStudent(@PathVariable("id") Integer id) {
        return  new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/students")
    public ResponseEntity<Object> addStudent(@RequestBody Student student) {

        long newId = studentService.addStudent(student);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                                  .path("/{id}")
                                                  .buildAndExpand(newId)
                                                  .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/students/{id}")
    public ResponseEntity<Object> deleteStudent(@PathVariable("id") Integer id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>("Record deleted", HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/students/{id}")
    public ResponseEntity<Object> updateStudent(@PathVariable("id") Integer id, @RequestBody Student student) {
        studentService.updateStudent(id, student);
        return new ResponseEntity<>("Record updated", HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/students/{id}/cursussen/{id}")
    public ResponseEntity<Object> updateCijfer(@RequestBody int cijfer) {
        return new ResponseEntity<>("Record updated", HttpStatus.NO_CONTENT);
    }

}

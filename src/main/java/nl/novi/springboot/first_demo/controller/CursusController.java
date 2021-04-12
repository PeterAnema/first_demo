package nl.novi.springboot.first_demo.controller;

import nl.novi.springboot.first_demo.service.CursusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class CursusController {

    @Autowired
    CursusService cursusService;

    @GetMapping(value = "/cursussen")
    public ResponseEntity<Object> getCursussen(@RequestParam(required = false) String name) {
        return new ResponseEntity<>(cursusService.getCursussenByName(name), HttpStatus.OK);
    }

    @GetMapping(value = "/cursussen/{id}")
    public ResponseEntity<Object> getCursussen(@PathVariable("id") Long id) {
        return new ResponseEntity<>(cursusService.getCursusById(id), HttpStatus.OK);
    }

}

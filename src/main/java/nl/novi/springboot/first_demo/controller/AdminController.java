package nl.novi.springboot.first_demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class AdminController {

    @GetMapping("/admin")
    ResponseEntity<Object> getAdmin() {
        return ResponseEntity.ok().body("For ADMIN only!!");
    }

}

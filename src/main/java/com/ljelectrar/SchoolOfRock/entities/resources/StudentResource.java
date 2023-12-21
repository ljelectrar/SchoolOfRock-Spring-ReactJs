package com.ljelectrar.SchoolOfRock.entities.resources;

import com.ljelectrar.SchoolOfRock.entities.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(value="/students")
public class StudentResource {

    @GetMapping
    public ResponseEntity<Student> findAll(){
        Student leandro = new Student(0L, "Leandro", new Date());
        return ResponseEntity.ok().body(leandro);
    }
}

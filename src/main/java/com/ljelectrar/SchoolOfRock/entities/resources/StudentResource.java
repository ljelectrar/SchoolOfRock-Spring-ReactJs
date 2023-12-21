package com.ljelectrar.SchoolOfRock.entities.resources;

import com.ljelectrar.SchoolOfRock.entities.Student;
import com.ljelectrar.SchoolOfRock.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value="/students")
public class StudentResource {

    @Autowired
    private StudentService studentService;
    @GetMapping
    public ResponseEntity<List<Student>> findAll(){

        List<Student> students = studentService.findAll();
        return ResponseEntity.ok().body(students);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Student> findById(@PathVariable Long id){
        Student student = studentService.findById(id);
        return ResponseEntity.ok().body(student);
    }

    @PostMapping
    public ResponseEntity<Student> insert(@RequestBody Student student) {
        studentService.insert(student);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(student.getId())
                .toUri();

        return ResponseEntity.created(uri).body(student);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student student){
        student = studentService.update(id, student);
        return ResponseEntity.ok().body(student);
    }
}

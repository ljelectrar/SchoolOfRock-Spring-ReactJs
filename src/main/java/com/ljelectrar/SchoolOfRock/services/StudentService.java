package com.ljelectrar.SchoolOfRock.services;

import com.ljelectrar.SchoolOfRock.entities.Student;
import com.ljelectrar.SchoolOfRock.repositories.StudentRepository;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(Long id){
       Optional<Student> student = studentRepository.findById(id);
       return student.get();
    }

    public Student insert(Student student){
        return studentRepository.save(student);
    }

    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    public Student update(Long id, Student student){
        Student entity = studentRepository.getReferenceById(id);
        updateData(entity, student);
        return studentRepository.save(entity);
    }

    private void updateData(Student entity, Student student) {
        entity.setName(student.getName());
        entity.setBirthDay(student.getBirthDay());
        entity.setFallWinterSemester(student.getFallWinterSemester());
        entity.setSpringSummerSemester(student.getSpringSummerSemester());
    }

}

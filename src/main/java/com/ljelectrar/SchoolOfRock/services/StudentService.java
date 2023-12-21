package com.ljelectrar.SchoolOfRock.services;

import com.ljelectrar.SchoolOfRock.entities.Student;
import com.ljelectrar.SchoolOfRock.repositories.StudentRepository;
import com.ljelectrar.SchoolOfRock.services.exceptions.DatabaseException;
import com.ljelectrar.SchoolOfRock.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
       return student.orElseThrow( () -> new ResourceNotFoundException(id) );
    }

    public Student insert(Student student){
        return studentRepository.save(student);
    }

    public void delete(Long id) {
        try{
            studentRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public Student update(Long id, Student student){
        try {
        Student entity = studentRepository.getReferenceById(id);
        updateData(entity, student);
        return studentRepository.save(entity);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Student entity, Student student) {
        entity.setName(student.getName());
        entity.setBirthDay(student.getBirthDay());
        entity.setFallWinterSemester(student.getFallWinterSemester());
        entity.setSpringSummerSemester(student.getSpringSummerSemester());
    }

}

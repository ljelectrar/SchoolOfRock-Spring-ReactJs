package com.ljelectrar.SchoolOfRock.repositories;

import com.ljelectrar.SchoolOfRock.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}

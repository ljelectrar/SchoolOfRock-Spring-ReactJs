package com.ljelectrar.SchoolOfRock.config;

import com.ljelectrar.SchoolOfRock.entities.Student;
import com.ljelectrar.SchoolOfRock.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;
import java.util.Date;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
        Student tester01 = new Student(null, "Leandro", new Date());
        Student tester02 = new Student(null, "Andre", new Date());
        Student tester03 = new Student(null, "Paschoal", new Date());
        Student tester04 = new Student(null, "Marquinhos", new Date());
        Student tester05 = new Student(null, "Júlia", new Date());
        Student tester06 = new Student(null, "Igor", new Date());

        studentRepository.saveAll(Arrays.asList(tester01, tester02, tester03, tester04, tester05, tester06));
    }
}

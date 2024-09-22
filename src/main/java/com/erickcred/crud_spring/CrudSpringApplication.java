package com.erickcred.crud_spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.erickcred.crud_spring.model.Course;
import com.erickcred.crud_spring.repositories.ICourseRepository;

@SpringBootApplication
public class CrudSpringApplication {

  public static void main(String[] args) {
    SpringApplication.run(CrudSpringApplication.class, args);
  }

  @Bean
  CommandLineRunner initDatabase(ICourseRepository iCourseRepository) {
    return args -> {
      iCourseRepository.deleteAll();

      List<Course> courses = new ArrayList<Course>();
      Course course = new Course();

      course.setName("Angular Course");
      course.setCategory("Front-end");
      courses.add(course);

      course = new Course();
      course.setName("Angular Course");
      course.setCategory("Front-end");
      courses.add(course);

      course = new Course();
      course.setName("Vue Course");
      course.setCategory("Front-end");

      course = new Course();
      course.setName("React Course");
      course.setCategory("Front-end");
      courses.add(course);

      course = new Course();
      course.setName("Java Course");
      course.setCategory("Back-end");
      courses.add(course);

      course = new Course();
      course.setName("SQL Server Course");
      course.setCategory("Database");
      courses.add(course);

      iCourseRepository.saveAll(courses);
    };
  }
}

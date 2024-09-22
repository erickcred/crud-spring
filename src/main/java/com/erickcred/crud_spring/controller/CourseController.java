package com.erickcred.crud_spring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.erickcred.crud_spring.model.Course;
import com.erickcred.crud_spring.repositories.ICourseRepository;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

  private final ICourseRepository iCourseRepository;

  public CourseController(ICourseRepository iCourseRepository) {
    this.iCourseRepository = iCourseRepository;
  }

  @GetMapping
  public List<Course> list() {
    return this.iCourseRepository.findAll();
  }

  @GetMapping(path = "/{id}")
  public Course findById(@PathVariable Long id) {
    Course course = this.iCourseRepository.findById(id).get();
    return course;
  }

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public Course post(@RequestBody Course request) {
    Course course = this.iCourseRepository.save(request);
    return course;
  }

}

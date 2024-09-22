package com.erickcred.crud_spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erickcred.crud_spring.model.Course;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Long> {

}

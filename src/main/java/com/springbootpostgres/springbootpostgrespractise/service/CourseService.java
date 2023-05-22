package com.springbootpostgres.springbootpostgrespractise.service;

import com.springbootpostgres.springbootpostgrespractise.dto.CourseRequest;
import com.springbootpostgres.springbootpostgrespractise.entity.Course;

import java.util.List;

public interface CourseService {

    public Course addCourseWithContents(CourseRequest courseRequest);

    public List<Course> getAllCourses();


}

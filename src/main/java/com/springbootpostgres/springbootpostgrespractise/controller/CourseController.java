package com.springbootpostgres.springbootpostgrespractise.controller;

import com.springbootpostgres.springbootpostgrespractise.dto.CourseRequest;
import com.springbootpostgres.springbootpostgrespractise.dto.ResponseDto;
import com.springbootpostgres.springbootpostgrespractise.entity.City;
import com.springbootpostgres.springbootpostgrespractise.entity.Course;
import com.springbootpostgres.springbootpostgrespractise.service.CourseService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.springbootpostgres.springbootpostgrespractise.constant.ApplicationConstants;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CourseController {

    private final CourseService courseService;


    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    @PostMapping("addcourse")
    public Course addCourse(@RequestBody CourseRequest courseRequest){
        return courseService.addCourseWithContents(courseRequest);
    }

    @GetMapping(value = "/courses", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto<List<Course>> getCourses(){
        ResponseDto<List<Course>> response = new ResponseDto<>();
        List<Course> coursesData = courseService.getAllCourses();
        response = response.ok(coursesData, ApplicationConstants.GET_ALL_COURSE);
        return response;
    }

}

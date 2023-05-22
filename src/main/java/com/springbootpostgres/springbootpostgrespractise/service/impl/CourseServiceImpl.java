package com.springbootpostgres.springbootpostgrespractise.service.impl;

import com.springbootpostgres.springbootpostgrespractise.dto.CourseRequest;
import com.springbootpostgres.springbootpostgrespractise.entity.Course;
import com.springbootpostgres.springbootpostgrespractise.entity.CourseContents;
import com.springbootpostgres.springbootpostgrespractise.repository.CourseContentsRepository;
import com.springbootpostgres.springbootpostgrespractise.repository.CourseRepository;
import com.springbootpostgres.springbootpostgrespractise.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@Slf4j
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CourseContentsRepository courseContentsRepository;

    @PostConstruct
    public void saveCourse(){
        List<Course> courseData = IntStream.range(4, 1000).mapToObj(i -> new Course(i, "Course - " + i, null))
                .collect(Collectors.toList());
        courseRepository.saveAll(courseData);
    }

    @Override
    public Course addCourseWithContents(CourseRequest courseRequest) {
        Course course = new Course();
        course.setId(courseRequest.getId());
        course.setCourseName(courseRequest.getCourseName());
        course.setCourseContents(courseRequest.getCourseContents().stream()
                .map(courseContents -> {
                    CourseContents cContent = courseContents;
                    if(cContent.getId() > 0){
                        cContent =  courseContentsRepository.findById(cContent.getId());
                    }
                    cContent.addCourse(course);
                    return cContent;
                })
                .collect(Collectors.toSet()));
        return courseRepository.save(course);
    }

    @Override
    @Cacheable(cacheNames = "courses")
    public List<Course> getAllCourses() {
        log.info("Course Service::Get All Course connects to DB");
        return courseRepository.findAll();
    }
}

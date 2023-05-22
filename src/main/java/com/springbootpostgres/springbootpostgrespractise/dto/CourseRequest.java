package com.springbootpostgres.springbootpostgrespractise.dto;

import com.springbootpostgres.springbootpostgrespractise.entity.CourseContents;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {

    public int id;
    public String courseName;
    public Set<CourseContents> courseContents;
}

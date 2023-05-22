package com.springbootpostgres.springbootpostgrespractise.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="coursecontents")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseContents {

    @Id
    @Column(name="content_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String content;

    @ManyToMany(mappedBy = "courseContents")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Set<Course> courses = new HashSet<>();

    public void addCourse(Course course){
        this.courses.add(course);
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}

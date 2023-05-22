package com.springbootpostgres.springbootpostgrespractise.repository;

import com.springbootpostgres.springbootpostgrespractise.entity.CourseContents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseContentsRepository extends JpaRepository<CourseContents, Integer> {

    public CourseContents findById(int id);
}

package com.springbootpostgres.springbootpostgrespractise.repository;

import com.springbootpostgres.springbootpostgrespractise.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}

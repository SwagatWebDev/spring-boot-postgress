package com.springbootpostgres.springbootpostgrespractise.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name ="employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @Column(name="employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String employeename;

    private String department;

    private Date joiningdate;

    private int age;

    private String address;

    private float salary;

    private ZonedDateTime lefton;

    private boolean leftjob;

}

package com.springbootpostgres.springbootpostgrespractise.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Product {

    @Id
    public Integer id;

}

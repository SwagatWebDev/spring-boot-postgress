package com.springbootpostgres.springbootpostgrespractise.repository;

import com.springbootpostgres.springbootpostgrespractise.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

    Country findById(int id);

    @Query("from Country where id= ?1")
    Country getById(int id);

    List<Country> findByCountryNameStartsWithOrderByPopulation(String prefix);

    @Query("select c from Country c where c.countryName like ?1% ORDER BY c.population ASC")
    List<Country> getByCountryName(String prefix);

    @Query("select c.countryName, c.population from Country c where c.countryName like :countryName% and c.population >= :population")
    List<Object[]> getByCnameAndPopulation(@Param("countryName") String countryName,
                                           @Param("population") Long population);

    /** Drawback of JPQL
     * JPQL supports only the subset of standard SQL
     * So if you want to write complex queries for examples like multiple joins, nested queries
     * and function calling etc for those we should write native queries
     *
     * The main advantage of native queries is that it is not processed by JPA implementation
     * also it will directly send to the database server for execution. In native queries, instead
     * of querying our entity class we directly query the database table
     *
     * Native Queries are not processed by the JPA implementation also we can access any
     * data from any column of the table. It really doesn't matter you have that column
     * definition in your entity class or not.
     * */
    @Query(value = "select c.country_name, c.population, c.gdp from countries c where c.country_name like :countryName% and c.population >= :population", nativeQuery = true)
    List<Object[]> getByCnameAndPopulationNative(@Param("countryName") String countryName,
                                           @Param("population") Long population);
}

package com.example.demo.repo;

import com.example.demo.dbmodel.Employee;
import com.example.demo.model.StatsGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    Employee findById(int id);

    @Query("SELECT emp FROM Employee emp WHERE email LIKE %?1")
    List<Employee> findByEmailDomain(String email);

    List<Employee> findByCity(int city);

    @Query("SELECT emp FROM Employee emp WHERE city = :city ORDER BY fname, lname")
    List<Employee> findByCitySorted(int city);

    @Query("SELECT new com.example.demo.model.StatsGroup(city,count(id)) FROM Employee GROUP BY city")
    List<StatsGroup> groupCountByCity();

    @Query("SELECT count(emp) FROM Employee emp WHERE contact % 2 = 0")
    long countEvenContacts();

    @Query("SELECT count(emp) FROM Employee emp WHERE contact % 2 != 0")
    long countOddContacts();
}

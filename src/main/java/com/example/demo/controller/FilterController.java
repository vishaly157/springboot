package com.example.demo.controller;

import com.example.demo.dbmodel.Employee;
import com.example.demo.model.EmailGroup;
import com.example.demo.model.ResponseModel;
import com.example.demo.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("filter")
public class FilterController {

    @Autowired
    EmployeeRepo employeeRepo;

    @GetMapping("/email/{email}")
    public ResponseModel<List<Employee>> emailFilter(@PathVariable(name = "email") EmailGroup emailGroup) {
        List<Employee> resultSet = employeeRepo.findByEmailDomain(emailGroup.getLabel());

        return new ResponseModel<>(resultSet.size() == 0?"No records Found":"", resultSet, resultSet.size() != 0);
    }

    @GetMapping("/city/{city}")
    public ResponseModel<List<Employee>> cityFilter(@PathVariable int city) {
        List<Employee> resultSet = employeeRepo.findByCity(city);

        return new ResponseModel<>(resultSet.size() == 0?"No records Found":"", resultSet, resultSet.size() != 0);
    }

    @GetMapping("/cityOrdered/{city}")
    public ResponseModel<List<Employee>> citySortedFilter(@PathVariable int city) {
        List<Employee> resultSet = employeeRepo.findByCitySorted(city);

        return new ResponseModel<>(resultSet.size() == 0?"No records Found":"", resultSet, resultSet.size() != 0);
    }

}

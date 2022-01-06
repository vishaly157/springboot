package com.example.demo.controller;

import com.example.demo.dbmodel.Employee;
import com.example.demo.model.ResponseModel;
import com.example.demo.model.StatsGroup;
import com.example.demo.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("auth")
public class ApiController {

    @Autowired
    EmployeeRepo employeeRepo;

    @GetMapping("/user/{userId}")
    @ResponseBody
    public ResponseModel<Employee> index(@PathVariable String userId) {
        Employee resultSet = employeeRepo.findById(Integer.parseInt(userId));

        return new ResponseModel<>(resultSet != null?"":"No value Found", resultSet, resultSet != null);
    }

    @GetMapping("/user/all")
    @ResponseBody
    public ResponseModel<List<Employee>> fetchAll() {
        List<Employee> resultSet = employeeRepo.findAll();

        return new ResponseModel<>(resultSet.size() == 0?"No records Found":"", resultSet, resultSet.size() != 0);
    }

    @GetMapping("/{field}")
    @ResponseBody
    public ResponseModel<Map<String, Long>> getStats(@PathVariable String field, String limit) {
        Map<String, Long> resultSet = new HashMap<>();

        switch (field.toLowerCase()){

            case "city":
                List<StatsGroup> rawCityRes = employeeRepo.groupCountByCity();
                resultSet = rawCityRes.stream().collect(Collectors.toMap(e-> ""+e.getKey(), StatsGroup::getValue));
                break;
            case "contact_e":
                resultSet.put("Even Contacts", employeeRepo.countEvenContacts());
                break;
            case "contact_o":
                resultSet.put("Odd Contacts", employeeRepo.countOddContacts());
                break;
            default:
                resultSet.put("INVALID FILTER", -1L);
                break;
        }

        return new ResponseModel<>("", resultSet, true);
    }
}

package com.employee.controller;

import com.employee.model.EmployeeModel;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmployeeController
{
    @Autowired
    private EmployeeService service;

    @PostMapping("/addEmployee")
    public EmployeeModel saveEmployee(@RequestBody EmployeeModel emp) {
        return service.saveEmployee(emp);
    }

    @GetMapping("/findByID/{id}")
    public EmployeeModel findEmployeeByID(@PathVariable long id)
    {
        return service.findEmployeeByID(id);
    }

    @PostMapping("/deleteById/{id}")
    public void deleteEmployeeByID(@PathVariable long id)
    {
        service.deleteEmployeeByID(id);
    }
}

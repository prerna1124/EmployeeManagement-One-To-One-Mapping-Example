package com.employee.service;

import com.employee.ResourceNotFoundException;
import com.employee.model.EmployeeModel;
import com.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class EmployeeService
{

    @Autowired
    private EmployeeRepository repo;

    public EmployeeModel saveEmployee(EmployeeModel emp)
    {
        return repo.save(emp);
    }

    public EmployeeModel findEmployeeByID(long id) throws ResourceNotFoundException
    {
        EmployeeModel employee = repo.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("Employee not found with id "+id));

        return employee;
    }

    @DeleteMapping("/instructors/{id}")
    public void deleteEmployeeByID(long id) throws ResourceNotFoundException {
        EmployeeModel employeeToDelete = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor not found :: " + id));
        repo.delete(employeeToDelete);
    }
}

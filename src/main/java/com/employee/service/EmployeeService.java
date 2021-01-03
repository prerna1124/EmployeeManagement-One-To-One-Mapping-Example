package com.employee.service;

import com.employee.ResourceNotFoundException;
import com.employee.model.EmployeeModel;
import com.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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

    public void deleteEmployeeByID(long id) throws ResourceNotFoundException {
        EmployeeModel employeeToDelete = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor not found :: " + id));
        repo.delete(employeeToDelete);
    }

    public EmployeeModel updateEmployeeById(@PathVariable long id, @RequestBody EmployeeModel empDetails)
    {
        EmployeeModel existingEmployee = repo.findById(id).get();
        if(empDetails.getfName()!= null)
            existingEmployee.setfName(empDetails.getfName());
        if(empDetails.getlName()!=null)
            existingEmployee.setlName(empDetails.getlName());
        if(empDetails.getSalary()!=0)
            existingEmployee.setSalary(empDetails.getSalary());
        if(empDetails.getAdd()!=null)
        {
            if(empDetails.getAdd().getCity()!=null)
                existingEmployee.getAdd().setCity(empDetails.getAdd().getCity());
            if(empDetails.getAdd().getState()!=null)
                existingEmployee.getAdd().setState(empDetails.getAdd().getState());
        }

        existingEmployee = repo.save(existingEmployee);
        return existingEmployee;
    }
}

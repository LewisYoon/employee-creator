package io.nology.employee_creator.employee;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.nology.employee_creator.common.exceptions.NotFoundException;
import io.nology.employee_creator.employee.dtos.CreateEmployeeRequest;
import io.nology.employee_creator.employee.dtos.UpdateEmployeeRequest;
import io.nology.employee_creator.employee.entities.Employee;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
@Tag(name = "Employees controller")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> findAllEmployees() {
        List<Employee> employees = this.service.findAll();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable Long id) {
        Employee result = this.service.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        "Could not find employee with id " + id));

        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(
            @Valid @RequestBody @Valid CreateEmployeeRequest data) {

        Employee createdEmployee = this.service.create(data);

        return new ResponseEntity<>(
                createdEmployee,
                HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Employee> updateEmployeeById(
            @PathVariable Long id,
            @Valid @RequestBody UpdateEmployeeRequest data) {

        Employee result = this.service.updateById(id, data)
                .orElseThrow(() -> new NotFoundException(
                        "Could not find employee with id " + id));

        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployeeById(
            @PathVariable Long id) {

        boolean isDeleted = this.service.deleteById(id);

        if (isDeleted) {
            return ResponseEntity.noContent().build();
        }

        throw new NotFoundException(
                "Could not find employee with id " + id);
    }
}
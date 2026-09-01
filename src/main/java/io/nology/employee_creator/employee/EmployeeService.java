package io.nology.employee_creator.employee;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import io.nology.employee_creator.employee.dtos.CreateEmployeeRequest;
import io.nology.employee_creator.employee.dtos.UpdateEmployeeRequest;
import io.nology.employee_creator.employee.entities.Employee;

@Service
public class EmployeeService {

    private final EmployeeRepository repo;
    private final ModelMapper mapper;

    public EmployeeService(EmployeeRepository repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public List<Employee> findAll() {
        return this.repo.findAll();
    }

    public Optional<Employee> findById(Long id) {
        return this.repo.findById(id);
    }

    public Employee create(CreateEmployeeRequest data) {
        Employee employee = this.mapper.map(data, Employee.class);
        return this.repo.saveAndFlush(employee);
    }

    public Optional<Employee> updateById(Long id, UpdateEmployeeRequest data) {
        Optional<Employee> result = this.findById(id);

        if (result.isEmpty()) {
            return result;
        }

        Employee foundEmployee = result.get();

        this.mapper.map(data, foundEmployee);

        this.repo.saveAndFlush(foundEmployee);

        return Optional.of(foundEmployee);
    }

    public boolean deleteById(Long id) {
        Optional<Employee> result = this.findById(id);

        if (result.isEmpty()) {
            return false;
        }

        this.repo.delete(result.get());

        return true;
    }
}
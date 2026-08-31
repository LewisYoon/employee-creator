package io.nology.employee_creator.employee;

import org.springframework.data.jpa.repository.JpaRepository;

import io.nology.employee_creator.employee.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
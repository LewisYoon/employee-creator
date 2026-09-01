package io.nology.employee_creator.config.seeders;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import io.nology.employee_creator.employee.EmployeeRepository;
import io.nology.employee_creator.employee.entities.Employee;

@Component
@Profile("dev")
public class EmployeeDataSeeder implements CommandLineRunner {

    private final EmployeeRepository repo;

    public EmployeeDataSeeder(EmployeeRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) throws Exception {
        if (repo.count() == 0) {
            System.out.println("Creating employees");

            Employee employee1 = new Employee();
            employee1.setFirstName("Lewis");
            employee1.setLastName("Yoon");
            employee1.setEmail("lewis.yoon@nology.io");
            employee1.setPhoneNumber("0400123456");
            employee1.setJobTitle("Software Engineer");
            employee1.setDepartment("Engineering");

            repo.saveAndFlush(employee1);

            Employee employee2 = new Employee();
            employee2.setFirstName("John");
            employee2.setLastName("Doe");
            employee2.setEmail("john.doe@nology.io");
            employee2.setPhoneNumber("0410123456");
            employee2.setJobTitle("Product Manager");
            employee2.setDepartment("Product");

            repo.saveAndFlush(employee2);
        }
    }
}
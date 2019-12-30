package net.ckj46.springdataapp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Vector;

@RequiredArgsConstructor
@Component
public class RunAtStart {
    private final EmployeeRepository employeeRepository;

    @PostConstruct
    public void run(){
        Employee employee = new Employee();

        employee.setFirstName("Adam");
        employee.setLastName("Jabol");
        employee.setSallary(new BigDecimal(15000.0));

        employeeRepository.save(employee);

        Iterable<Employee> workers = employeeRepository.findByFirstName("Adam");
        for (Employee worker: workers) {
            System.out.println("worker: "+worker);
        }
    }
}

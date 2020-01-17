package net.ckj46.springdataapp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Vector;

@RequiredArgsConstructor
@Component
public class RunAtStart {
    private final EmployeeRepository employeeRepository;

    @PostConstruct
    public void run(){
        EmployeeGen employeeGen = new EmployeeGen();
        List<Employee> employees = employeeGen.gen();

        for (Employee employee: employees) {
            employeeRepository.save(employee);
        }

        List<Employee> workers = employeeRepository.findByFirstName("Adam");
        System.out.println("findByFirstName:");
        for (Employee worker: workers) {
            System.out.println("worker: "+worker);
        }

        workers.clear();
        workers = employeeRepository.findAll();
        System.out.println("findAll:");
        for (Employee worker: workers) {
            System.out.println("worker: "+worker);
        }

    }
}

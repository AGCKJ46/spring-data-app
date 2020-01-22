package net.ckj46.springdataapp;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@RequiredArgsConstructor
@Component
public class RunAtStart {
    private final EmployeeRepository employeeRepository;
    private final EmployeeGen employeeGen;

    @PostConstruct
    public void run(){
        List<Employee> employees = employeeGen.gen();

        for (Employee employee: employees) {
            employeeRepository.save(employee);
        }
        List<Employee> workers = null;
        /*
        workers = employeeRepository.findByFirstName("Adam");
        System.out.println("findByFirstName:");
        printAll(workers);

        workers.clear();
        workers = employeeRepository.findAll();
        printAll(workers);
        */

        workers = employeeRepository.findAll(Sort.by("firstName").descending());
        printAll(workers);
    }

    private void printAll(List<Employee> workers) {
        workers.forEach(System.out::println);
    }
}

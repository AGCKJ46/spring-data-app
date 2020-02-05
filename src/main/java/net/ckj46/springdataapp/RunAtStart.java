package net.ckj46.springdataapp;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Component
public class RunAtStart {
    private final EmployeeRepository employeeRepository;
    private final EmployeeGen employeeGen;

    @PostConstruct
    public void run() throws InterruptedException {
        List<Employee> employees = employeeGen.gen();

        for (Employee employee: employees) {
            employeeRepository.save(employee);
        }
        printAll(employeeRepository.findAll());

        List<Employee> workers = null;
        /*
        workers = employeeRepository.findByFirstName("Adam");
        System.out.println("findByFirstName:");
        printAll(workers);

        workers.clear();
        workers = employeeRepository.findAll();
        printAll(workers);
        */

        // workers = employeeRepository.findAll(Sort.by("firstName").descending());

        /*
        workers = employeeRepository.findAll(Sort.by(
                Sort.Order.by("firstName").with(Sort.Direction.ASC),
                Sort.Order.by("lastName").with(Sort.Direction.ASC)
        ));
         */

        /*
        Page<Employee> page = employeeRepository.findAll(PageRequest.of(2,10));
        log.info("page.getTotalElements: {}", page.getTotalElements());
        log.info("page.getTotalPages: {}", page.getTotalPages());
        log.info("page.getNumberOfElements: {}", page.getNumberOfElements());
        log.info("page.getNumber: {}", page.getNumber());
        workers = page.stream().collect(Collectors.toList());
        printAll(workers);
         */

        // printAll(employeeRepository.findByFirstNameIgnoreCase("adam"));

        // printAll(employeeRepository.findByLastNameOrderByFirstNameDesc("Nowak"));
        // printAll(employeeRepository.findBySallaryBetween(5000L, 8000L));
        // printAll(employeeRepository.findAllWithSalariesBetweenSomeValues(5000L, 8000L));

        // 07
        //printAll(employeeRepository.findGuyWithHighestSalary());
        //printAll(employeeRepository.findOnlyOneGuyWithHighestSalary());
        //printAll(employeeRepository.findNativelyWithSalariesBetweenSomeValues(9000L, 20000L));

        // 09
        log.info("Updated records: {}", employeeRepository.setSalaryForAll(15000L));
        printAll(employeeRepository.findAll());
    }

    private void printAll(List<Employee> workers) {
        log.info("printAll - size: {}", workers.size());
        workers.forEach(System.out::println);
    }
}

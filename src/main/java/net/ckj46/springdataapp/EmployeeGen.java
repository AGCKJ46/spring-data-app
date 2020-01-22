package net.ckj46.springdataapp;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Service
public class EmployeeGen {

    private List<String> names = new LinkedList<>();
    private List<String> surnames = new LinkedList<>();

    public void EmployeeGen(){

    }

    public List<Employee> gen(){
        surnames.add("Adam");
        surnames.add("Michał");
        surnames.add("Krzysztof");
        surnames.add("Marek");
        surnames.add("Grzegorz");

        surnames.add("Maciej");
        surnames.add("Andrzej");
        surnames.add("Marcin");
        surnames.add("Włodzimierz");
        surnames.add("Ireneusz");

        surnames.add("Waldemar");
        surnames.add("Mateusz");
        surnames.add("Sławomir");
        surnames.add("Roman");
        surnames.add("Romuald");


        names.add("Kowalski");
        names.add("Nowak");
        names.add("Binek");
        names.add("Pryboda");
        names.add("Tokarczyk");

        names.add("Hoffman");
        names.add("Palicki");
        names.add("Pawłowski");
        names.add("Reszke");
        names.add("Witerg");

        List<Employee> employees = new LinkedList<>();

        for (String name: names) {
            for (String surname: surnames) {
                Employee employee = new Employee();
                employee.setLastName(name);
                employee.setFirstName(surname);
                employee.setSallary(new BigDecimal(Math.round(Math.random()*10000)));
                employee.setEmploymentdate(LocalDate.now().minusDays(Math.round(Math.random()*100)));

                employees.add(employee);
            }
        }
        return employees;
    }
}

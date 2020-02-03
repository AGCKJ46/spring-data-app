package net.ckj46.springdataapp;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;



@Setter
@Getter
@NamedQuery(
        name = "Employee.findAllWithSalariesBetweenSomeValues",
        query = "select e from Employee e where e.salary between ?1 and ?2"
)
// lepszą alternatywa do tego rozwiazania jest umieszczenie takiego zapytania w repo z adnotacją @Query (patrz findGuyWithHighestSalary)
@Entity
public class Employee {
    @Transient
    private static Long idiki=1L;

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private Long salary;
    private LocalDate employmentDate;

    public Employee() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", salary=").append(salary);
        sb.append(", employmentDate=").append(employmentDate);
        sb.append('}');
        return sb.toString();
    }
}

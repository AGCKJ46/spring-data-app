package net.ckj46.springdataapp;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Data
public class Employee {
    @Transient
    private static Long idiki=1L;

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private BigDecimal sallary;
    private LocalDate employmentdate;

    public Employee() {
    }

}

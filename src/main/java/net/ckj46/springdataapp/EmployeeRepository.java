package net.ckj46.springdataapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByFirstName(String firstName);

    List<Employee> findByFirstNameIgnoreCase(String firstName);

    List<Employee> findByLastNameOrderByFirstNameDesc(String lastName);

    List<Employee> findBySalaryBetween(Long minSalary, Long maxSalary);

    List<Employee> findAllWithSalariesBetweenSomeValues(Long minSalary, Long maxSalary);

    @Transactional
    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query("update Employee e set e.salary = :newSalary")
    int  setSalaryForAll(@Param("newSalary") Long newSalary);

    // zapytanie JPQL
    @Query(value = "select e from Employee e where e.salary = (select max(m.salary) from Employee m)")
    List<Employee> findGuyWithHighestSalary();

    // zapytanie natywne
    @Query(
            value = "select * from Employee where salary = (select max(salary) from Employee) limit 1",
            nativeQuery = true)
    List<Employee> findOnlyOneGuyWithHighestSalary();

    // zapytanie natywne
    @Query(
            value = "select * from Employee where salary between :from and :to",
            nativeQuery = true)
    List<Employee> findNativelyWithSalariesBetweenSomeValues(Long from, Long to);
}

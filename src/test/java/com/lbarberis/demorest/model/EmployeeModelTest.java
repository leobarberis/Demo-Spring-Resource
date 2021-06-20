package com.lbarberis.demorest.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeModelTest {

    Employee employee;
    Department department;

    @BeforeEach
    void beforeEach() {
        employee = new Employee("Maxi",45, LocalDate.of(1990,10,6));
        department = new Department("Marketing", List.of(employee));
    }

    @Test
    @DisplayName("Employee creation succeeded")
    void employee_new_allParams() {
        employee.setDepartment(department);
        assertAll("Properties set", () -> assertAll("Employee",
                () -> assertEquals("Maxi", employee.getName()),
                () -> assertEquals(45, employee.getAge()),
                () -> assertEquals(LocalDate.of(1990,10,6), employee.getBirthdate())),
                () -> assertEquals("Marketing", employee.getDepartment().getName()));
    }

    @Test
    @DisplayName("Department creation succeeded")
    void department_new_allParams() {
        assertAll("Department Properties", () -> assertEquals("Marketing", department.getName()));
    }

}

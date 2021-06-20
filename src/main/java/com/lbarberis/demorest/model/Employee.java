package com.lbarberis.demorest.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Employee {

    private Long id;
    private String name;
    private int age;
    private LocalDate birthdate;
    private Department department;

    public Employee(String name, int age, LocalDate birthdate) {
        this.name = name;
        this.age = age;
        this.birthdate = birthdate;
    }
}

package com.lbarberis.demorest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeDTO {
    private String name;
    private int age;
    private String birthdate;
    private String department;
}

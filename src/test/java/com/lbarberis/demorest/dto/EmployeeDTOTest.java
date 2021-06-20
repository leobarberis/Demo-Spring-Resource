package com.lbarberis.demorest.dto;

import com.lbarberis.demorest.model.Department;
import com.lbarberis.demorest.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringJUnitConfig(classes = {EmployeeMapperImpl.class})
public class EmployeeDTOTest {

    @Autowired
    EmployeeMapper employeeMapper;

    Employee employee;
    Department department;
    EmployeeDTO employeeDTO;

    @BeforeEach
    void beforeEach() {
        employee = new Employee("Maxi",45, LocalDate.of(1990,10,6));
        department = new Department("Marketing", List.of(employee));
        employee.setDepartment(department);
        employeeDTO = employeeMapper.employeeToEmployeeDTO(employee);
    }

    @DisplayName("Employee to EmployeeDTO")
    @Test
    void map_employee_to_DTO() {
        assertThat("Maxi").isEqualTo(employeeDTO.getName());
        assertThat(45).isEqualTo(employeeDTO.getAge());
        assertThat("06/10/1990").isEqualTo(employeeDTO.getBirthdate());
        assertThat("Marketing").isEqualTo(employeeDTO.getDepartment());
    }
}

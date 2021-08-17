package com.lbarberis.demorest.dto;

import com.lbarberis.demorest.model.Employee;
import org.mapstruct.Mapper;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring")
public abstract class EmployeeMapper {
    DateTimeFormatter SIMPLE_DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public EmployeeDTO employeeToEmployeeDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setName(employee.getName());
        employeeDTO.setAge(employee.getAge());
        employeeDTO.setBirthdate(employee.getBirthdate().format(SIMPLE_DATE_FORMAT));
        employeeDTO.setDepartment(employee.getDepartment().getName());
        return employeeDTO;
    }
}

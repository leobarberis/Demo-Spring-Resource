package com.lbarberis.demorest.services;

import com.lbarberis.demorest.dto.EmployeeMapper;
import com.lbarberis.demorest.dto.EmployeeMapperImpl;
import com.lbarberis.demorest.helpers.SerializeService;
import com.lbarberis.demorest.model.Employee;
import com.lbarberis.demorest.repositories.EmployeeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.reset;

@ExtendWith({MockitoExtension.class, SpringExtension.class})
@ContextConfiguration(classes = {EmployeeMapperImpl.class})
public class EmployeeServiceTest {

    @Mock
    EmployeeRepository repository;

    //Notice we are not mocking mapper here
    @Autowired
    @Spy
    EmployeeMapper mapper;

    @InjectMocks
    EmployeeServiceImpl service;

    @BeforeEach
    void beforeEach() {
        given(repository.findAll()).willReturn(SerializeService.getListFromJson(Employee.class, "employees.json"));
    }

    @AfterEach
    void afterEach() {
        reset(repository);
    }

    @Test
    void findAllEmployees_notEmpty() {
        var employees = service.findAll();
        then(repository).should().findAll();
        assertThat(employees).isNotEmpty();
        assertThat(employees.stream().filter(e -> e.getDepartment().equals("HR")).count()).isEqualTo(2);
    }

}

package com.lbarberis.demorest.repositories;

import com.lbarberis.demorest.helpers.SerializeService;
import com.lbarberis.demorest.model.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository repository;

    @BeforeEach
    void beforeEach() {
        repository.saveAll(SerializeService.getListFromJson(Employee.class, "employees.json"));
    }

    @AfterEach
    void afterEach() {
        repository.deleteAll();
    }

    @Test
    public void findAllEmployees_notEmpty() {
        List<Employee> employees = repository.findAll();
        assertThat(employees).isNotEmpty();
    }

    @Test
    public void findByName_success() {
        Optional<Employee> roger = repository.findByName("Roger");
        assertThat(roger.isEmpty()).isFalse();
        assertThat(roger.get().getName()).isEqualTo("Roger");
        assertThat(roger.get().getAge()).isEqualTo(30);
        assertThat(roger.get().getDepartment().getName()).isEqualTo("HR");
    }
}

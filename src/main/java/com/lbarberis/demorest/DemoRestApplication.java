package com.lbarberis.demorest;

import com.lbarberis.demorest.helpers.SerializeService;
import com.lbarberis.demorest.model.Employee;
import com.lbarberis.demorest.repositories.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class DemoRestApplication {

    @Profile("dev")
    @Bean
    CommandLineRunner init(EmployeeRepository repository) {
        return (args) -> {
            repository.saveAll(SerializeService.getListFromJson(Employee.class, "employees.json"));
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoRestApplication.class, args);
    }

}

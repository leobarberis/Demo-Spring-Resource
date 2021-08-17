package com.lbarberis.demorest.services;

import com.lbarberis.demorest.dto.EmployeeDTO;
import com.lbarberis.demorest.dto.EmployeeMapper;
import com.lbarberis.demorest.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeMapper mapper;
    EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeMapper mapper, EmployeeRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public List<EmployeeDTO> findAll() {
        return repository.findAll().stream().map(mapper::employeeToEmployeeDTO).collect(Collectors.toList());
    }
}

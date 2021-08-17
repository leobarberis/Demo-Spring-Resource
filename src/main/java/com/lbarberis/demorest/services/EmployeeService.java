package com.lbarberis.demorest.services;

import com.lbarberis.demorest.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> findAll();
}

package com.lbarberis.demorest.resources;

import com.lbarberis.demorest.dto.EmployeeDTO;
import com.lbarberis.demorest.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1.0")
public class EmployeeResource {

    private EmployeeService service;

    public EmployeeResource(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDTO>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
}

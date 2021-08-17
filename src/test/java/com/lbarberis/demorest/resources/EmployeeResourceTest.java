package com.lbarberis.demorest.resources;

import com.lbarberis.demorest.dto.EmployeeDTO;
import com.lbarberis.demorest.helpers.SerializeService;
import com.lbarberis.demorest.services.EmployeeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.hamcrest.Matchers.*;

@WebMvcTest
public class EmployeeResourceTest {

    @MockBean
    EmployeeService service;

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("GET v1.0/employees - FOUND")
    void findAll_notEmpty() throws Exception {
        given(service.findAll()).willReturn(SerializeService.getListFromJson(EmployeeDTO.class, "employeesDTO.json"));
        mockMvc.perform(get("/v1.0/employees"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", not(empty())))
                .andExpect(jsonPath("$", hasSize(2)));
    }
}

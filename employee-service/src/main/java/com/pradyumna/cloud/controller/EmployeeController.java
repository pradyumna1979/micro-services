package com.pradyumna.cloud.controller;

import com.pradyumna.cloud.dto.EmployeeDTO;
import com.pradyumna.cloud.entity.Employee;
import com.pradyumna.cloud.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    public static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
    EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping("/")
    public Employee add(@RequestBody Employee employee) {
        LOGGER.info("Employee add: {}", employee);
        return employeeService.add(employee);
    }

    @GetMapping("/{id}")
    public Optional<Employee> findById(@PathVariable("id") Long id) {
        LOGGER.info("Employee find: id={}", id);
        return employeeService.findById(id);
    }

    @GetMapping("/")
    public List<Employee> findAll() {
        LOGGER.info("Employee find");
        return employeeService.findAll();
    }

    @GetMapping("/department/{departmentId}")
    public List<EmployeeDTO> findByDepartmentId(@PathVariable("departmentId") Long departmentId) {
        LOGGER.info("Employee find: departmentId={}", departmentId);
        return employeeService.findByDepartmentId(departmentId);
    }

    @GetMapping("/organization/{organizationId}")
    public List<EmployeeDTO> findByOrganizationId(@PathVariable("organizationId") Long organizationId) {
        LOGGER.info("Employee find: organizationId={}", organizationId);
        return employeeService.findByOrganizationId(organizationId);
    }
}

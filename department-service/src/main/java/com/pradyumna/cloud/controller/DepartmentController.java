package com.pradyumna.cloud.controller;

import com.pradyumna.cloud.client.EmployeeClient;
import com.pradyumna.cloud.entity.Department;
import com.pradyumna.cloud.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    private static final Logger LOGGER = LoggerFactory.getLogger("DepartmentController");
    DepartmentService departmentService;
    EmployeeClient employeeClient;
    @Autowired
    public DepartmentController(DepartmentService departmentService, EmployeeClient employeeClient) {
        this.departmentService = departmentService;
        this.employeeClient = employeeClient;
    }
    @PostMapping("/")
    public Department add(@RequestBody Department department) {
        LOGGER.info("Department add: {}", department);
        return departmentService.add(department);
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable("id") Long id) throws Exception {
        LOGGER.info("Department find: id={}", id);
        return departmentService.findById(id).orElseThrow(() -> new Exception("Department not found : "+id));
    }

    @GetMapping("/")
    public List<Department> findAll() {
        LOGGER.info("Department find");
        return departmentService.findAll();
    }

    @GetMapping("/organization/{organizationId}")
    public List<Department> findByOrganization(@PathVariable("organizationId") Long organizationId) {
        LOGGER.info("Department find: organizationId={}", organizationId);
        return departmentService.findByOrganization(organizationId);
    }

    @GetMapping("/organization/{organizationId}/with-employees")
    public List<Department> findByOrganizationWithEmployees(@PathVariable("organizationId") Long organizationId) {
        LOGGER.info("Department find: organizationId={}", organizationId);
        List<Department> departments = departmentService.findByOrganization(organizationId);
        departments.forEach(d -> d.setEmployees(employeeClient.findByDepartment(d.getId())));
        return departments;
    }
}

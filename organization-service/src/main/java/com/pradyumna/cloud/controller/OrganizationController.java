package com.pradyumna.cloud.controller;

import com.pradyumna.cloud.client.DepartmentClient;
import com.pradyumna.cloud.client.EmployeeClient;
import com.pradyumna.cloud.entity.Organization;
import com.pradyumna.cloud.service.OrganizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrganizationController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationController.class);

    @Autowired
    OrganizationService organizationService;
    @Autowired
    DepartmentClient departmentClient;
    @Autowired
    EmployeeClient employeeClient;

    @PostMapping("/")
    public Organization add(@RequestBody Organization organization) {
        LOGGER.info("Organization add: {}", organization);
        return organizationService.add(organization);
    }

    @GetMapping("/")
    public List<Organization> findAll() {
        LOGGER.info("Organization find");
        return organizationService.findAll();
    }

    @GetMapping("/{id}")
    public Organization findById(@PathVariable("id") Long id) throws Exception {
        LOGGER.info("Organization find: id={}", id);
        return organizationService.findById(id).orElseThrow(() -> new Exception("Organization Not found for : "+id));
    }

    @GetMapping("/{id}/with-departments")
    public Organization findByIdWithDepartments(@PathVariable("id") Long id) throws Exception {
        LOGGER.info("Organization find: id={}", id);
        Organization organization = organizationService.findById(id).orElseThrow(() -> new Exception("Organisation not found for : "+id));
        organization.setDepartments(departmentClient.findByOrganizationId(organization.getId()));
        return organization;
    }

    @GetMapping("/{id}/with-departments-and-employees")
    public Organization findByIdWithDepartmentsAndEmployees(@PathVariable("id") Long id) throws Exception {
        LOGGER.info("Organization find: id={}", id);
        Organization organization = organizationService.findById(id).orElseThrow(()->new Exception("Organization not found for : "+id));
        organization.setDepartments(departmentClient.findByOrganizationWithEmployees(organization.getId()));
        return organization;
    }

    @GetMapping("/{id}/with-employees")
    public Organization findByIdWithEmployees(@PathVariable("id") Long id) throws Exception {
        LOGGER.info("Organization find: id={}", id);
        Organization organization = organizationService.findById(id).orElseThrow(() -> new Exception("Organization not found for : "+id));
        organization.setEmployees(employeeClient.findByOrganizationId(organization.getId()));
        return organization;
    }

}

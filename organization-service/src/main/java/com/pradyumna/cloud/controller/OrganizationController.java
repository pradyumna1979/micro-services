package com.pradyumna.cloud.controller;

import com.pradyumna.cloud.client.DepartmentClient;
import com.pradyumna.cloud.client.EmployeeClient;
import com.pradyumna.cloud.dto.OrganizationDTO;
import com.pradyumna.cloud.entity.Organization;
import com.pradyumna.cloud.service.OrganizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<OrganizationDTO> findAll() {
        LOGGER.info("Organization find");
        return organizationService.findAll()
                .stream()
                .map(organization ->
                     OrganizationDTO.builder()
                            .id(organization.getId())
                            .name(organization.getName())
                            .address(organization.getAddress())
                            .build()
                ).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public OrganizationDTO findById(@PathVariable("id") Long id) throws Exception {
        LOGGER.info("Organization find: id={}", id);
        Organization organization= organizationService.findById(id).orElseThrow(() -> new Exception("Organization Not found for : "+id));
        return  OrganizationDTO.builder()
                .id(organization.getId())
                .name(organization.getName())
                .address(organization.getAddress())
                .build();
    }

    @GetMapping("/{id}/with-departments")
    public OrganizationDTO findByIdWithDepartments(@PathVariable("id") Long id) throws Exception {
        LOGGER.info("Organization find: id={}", id);
        Organization organization = organizationService.findById(id).orElseThrow(() -> new Exception("Organisation not found for : "+id));
        return   OrganizationDTO.builder()
                .id(organization.getId())
                .name(organization.getName())
                .address(organization.getAddress())
                .departmentDTOS(departmentClient.findByOrganizationId(organization.getId()))
                .build();
    }

    @GetMapping("/{id}/with-departments-and-employees")
    public OrganizationDTO findByIdWithDepartmentsAndEmployees(@PathVariable("id") Long id) throws Exception {
        LOGGER.info("Organization find: id={}", id);
        Organization organization = organizationService.findById(id).orElseThrow(()->new Exception("Organization not found for : "+id));
        return   OrganizationDTO.builder()
                .id(organization.getId())
                .name(organization.getName())
                .address(organization.getAddress())
                .departmentDTOS(departmentClient.findByOrganizationWithEmployees(organization.getId()))
                .build();
    }

    @GetMapping("/{id}/with-employees")
    public OrganizationDTO findByIdWithEmployees(@PathVariable("id") Long id) throws Exception {
        LOGGER.info("Organization find: id={}", id);
        Organization organization = organizationService.findById(id).orElseThrow(() -> new Exception("Organization not found for : "+id));
        return   OrganizationDTO.builder()
                .id(organization.getId())
                .name(organization.getName())
                .address(organization.getAddress())
                .employeeDTOS(employeeClient.findByOrganizationId(organization.getId()))
                .build();

    }

}

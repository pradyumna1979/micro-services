package com.pradyumna.cloud.service;
import com.pradyumna.cloud.dto.EmployeeDTO;
import com.pradyumna.cloud.entity.Employee;
import com.pradyumna.cloud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee add(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public List<EmployeeDTO> findByDepartmentId(Long departmentId) {
        return employeeRepository.findByDeptId(departmentId)
                .stream()
                .map(employee -> EmployeeDTO.builder()
                        .id(employee.getId())
                        .name(employee.getName())
                        .age(employee.getAge())
                        .build())
                .collect(Collectors.toList());
    }

    public List<EmployeeDTO> findByOrganizationId(Long organizationId) {
        return employeeRepository.findByOrgId(organizationId)
                .stream()
                .map(employee -> EmployeeDTO.builder()
                        .id(employee.getId())
                        .name(employee.getName())
                        .age(employee.getAge())
                        .build())
                .collect(Collectors.toList());
    }
}

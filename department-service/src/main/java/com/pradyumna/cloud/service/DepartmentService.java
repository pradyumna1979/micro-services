package com.pradyumna.cloud.service;

import com.pradyumna.cloud.entity.Department;
import com.pradyumna.cloud.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DepartmentService {
    DepartmentRepository departmentRepository;
    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department add(Department department) {
        return departmentRepository.save(department);
    }

    public Optional<Department> findById(Long id) {
        return departmentRepository.findById(id);
    }

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    public List<Department> findByOrganization(Long organizationId) {
        return departmentRepository.findByOrganizationId(organizationId);
    }
}

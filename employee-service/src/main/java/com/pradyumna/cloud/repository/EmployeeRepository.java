package com.pradyumna.cloud.repository;

import com.pradyumna.cloud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    List<Employee> findByDepartmentId(Long departmentId);


    List<Employee> findByOrganizationId(Long organizationId);
}

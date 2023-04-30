package com.pradyumna.cloud.repository;

import com.pradyumna.cloud.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    List<Department> findByOrganization(Long organizationId);


    List<Department> findByOrganizationId(Long organizationId);
}

package com.pradyumna.cloud.client;

import com.pradyumna.cloud.entity.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Set;

@FeignClient(name = "employee-service")
public interface EmployeeClient {
    @GetMapping("/organization/{organizationId}")
    Set<Employee> findByOrganization(@PathVariable("organizationId") Long organizationId);
    @GetMapping("/department/{departmentId}")
    Set<Employee> findByDepartment(@PathVariable("departmentId") Long departmentId);
}

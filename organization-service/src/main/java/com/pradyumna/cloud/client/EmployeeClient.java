package com.pradyumna.cloud.client;

import com.pradyumna.cloud.entity.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

@FeignClient(name = "employee-service")
public interface EmployeeClient {
    @GetMapping("/organization/{organizationId}")
    public Set<Employee> findByOrganizationId(@PathVariable("organizationId") Long organizationId);
}

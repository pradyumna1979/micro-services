package com.pradyumna.cloud.client;

import com.pradyumna.cloud.entity.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Set;

@FeignClient(name = "department-service")
public interface DepartmentClient {
    @GetMapping("/organization/{organizationId}/with-employees")
    Set<Department> findByOrganizationWithEmployees(@PathVariable("organizationId") Long organizationId);
    @GetMapping("/organization/{organizationId}")
    public Set<Department> findByOrganizationId(@PathVariable("organizationId") Long  organizationId);

}

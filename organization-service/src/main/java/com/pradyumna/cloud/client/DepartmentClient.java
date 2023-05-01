package com.pradyumna.cloud.client;

import com.pradyumna.cloud.dto.DepartmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Set;

@FeignClient(name = "department-service")
public interface DepartmentClient {
    @GetMapping("/organization/{organizationId}/with-employees")
    Set<DepartmentDTO> findByOrganizationWithEmployees(@PathVariable("organizationId") Long organizationId);
    @GetMapping("/organization/{organizationId}")
    public Set<DepartmentDTO> findByOrganizationId(@PathVariable("organizationId") Long  organizationId);
}

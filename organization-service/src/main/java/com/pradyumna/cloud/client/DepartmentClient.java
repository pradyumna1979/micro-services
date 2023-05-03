package com.pradyumna.cloud.client;

import com.pradyumna.cloud.dto.DepartmentDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.Set;

@HttpExchange
public interface DepartmentClient {
    @GetExchange("/organization/{organizationId}/with-employees")
    Set<DepartmentDTO> findByOrganizationWithEmployees(@PathVariable("organizationId") Long organizationId);
    @GetExchange("/organization/{organizationId}")
    public Set<DepartmentDTO> findByOrganizationId(@PathVariable("organizationId") Long  organizationId);
}

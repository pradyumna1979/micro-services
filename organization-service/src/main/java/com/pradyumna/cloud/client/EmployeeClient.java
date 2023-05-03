package com.pradyumna.cloud.client;

import com.pradyumna.cloud.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.Set;

@HttpExchange
public interface EmployeeClient {
    @GetExchange("/organization/{organizationId}")
    public Set<EmployeeDTO> findByOrganizationId(@PathVariable("organizationId") Long organizationId);
}

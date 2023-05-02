package com.pradyumna.cloud.dto;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@XmlRootElement(namespace = "organization")
public class OrganizationDTO {
    private Long id;
    private String name;
    private String address;

    private Set<DepartmentDTO> departmentDTOS = new HashSet<>();

    private Set<EmployeeDTO> employeeDTOS = new HashSet<>();
}

package com.pradyumna.cloud.dto;

import com.pradyumna.cloud.entity.Department;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@XmlRootElement(name = "organization")
public class OrganizationDTO implements Serializable {
    private Long id;
    private String name;
    private String address;
    private Set<DepartmentDTO> departments = new HashSet<>();
    private Set<EmployeeDTO> employees = new HashSet<>();
}

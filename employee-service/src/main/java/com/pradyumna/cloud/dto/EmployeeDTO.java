package com.pradyumna.cloud.dto;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@XmlRootElement(name = "employee")
public class EmployeeDTO implements Serializable {
    private Long id;
    private String name;
    private int age;
    private String position;
    @XmlElement(name = "organization")
    private OrganizationDTO organizationDTO;
    @XmlElement(name="department")
    private DepartmentDTO departmentDTO;
}

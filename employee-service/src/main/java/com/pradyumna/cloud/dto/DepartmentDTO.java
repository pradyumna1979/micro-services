package com.pradyumna.cloud.dto;

import com.pradyumna.cloud.entity.Employee;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "department")
public class DepartmentDTO implements Serializable {
    private Long id;
    private String name;
    @XmlElement(name = "organization")
    private OrganizationDTO organizationDTO;
    @XmlElement(name = "employee")
    private Set<Employee> employees = new HashSet<>();
}

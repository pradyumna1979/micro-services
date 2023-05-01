package com.pradyumna.cloud.dto;

import com.pradyumna.cloud.entity.Organization;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "employee")
public class EmployeeDTO implements Serializable {

    private Long id;
    private String name;
    private int age;
    private String position;

    private OrganizationDTO organizationDTO;
    private DepartmentDTO departmentDTO;
}

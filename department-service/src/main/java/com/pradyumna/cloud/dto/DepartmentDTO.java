package com.pradyumna.cloud.dto;

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
    private Long orgId;
    @XmlElement(name = "departments")
    private Set<EmployeeDTO> employeeDTOS = new HashSet<>();
}

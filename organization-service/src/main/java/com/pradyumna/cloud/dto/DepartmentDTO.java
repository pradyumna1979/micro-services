package com.pradyumna.cloud.dto;

import com.pradyumna.cloud.entity.Organization;
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
    private Organization organization;
    private Set<EmployeeDTO> employeeDTOS = new HashSet<>();
}

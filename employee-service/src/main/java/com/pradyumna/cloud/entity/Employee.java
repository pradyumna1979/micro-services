package com.pradyumna.cloud.entity;

import com.pradyumna.cloud.dto.DepartmentDTO;
import com.pradyumna.cloud.dto.OrganizationDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="emp_id")
    private Long id;
    private String name;
    private int age;
    private String position;
    @NotNull
    private Long orgId;
    @NotNull
    private Long deptId;
}

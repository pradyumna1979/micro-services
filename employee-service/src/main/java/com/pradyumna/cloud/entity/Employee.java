package com.pradyumna.cloud.entity;

import jakarta.persistence.*;
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
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "org_id", nullable = false)
    private Organization organization;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "dept_id", nullable = false)
    private Department department;
}

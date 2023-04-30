package com.pradyumna.cloud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Organization implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "org_id")
    private Long id;
    private String name;
    private String address;
    @OneToMany(mappedBy = "organization", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Department> departments = new HashSet<>();
    @OneToMany(mappedBy = "organization", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Employee> employees = new HashSet<>();
}

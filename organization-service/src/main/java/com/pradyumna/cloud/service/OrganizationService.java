package com.pradyumna.cloud.service;

import com.pradyumna.cloud.entity.Organization;
import com.pradyumna.cloud.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OrganizationService {
    private OrganizationRepository organizationRepository;
    @Autowired
    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    public Organization add(Organization organization) {
        return organizationRepository.save(organization);
    }

    public List<Organization> findAll() {
        return organizationRepository.findAll();
    }

    public Optional<Organization> findById(Long id) {
        return organizationRepository.findById(id);
    }
}

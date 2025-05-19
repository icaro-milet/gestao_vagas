package com.milet.gestao_vagas.modules.company.repositories;

import com.milet.gestao_vagas.modules.company.entities.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JobRepository extends JpaRepository<JobEntity, UUID> {

    // select * from job where description like %filter%
    List<JobEntity> findByDescriptionContainingIgnoreCase(String filter);
}

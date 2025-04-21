package com.milet.gestao_vagas.modules.company.useCases;

import com.milet.gestao_vagas.exceptions.UserFoundException;
import com.milet.gestao_vagas.modules.company.entities.CompanyEntity;
import com.milet.gestao_vagas.modules.company.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CreateCompanyUseCase {

    @Autowired
    private CompanyRepository companyRepository;

    public CompanyEntity execute(CompanyEntity companyEntity){

        this.companyRepository
                .findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
                .ifPresent((user) -> {
                   throw new UserFoundException();
                });

        return this.companyRepository.save(companyEntity);
    }
}

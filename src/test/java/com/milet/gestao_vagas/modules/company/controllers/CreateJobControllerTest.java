package com.milet.gestao_vagas.modules.company.controllers;

import com.milet.gestao_vagas.modules.company.dtos.CreateJobDTO;
import com.milet.gestao_vagas.modules.company.entities.CompanyEntity;
import com.milet.gestao_vagas.modules.company.repositories.CompanyRepository;
import com.milet.gestao_vagas.utils.UtilsTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;




@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class CreateJobControllerTest {

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private CompanyRepository companyRepository;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(SecurityMockMvcConfigurers.springSecurity())
                .build();
    }

    @Test
    public void should_be_able_to_create_a_new_job() throws Exception {

        var company = CompanyEntity.builder()
                .description("COMPANY_DESCRIPTION")
                .email("company@mail.com")
                .username("COMPANY_USERNAME")
                .password("1234567890")
                .name("COMPANY_NAME")
                .build();

        company = companyRepository.saveAndFlush(company);

        var createJobDTO = CreateJobDTO.builder()
                .benefits("BENEFITS_TEST")
                .description("DESCRIPTION_TEST")
                .level("LEVEL_TEST")
                .build();

        var result = mvc.perform(MockMvcRequestBuilders.post("/company/job/create")
                        .contentType(MediaType.APPLICATION_JSON) // ✅ define o tipo correto
                        .content(UtilsTest.objectToJSON(createJobDTO)) // ✅ envia o JSON como corpo
                        .header("Authorization",
                                UtilsTest.generateToken(
                                        company.getId(),
                                        "JAVAGAS_@123#"))
                )
                .andDo(org.springframework.test.web.servlet.result.MockMvcResultHandlers.print()) // ajuda a depurar
                .andExpect(MockMvcResultMatchers.status().isOk());

        System.out.println(result);
    }

}

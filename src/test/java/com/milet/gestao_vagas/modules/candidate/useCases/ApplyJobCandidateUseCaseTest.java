package com.milet.gestao_vagas.modules.candidate.useCases;

import com.milet.gestao_vagas.exceptions.JobNotFoundException;
import com.milet.gestao_vagas.exceptions.UserNotFoundException;
import com.milet.gestao_vagas.modules.candidate.entities.ApplyJobEntity;
import com.milet.gestao_vagas.modules.candidate.entities.CandidateEntity;
import com.milet.gestao_vagas.modules.candidate.repositories.ApplyJobRepository;
import com.milet.gestao_vagas.modules.candidate.repositories.CandidateRepository;
import com.milet.gestao_vagas.modules.company.entities.JobEntity;
import com.milet.gestao_vagas.modules.company.repositories.JobRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class ApplyJobCandidateUseCaseTest {

    @InjectMocks
    private ApplyJobCandidateUseCase applyJobCandidateUseCase;

    @Mock
    private CandidateRepository candidateRepository;

    @Mock
    private JobRepository jobRepository;

    @Mock
    private ApplyJobRepository applyJobRepository;

    @Test
    @DisplayName("Should not be able to apply job with candidate not found")
    public void should_not_be_able_to_apply_job_with_candidate_not_found(){
        try {
            applyJobCandidateUseCase.execute(null,null);
        } catch (Exception e) {
            assertThat(e).isInstanceOf(UserNotFoundException.class);
        }
    }

    @Test
    public void should_not_be_able_to_apply_job_with_job_not_found(){
        var idCandidate = UUID.randomUUID();

        var candidate = new CandidateEntity();
        candidate.setId(idCandidate);

        when(candidateRepository.findById(idCandidate)).thenReturn(Optional.of(candidate));

        try {
            applyJobCandidateUseCase.execute(idCandidate,null);
        } catch (Exception e) {
            assertThat(e).isInstanceOf(JobNotFoundException.class);
        }
    }

    //TODO: Debug
    @Test
    public void should_be_able_to_create_a_new_apply_job(){
        //region variables
        var candidateId = UUID.randomUUID();
        var jobId = UUID.randomUUID();

        var applyJobToCreate = ApplyJobEntity.builder()
                .candidateId(candidateId)
                .jobId(jobId)
                .build();

        var applyJobCreated = ApplyJobEntity.builder()
                        .id(UUID.randomUUID())
                        .build();
        //endregion
        when(candidateRepository.findById(candidateId)).thenReturn(Optional.of(new CandidateEntity()));
        when(jobRepository.findById(jobId)).thenReturn(Optional.of(new JobEntity()));
        when(applyJobRepository.save(applyJobToCreate)).thenReturn(applyJobCreated);

        var result = applyJobCandidateUseCase.execute(candidateId, jobId);
        assertThat(result).hasFieldOrProperty("id");
    }
}

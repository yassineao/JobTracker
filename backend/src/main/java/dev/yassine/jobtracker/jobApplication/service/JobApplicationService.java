package dev.yassine.jobtracker.jobApplication.service;

import dev.yassine.jobtracker.jobApplication.dto.JobApplicationCreateRequest;
import dev.yassine.jobtracker.jobApplication.dto.JobApplicationUpdateRequest;
import dev.yassine.jobtracker.jobApplication.entity.JobApplication;
import dev.yassine.jobtracker.jobApplication.entity.JobStatus;
import dev.yassine.jobtracker.jobApplication.mapper.JobApplicationMapper;
import dev.yassine.jobtracker.jobApplication.repository.JobApplicationRepository;
import dev.yassine.jobtracker.user.entity.User;
import dev.yassine.jobtracker.user.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class JobApplicationService {

    private final JobApplicationRepository jobRepo;
    private final UserRepository userRepo;

    public JobApplicationService(JobApplicationRepository jobRepo, UserRepository userRepo) {
        this.jobRepo = jobRepo;
        this.userRepo = userRepo;
    }

    @Transactional
    public JobApplication create(UUID userId, JobApplicationCreateRequest req) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        JobApplication e = new JobApplication();
        e.setUser(user);
        JobApplicationMapper.applyCreate(e, req);
        return jobRepo.save(e);
    }

    @Transactional(readOnly = true)
    public Page<JobApplication> list(UUID userId, JobStatus status, Pageable pageable) {
        if (status == null) {
            return jobRepo.findAllByUser_Id(userId, pageable);
        }
        return jobRepo.findAllByUser_IdAndStatus(userId, status, pageable);
    }

    @Transactional(readOnly = true)
    public JobApplication get(UUID userId, UUID applicationId) {
        JobApplication e = jobRepo.findById(applicationId)
                .orElseThrow(() -> new EntityNotFoundException("JobApplication not found"));

        if (!e.getUser().getId().equals(userId)) {
            throw new EntityNotFoundException("JobApplication not found");
        }
        return e;
    }

    @Transactional
    public JobApplication update(UUID userId, UUID applicationId, JobApplicationUpdateRequest req) {
        JobApplication e = get(userId, applicationId);
        JobApplicationMapper.applyUpdate(e, req);
        return jobRepo.save(e);
    }

    @Transactional
    public void delete(UUID userId, UUID applicationId) {
        JobApplication e = get(userId, applicationId);
        jobRepo.delete(e);
    }
}

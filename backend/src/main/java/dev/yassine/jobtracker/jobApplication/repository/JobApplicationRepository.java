package dev.yassine.jobtracker.jobApplication.repository;

import dev.yassine.jobtracker.jobApplication.entity.JobApplication;
import dev.yassine.jobtracker.jobApplication.entity.JobStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JobApplicationRepository extends JpaRepository<JobApplication, UUID> {

    Page<JobApplication> findAllByUser_Id(UUID userId, Pageable pageable);

    Page<JobApplication> findAllByUser_IdAndStatus(UUID userId, JobStatus status, Pageable pageable);
}

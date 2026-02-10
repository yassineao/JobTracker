package dev.yassine.jobtracker.interview.repository;

import dev.yassine.jobtracker.interview.entity.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface InterviewRepository extends JpaRepository<Interview, UUID> {
    List<Interview> findAllByJobApplication_Id(UUID jobApplicationId);
}

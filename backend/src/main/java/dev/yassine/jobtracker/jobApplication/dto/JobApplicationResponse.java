package dev.yassine.jobtracker.jobApplication.dto;

import dev.yassine.jobtracker.jobApplication.entity.JobSource;
import dev.yassine.jobtracker.jobApplication.entity.JobStatus;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

public class JobApplicationResponse {

    private UUID id;
    private String company;
    private String position;
    private String location;

    private JobStatus status;
    private JobSource source;

    private Integer salaryMin;
    private Integer salaryMax;

    private LocalDate appliedDate;
    private LocalDate deadline;

    private String notes;

    private Instant createdAt;
    private Instant updatedAt;

    // getters/setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public JobStatus getStatus() { return status; }
    public void setStatus(JobStatus status) { this.status = status; }

    public JobSource getSource() { return source; }
    public void setSource(JobSource source) { this.source = source; }

    public Integer getSalaryMin() { return salaryMin; }
    public void setSalaryMin(Integer salaryMin) { this.salaryMin = salaryMin; }

    public Integer getSalaryMax() { return salaryMax; }
    public void setSalaryMax(Integer salaryMax) { this.salaryMax = salaryMax; }

    public LocalDate getAppliedDate() { return appliedDate; }
    public void setAppliedDate(LocalDate appliedDate) { this.appliedDate = appliedDate; }

    public LocalDate getDeadline() { return deadline; }
    public void setDeadline(LocalDate deadline) { this.deadline = deadline; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }

    public Instant getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }
}

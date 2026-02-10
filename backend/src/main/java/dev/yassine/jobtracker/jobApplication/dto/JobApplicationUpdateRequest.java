package dev.yassine.jobtracker.jobApplication.dto;

import dev.yassine.jobtracker.jobApplication.entity.JobSource;
import dev.yassine.jobtracker.jobApplication.entity.JobStatus;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class JobApplicationUpdateRequest {

    @Size(max = 255)
    private String company;

    @Size(max = 255)
    private String position;

    @Size(max = 255)
    private String location;

    private JobStatus status;
    private JobSource source;

    private Integer salaryMin;
    private Integer salaryMax;

    private LocalDate appliedDate;
    private LocalDate deadline;

    private String notes;

    // getters/setters
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
}

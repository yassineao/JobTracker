package dev.yassine.jobtracker.jobApplication.mapper;


import dev.yassine.jobtracker.jobApplication.dto.JobApplicationCreateRequest;
import dev.yassine.jobtracker.jobApplication.dto.JobApplicationResponse;
import dev.yassine.jobtracker.jobApplication.dto.JobApplicationUpdateRequest;
import dev.yassine.jobtracker.jobApplication.entity.JobApplication;

public class JobApplicationMapper {

    public static JobApplicationResponse toResponse(JobApplication e) {
        JobApplicationResponse r = new JobApplicationResponse();
        r.setId(e.getId());
        r.setCompany(e.getCompany());
        r.setPosition(e.getPosition());
        r.setLocation(e.getLocation());
        r.setStatus(e.getStatus());
        r.setSource(e.getSource());
        r.setSalaryMin(e.getSalaryMin());
        r.setSalaryMax(e.getSalaryMax());
        r.setAppliedDate(e.getAppliedDate());
        r.setDeadline(e.getDeadline());
        r.setNotes(e.getNotes());
        r.setCreatedAt(e.getCreatedAt());
        r.setUpdatedAt(e.getUpdatedAt());
        return r;
    }

    public static void applyCreate(JobApplication e, JobApplicationCreateRequest req) {
        e.setCompany(req.getCompany());
        e.setPosition(req.getPosition());
        e.setLocation(req.getLocation());
        if (req.getStatus() != null) e.setStatus(req.getStatus());
        e.setSource(req.getSource());
        e.setSalaryMin(req.getSalaryMin());
        e.setSalaryMax(req.getSalaryMax());
        e.setAppliedDate(req.getAppliedDate());
        e.setDeadline(req.getDeadline());
        e.setNotes(req.getNotes());
    }

    public static void applyUpdate(JobApplication e, JobApplicationUpdateRequest req) {
        if (req.getCompany() != null) e.setCompany(req.getCompany());
        if (req.getPosition() != null) e.setPosition(req.getPosition());
        if (req.getLocation() != null) e.setLocation(req.getLocation());
        if (req.getStatus() != null) e.setStatus(req.getStatus());
        if (req.getSource() != null) e.setSource(req.getSource());
        if (req.getSalaryMin() != null) e.setSalaryMin(req.getSalaryMin());
        if (req.getSalaryMax() != null) e.setSalaryMax(req.getSalaryMax());
        if (req.getAppliedDate() != null) e.setAppliedDate(req.getAppliedDate());
        if (req.getDeadline() != null) e.setDeadline(req.getDeadline());
        if (req.getNotes() != null) e.setNotes(req.getNotes());
    }
}

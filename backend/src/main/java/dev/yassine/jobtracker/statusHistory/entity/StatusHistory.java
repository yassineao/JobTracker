package dev.yassine.jobtracker.statusHistory.entity;

import dev.yassine.jobtracker.jobApplication.entity.JobApplication;
import dev.yassine.jobtracker.jobApplication.entity.JobStatus;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "status_history")
public class StatusHistory {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "job_application_id", nullable = false)
    private JobApplication jobApplication;

    @Enumerated(EnumType.STRING)
    @Column(name = "from_status", length = 50)
    private JobStatus fromStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "to_status", nullable = false, length = 50)
    private JobStatus toStatus;

    @Column(name = "changed_at", nullable = false, updatable = false)
    private Instant changedAt;

    @PrePersist
    void onCreate() {
        this.changedAt = Instant.now();
    }

    // getters/setters
    public UUID getId() { return id; }

    public JobApplication getJobApplication() { return jobApplication; }
    public void setJobApplication(JobApplication jobApplication) { this.jobApplication = jobApplication; }

    public JobStatus getFromStatus() { return fromStatus; }
    public void setFromStatus(JobStatus fromStatus) { this.fromStatus = fromStatus; }

    public JobStatus getToStatus() { return toStatus; }
    public void setToStatus(JobStatus toStatus) { this.toStatus = toStatus; }

    public Instant getChangedAt() { return changedAt; }
}

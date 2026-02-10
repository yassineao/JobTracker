CREATE TABLE status_history (
  id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

  job_application_id UUID NOT NULL,

  from_status VARCHAR(50),
  to_status VARCHAR(50) NOT NULL,
  changed_at TIMESTAMP NOT NULL DEFAULT NOW(),

  CONSTRAINT fk_status_history_job_application
    FOREIGN KEY (job_application_id) REFERENCES job_applications(id)
      ON DELETE CASCADE
);

CREATE INDEX idx_status_history_job_application_id ON status_history(job_application_id);
CREATE INDEX idx_status_history_changed_at ON status_history(changed_at);

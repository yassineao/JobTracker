CREATE TABLE interviews (
  id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

  job_application_id UUID NOT NULL,

  scheduled_at TIMESTAMP NOT NULL,
  type VARCHAR(50) NOT NULL,
  status VARCHAR(50) NOT NULL,

  interviewer VARCHAR(255),
  meeting_link TEXT,
  feedback TEXT,

  created_at TIMESTAMP NOT NULL DEFAULT NOW(),
  updated_at TIMESTAMP NOT NULL DEFAULT NOW(),

  CONSTRAINT fk_interviews_job_application
    FOREIGN KEY (job_application_id) REFERENCES job_applications(id)
      ON DELETE CASCADE
);

CREATE INDEX idx_interviews_job_application_id ON interviews(job_application_id);
CREATE INDEX idx_interviews_scheduled_at ON interviews(scheduled_at);

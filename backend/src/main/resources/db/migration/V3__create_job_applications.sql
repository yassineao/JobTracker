CREATE TABLE job_applications (
  id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

  user_id UUID NOT NULL,
  company VARCHAR(255) NOT NULL,
  position VARCHAR(255) NOT NULL,
  location VARCHAR(255),

  status VARCHAR(50) NOT NULL,
  source VARCHAR(50),

  salary_min INTEGER,
  salary_max INTEGER,

  applied_date DATE,
  deadline DATE,

  notes TEXT,

  created_at TIMESTAMP NOT NULL DEFAULT NOW(),
  updated_at TIMESTAMP NOT NULL DEFAULT NOW(),

  CONSTRAINT fk_job_applications_user
    FOREIGN KEY (user_id) REFERENCES users(id)
      ON DELETE CASCADE
);

CREATE INDEX idx_job_applications_user_id ON job_applications(user_id);
CREATE INDEX idx_job_applications_status ON job_applications(status);
CREATE INDEX idx_job_applications_company ON job_applications(company);

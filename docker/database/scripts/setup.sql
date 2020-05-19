

CREATE TABLE IF NOT EXISTS logs(
  id bigserial PRIMARY KEY,
  date TIMESTAMP NULL,
  ip VARCHAR(16) NULL,
  request VARCHAR(55) NULL,
  status INT NULL,
  user_agent VARCHAR(255) NULL
);
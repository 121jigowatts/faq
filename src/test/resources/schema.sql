CREATE TABLE IF NOT EXISTS seeds (
  id          SERIAL PRIMARY KEY,
  used_at     TIMESTAMP,
  created_at  TIMESTAMP,
  created_by  VARCHAR(20),
  updated_at  TIMESTAMP,
  updated_by  VARCHAR(20)
);
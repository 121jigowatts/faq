DROP TABLE seeds;
CREATE TABLE IF NOT EXISTS seeds (
  id          SERIAL PRIMARY KEY,
  used_at     TIMESTAMP,
  created_at  TIMESTAMP,
  created_by  VARCHAR(20),
  updated_at  TIMESTAMP,
  updated_by  VARCHAR(20)
);

INSERT INTO seeds (used_at, created_at, created_by, updated_at, updated_by) VALUES ('2021-02-03 12:34:56.789','2021-02-03 12:34:56.789','test','2021-02-03 12:34:56.789','test');
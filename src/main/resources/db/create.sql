SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS staff (
  id int PRIMARY KEY auto_increment,
  name VARCHAR,
  role VARCHAR,
  division int,
);
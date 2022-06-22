SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS staff (
  id int PRIMARY KEY auto_increment,
  name VARCHAR,
  role VARCHAR,
  responsibility VARCHAR,
  departmentId int,
);


CREATE TABLE IF NOT EXISTS departments (
  id int PRIMARY KEY auto_increment,
  name VARCHAR,
);
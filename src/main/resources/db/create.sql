CREATE DATABASE technologydivision;
\c technologydivision;
CREATE TABLE IF NOT EXISTS staff (id SERIAL PRIMARY KEY,name VARCHAR,role VARCHAR,responsibility VARCHAR,departmentId int);
CREATE TABLE IF NOT EXISTS departments (id SERIAL PRIMARY KEY ,name VARCHAR);
CREATE DATABASE technologydivision_test WITH TEMPLATE technologydivision;
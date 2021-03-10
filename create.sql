CREATE DATABASE companynews;
\c

CREATE TABLE users( id SERIAL PRIMARY KEY , name VARCHAR , position VARCHAR , role VARCHAR , department VARCHAR , departmentId INT);
CREATE TABLE news(id SERIAL PRIMARY KEY, title VARCHAR, content VARCHAR, author VARCHAR, departmentId INT);
CREATE TABLE departments(id SERIAL PRIMARY KEY, name VARCHAR, description VARCHAR, totalemployees INTEGER);

CREATE DATABASE companynews_test WITH TEMPLATE companynews;
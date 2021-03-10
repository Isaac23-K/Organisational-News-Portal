CREATE DATABASE companynews;
\c

CREATE TABLE users( id SERIAL PRIMARY KEY , username VARCHAR , position VARCHAR , role VARCHAR , idDepartment VARCHAR);
CREATE TABLE news(id SERIAL PRIMARY KEY, content VARCHAR, usernameid VARCHAR, idDepartment INT);
CREATE TABLE departments(id SERIAL PRIMARY KEY, name VARCHAR, description VARCHAR, totalemployees INTEGER);

CREATE DATABASE companynews_test WITH TEMPLATE companynews;
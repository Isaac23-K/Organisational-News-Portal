CREATE DATABASE company_news;
\c company_news;

CREATE TABLE users( id SERIAL PRIMARY KEY , username VARCHAR , position VARCHAR , role VARCHAR , department_id VARCHAR);
CREATE TABLE news(id SERIAL PRIMARY KEY, content VARCHAR, user_id INT, department_id INT);
CREATE TABLE departments(id SERIAL PRIMARY KEY, name VARCHAR, detail VARCHAR, employees INTEGER);

CREATE DATABASE company_news_test WITH TEMPLATE company_news;
\q

DROP TABLE IF EXISTS users;
CREATE TABLE users(id serial PRIMARY KEY, name VARCHAR(255), password VARCHAR(255), age integer, email VARCHAR(255));
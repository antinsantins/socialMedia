CREATE TABLE users (
    id serial PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    status VARCHAR(100) NOT NULL,
    role VARCHAR(50) NOT NULL
);
CREATE TABLE post (
    id serial,
    name VARCHAR(50) NOT NULL,
    text VARCHAR(50) NOT NULL,
    data VARCHAR(50) NOT NULL
)

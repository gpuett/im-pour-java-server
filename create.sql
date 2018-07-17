CREATE DATABASE pour_bar;
\c pour_bar;
CREATE TABLE bars(id SERIAL PRIMARY KEY, name VARCHAR, address VARCHAR, phone VARCHAR, deal VARCHAR, happyHour VARCHAR);
CREATE DATABASE pour_bar_test WITH TEMPLATE pour_bar;
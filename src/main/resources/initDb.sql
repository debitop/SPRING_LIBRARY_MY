DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS books;
DROP SEQUENCE IF EXISTS global_seq_stud;
DROP SEQUENCE IF EXISTS global_seq_book;

CREATE SEQUENCE global_seq_stud
  START 100;
CREATE SEQUENCE global_seq_book
  START 1000;

CREATE TABLE students (
  id          INTEGER PRIMARY KEY NOT NULL DEFAULT nextval('global_seq_stud'),
  name        VARCHAR(100)        not null,
  age         INTEGER             NOT NULL,
  admin       BOOLEAN                      DEFAULT FALSE,
  createdDate TIMESTAMP           not null
);

CREATE TABLE books (
  Id        INTEGER PRIMARY KEY NOT NULL  DEFAULT nextval('global_seq_book'),
  studentId INTEGER             not null,
  name      VARCHAR(100)        NOT NULL,
  pages     INTEGER             NOT NULL,
  author    VARCHAR(100)        NOT NULL,
  FOREIGN KEY (studentId) REFERENCES students (id) ON DELETE CASCADE
);
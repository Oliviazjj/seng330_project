DROP TABLE contact_specialties IF EXISTS;
DROP TABLE contacts IF EXISTS;
DROP TABLE specialties IF EXISTS;
DROP TABLE employeeShifts IF EXISTS;
DROP TABLE employEvents IF EXISTS;
DROP TABLE types IF EXISTS;
DROP TABLE employees IF EXISTS;
DROP TABLE inventory IF EXISTS;
DROP TABLE food IF EXISTS;
DROP TABLE users IF EXISTS;

CREATE TABLE food (
  id         INTEGER IDENTITY PRIMARY KEY,
  name       VARCHAR(30),
  expire_date DATE,
  type       VARCHAR(30),
  amount INTEGER NOT NULL
);

CREATE TABLE inventory (
  id         INTEGER IDENTITY PRIMARY KEY,
  name       VARCHAR(30),
  purchase_date DATE,
  type   VARCHAR(30) NOT NULL,
  amount INTEGER NOT NULL
);


CREATE TABLE contacts (
  id         INTEGER IDENTITY PRIMARY KEY,
  first_name VARCHAR(30),
  last_name  VARCHAR(30)
);
CREATE INDEX contacts_last_name ON contacts (last_name);

CREATE TABLE specialties (
  id   INTEGER IDENTITY PRIMARY KEY,
  name VARCHAR(80)
);
CREATE INDEX specialties_name ON specialties (name);

CREATE TABLE contact_specialties (
  contact_id       INTEGER NOT NULL,
  specialty_id INTEGER NOT NULL
);
ALTER TABLE contact_specialties ADD CONSTRAINT fk_contact_specialties_contacts FOREIGN KEY (contact_id) REFERENCES contacts (id);
ALTER TABLE contact_specialties ADD CONSTRAINT fk_contact_specialties_specialties FOREIGN KEY (specialty_id) REFERENCES specialties (id);

CREATE TABLE types (
  id   INTEGER IDENTITY PRIMARY KEY,
  name VARCHAR(80)
);
CREATE INDEX types_name ON types (name);

CREATE TABLE employees (
  id         INTEGER IDENTITY PRIMARY KEY,
  first_name VARCHAR(30),
  last_name  VARCHAR_IGNORECASE(30),
  address    VARCHAR(255),
  city       VARCHAR(80),
  telephone  VARCHAR(20)
);
CREATE INDEX employees_last_name ON employees (last_name);

CREATE TABLE employEvents (
  id         INTEGER IDENTITY PRIMARY KEY,
  name       VARCHAR(30),
  birth_date DATE,
  type_id    INTEGER NOT NULL,
  employee_id   INTEGER NOT NULL
);
ALTER TABLE employEvents ADD CONSTRAINT fk_employEvents_employees FOREIGN KEY (employee_id) REFERENCES employees (id);
ALTER TABLE employEvents ADD CONSTRAINT fk_employEvents_types FOREIGN KEY (type_id) REFERENCES types (id);
CREATE INDEX employEvents_name ON employEvents (name);

CREATE TABLE employeeShifts (
  id          INTEGER IDENTITY PRIMARY KEY,
  employEvent_id      INTEGER NOT NULL,
  employeeShift_date  DATE,
  description VARCHAR(255)
);
ALTER TABLE employeeShifts ADD CONSTRAINT fk_employeeShifts_employEvents FOREIGN KEY (employEvent_id) REFERENCES employEvents (id);
CREATE INDEX employeeShifts_employEvent_id ON employeeShifts (employEvent_id);



CREATE TABLE users (
  id          INTEGER IDENTITY PRIMARY KEY,
  username  VARCHAR(50),
  password  VARCHAR(50)
);

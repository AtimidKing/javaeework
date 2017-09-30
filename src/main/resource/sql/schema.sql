DROP TABLE Permission IF EXISTS;
DROP TABLE role_permission IF EXISTS;
DROP TABLE roles IF EXISTS;
DROP TABLE user_role IF EXISTS;
DROP TABLE users IF EXISTS;

-- CREATE TABLE permission
-- (
--   id   INT AUTO_INCREMENT
--     PRIMARY KEY,
--   name VARCHAR(50) NULL
-- );
-- CREATE TABLE role_permission
-- (
--   role_id       INT NOT NULL,
--   permission_id INT NOT NULL,
--   PRIMARY KEY (role_id, permission_id),
--   CONSTRAINT role_permission_roles_id_fk
--   FOREIGN KEY (role_id) REFERENCES roles (id),
--   CONSTRAINT role_permission_permission_id_fk
--   FOREIGN KEY (permission_id) REFERENCES permission (id)
-- );
-- CREATE INDEX role_permission_permission_id_fk
--   ON role_permission (permission_id);
--
-- CREATE TABLE roles
-- (
--   id   INT AUTO_INCREMENT
--     PRIMARY KEY,
--   name VARCHAR(50) NOT NULL,
--   CONSTRAINT roles_name_uindex
--   UNIQUE (name)
-- );
--
-- CREATE TABLE user_role
-- (
--   user_id INT NOT NULL,
--   role_id INT NOT NULL,
--   PRIMARY KEY (user_id, role_id),
--   CONSTRAINT user_role_users_id_fk
--   FOREIGN KEY (user_id) REFERENCES users (id),
--   CONSTRAINT user_role_roles_id_fk
--   FOREIGN KEY (role_id) REFERENCES roles (id)
-- );
-- CREATE INDEX user_role_roles_id_fk
--   ON user_role (role_id);

CREATE TABLE users
(
  id       INT AUTO_INCREMENT
    PRIMARY KEY,
  username VARCHAR(100) NOT NULL,
  password VARCHAR(250) NOT NULL,
  CONSTRAINT users_username_uindex
  UNIQUE (username)
);
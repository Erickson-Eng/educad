CREATE SEQUENCE IF NOT EXISTS user_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE "user"
(
    id            BIGINT NOT NULL,
    username      VARCHAR(255),
    password      VARCHAR(255),
    email         VARCHAR(255),
    cellphone     VARCHAR(255),
    created_date  date,
    modified_date date,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

ALTER TABLE "user"
    ADD CONSTRAINT uc_user_email UNIQUE (email);

ALTER TABLE "user"
    ADD CONSTRAINT uc_user_username UNIQUE (username);
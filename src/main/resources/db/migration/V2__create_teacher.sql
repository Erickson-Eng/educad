CREATE SEQUENCE IF NOT EXISTS profile_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE teach_discipline_mapping
(
    discipline_id BIGINT NOT NULL,
    teacher_id    BIGINT NOT NULL,
    CONSTRAINT pk_teach_discipline_mapping PRIMARY KEY (discipline_id, teacher_id)
);

CREATE TABLE teacher
(
    id         BIGINT NOT NULL,
    full_name  VARCHAR(255),
    birth_date date,
    cpf        VARCHAR(255),
    address_id BIGINT,
    value      VARCHAR(255),
    CONSTRAINT pk_teacher PRIMARY KEY (id)
);

ALTER TABLE teach_discipline_mapping
    ADD CONSTRAINT uc_teach_discipline_mapping_discipline UNIQUE (discipline_id);

ALTER TABLE teacher
    ADD CONSTRAINT FK_TEACHER_ON_ADDRESS FOREIGN KEY (address_id) REFERENCES address (id);

ALTER TABLE teach_discipline_mapping
    ADD CONSTRAINT fk_teadismap_on_discipline FOREIGN KEY (discipline_id) REFERENCES discipline (id);

ALTER TABLE teach_discipline_mapping
    ADD CONSTRAINT fk_teadismap_on_teacher FOREIGN KEY (teacher_id) REFERENCES teacher (id);
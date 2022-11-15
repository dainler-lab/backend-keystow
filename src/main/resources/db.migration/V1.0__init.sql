-- ALTER TABLE tb_user_roles
--     ADD CONSTRAINT FK_user_roles_to_user
--         FOREIGN KEY (user_id) REFERENCES tb_users;

CREATE TABLE tt_user
(
    id         UUID    NOT NULL,
    first_name VARCHAR NOT NULL,
    last_name  VARCHAR NOT NULL,
    email      VARCHAR NOT NULL,
    password   VARCHAR NOT NULL,
    enable     BOOLEAN NOT NULL,
    created_at DATE    NOT NULL,
    PRIMARY KEY (id)
);
ALTER TABLE tb_user_roles
    ADD CONSTRAINT FK_user_roles_to_user
        FOREIGN KEY (user_id) REFERENCES tb_users;
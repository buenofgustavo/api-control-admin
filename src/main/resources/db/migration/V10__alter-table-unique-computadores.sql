ALTER TABLE unique_computadores
    ADD user_atual VARCHAR(14),
    last_user VARCHAR(14),
    CONSTRAINT FK_colaboradores FOREIGN KEY (user_atual) REFERENCES colaboradores(cpf)

ALTER TABLE acessos
    ADD CONSTRAINT FK_acessos_colaboradores FOREIGN KEY (cpf) REFERENCES colaboradores(cpf);
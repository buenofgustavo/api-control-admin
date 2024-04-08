CREATE TABLE chat_solicitacoes_colaboradores(
        id INT PRIMARY KEY IDENTITY(1,1),
        message VARCHAR(255),
        id_vinculado INT,
        user_vinculado VARCHAR(255),
        datahora DATETIME
        CONSTRAINT FK_chat_solicitacoes_colaboradores FOREIGN KEY (id_vinculado) REFERENCES solicitacao_colaboradores(id)

)



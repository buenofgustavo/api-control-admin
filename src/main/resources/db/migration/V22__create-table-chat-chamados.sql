CREATE TABLE chat_chamados(
                              id INT PRIMARY KEY IDENTITY(1,1),
                              message VARCHAR(255),
                              numero_chamado INT,
                              user_vinculado VARCHAR(255),
                              arquivo VARCHAR(255),
                              nome_user VARCHAR(255),
                              datahora DATETIME
)
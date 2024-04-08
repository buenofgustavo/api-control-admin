CREATE TABLE chamados (
                          id INT IDENTITY(1,1) PRIMARY KEY,
                          usuario_vinculado VARCHAR(255),
                          titulo VARCHAR(255) NOT NULL,
                          descri VARCHAR(600) NOT NULL,
                          categoria VARCHAR(255) NOT NULL,
                          prioridade VARCHAR(255) NOT NULL,
                          status INT,
                          anexo VARBINARY(MAX),
                          excluido BIT NULL,
                          atualizado_por varchar(255),
);
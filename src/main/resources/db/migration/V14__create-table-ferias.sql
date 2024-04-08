CREATE TABLE ferias(

                       id INT IDENTITY(1,1) PRIMARY KEY,
                       colaborador VARCHAR(14),
                       datini DATETIME,
                       datfim DATETIME,
                       atualizado_por VARCHAR(255)
                       CONSTRAINT FK_ferias_colaboradores FOREIGN KEY (colaborador) REFERENCES colaboradores(cpf)

)
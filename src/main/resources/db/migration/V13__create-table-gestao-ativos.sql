CREATE TABLE gestao_ativos(
        id INT IDENTITY(1,1) PRIMARY KEY,
        nome VARCHAR(255),
        tipo VARCHAR(255),
        status VARCHAR(255),
        descricao VARCHAR(255),
        localizacao VARCHAR(255),
        atualizado_por VARCHAR(255)
)
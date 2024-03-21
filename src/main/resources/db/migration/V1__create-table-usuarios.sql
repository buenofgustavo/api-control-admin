CREATE TABLE usuarios (
                          id INT IDENTITY(1,1) PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          cargo VARCHAR(20) NOT NULL,
                          email VARCHAR(255) NOT NULL UNIQUE,
                          senha VARCHAR(255) NOT NULL
);

CREATE TABLE usuario_perfis (
                                usuario_id INT REFERENCES usuarios(id),
                                perfil VARCHAR(255) NOT NULL,
                                PRIMARY KEY (usuario_id, perfil)
);
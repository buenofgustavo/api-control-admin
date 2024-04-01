CREATE TABLE unique_computadores (

                              ID INT PRIMARY KEY IDENTITY(1,1),
                              nome_usuario VARCHAR(50),
                              nome_computador VARCHAR(50),
                              endereco_mac VARCHAR(17),
                              localizacao VARCHAR(100),
                              memoria_ram FLOAT,
                              capacidade_armazenamento FLOAT,
                              marca VARCHAR(50),
                              modelo VARCHAR(50),
                              processador VARCHAR(50),
                              sistema_operacional VARCHAR(50),
                              makro_instalado VARCHAR(50),
                              versao_makro VARCHAR(20),

);
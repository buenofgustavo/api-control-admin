CREATE TABLE registro_diario(

                                 id INT PRIMARY KEY IDENTITY(1,1),
                                 message VARCHAR(1000),
                                 titulo VARCHAR(255),
                                 incluido VARCHAR(255),
                                 datahora DATETIME DEFAULT GETDATE()

)
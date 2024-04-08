CREATE TABLE acessos (

                id INT IDENTITY(1,1) PRIMARY KEY,
                cpf VARCHAR(14),
                vr NVARCHAR(255),
                gmail NVARCHAR(255),
                frete_bras NVARCHAR(255),
                zoho NVARCHAR(255),
                sz_chat NVARCHAR(255),
                central_ti NVARCHAR(255),
                criado_por NVARCHAR(255),
                atualizado_por NVARCHAR(255),
);
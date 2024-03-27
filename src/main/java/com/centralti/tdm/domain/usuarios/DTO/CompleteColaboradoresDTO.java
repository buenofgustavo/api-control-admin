package com.centralti.tdm.domain.usuarios.DTO;

import jakarta.validation.constraints.NotNull;

public record CompleteColaboradoresDTO
    (

    @NotNull ColaboradoresDTO colaboradoresDTO,
    AcessosDTO acessosDTO,
    ComputadoresDTO computadoresDTO

    )
{
}

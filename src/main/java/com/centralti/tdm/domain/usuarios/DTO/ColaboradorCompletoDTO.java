package com.centralti.tdm.domain.usuarios.DTO;

import jakarta.validation.constraints.NotNull;

public record ColaboradorCompletoDTO
    (
    @NotNull ColaboradoresDTO colaboradoresDTO,
    AcessosDTO acessosDTO,
    ComputadoresDTO computadoresDTO
    ) {

}

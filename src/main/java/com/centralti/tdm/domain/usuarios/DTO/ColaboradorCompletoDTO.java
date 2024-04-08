package com.centralti.tdm.domain.usuarios.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

import java.util.Optional;

public record ColaboradorCompletoDTO
    (
            @NotNull DadosColaboradoresDTO colaboradoresDTO,
            ComputadoresDTO computadoresDTO,
            AcessosDTO acessosDTO

    ) {

}

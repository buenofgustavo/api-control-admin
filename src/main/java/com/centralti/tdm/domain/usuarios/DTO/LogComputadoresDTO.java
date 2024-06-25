package com.centralti.tdm.domain.usuarios.DTO;

import com.centralti.tdm.domain.usuarios.entidades.ChatSolicitacoesColaboradores;
import com.centralti.tdm.domain.usuarios.entidades.LogComputadores;

import java.time.LocalDateTime;

public record LogComputadoresDTO
        (
                String message,
                String userVinculado,
                String macVinculado,
                String computadorVinculado,
                LocalDateTime datahora,
                String nomeUser

        ) {

    public LogComputadoresDTO(LogComputadores logComputadores){
        this(logComputadores.getMessage(), logComputadores.getUserVinculado(),
                logComputadores.getMacVinculado(),
                logComputadores.getComputadorVinculado(), logComputadores.getDatahora(), logComputadores.getNomeUser()
        );
    }
}
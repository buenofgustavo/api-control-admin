package com.centralti.tdm.domain.usuarios.DTO;

import com.centralti.tdm.domain.usuarios.entidades.ChatSolicitacoesColaboradores;
import com.centralti.tdm.domain.usuarios.entidades.LogComputadores;
import com.centralti.tdm.domain.usuarios.entidades.RegistroDiario;

import java.time.LocalDateTime;

public record RegistroDiarioDTO
        (
                String titulo,
                String message,
                String incluido,
                LocalDateTime datahora

        ) {

    public RegistroDiarioDTO(RegistroDiario registroDiario){
        this(
                registroDiario.getTitulo(), registroDiario.getMessage(),
                registroDiario.getIncluido(), registroDiario.getDatahora()
        );
    }
}
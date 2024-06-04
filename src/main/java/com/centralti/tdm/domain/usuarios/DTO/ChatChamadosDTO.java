package com.centralti.tdm.domain.usuarios.DTO;

import com.centralti.tdm.domain.usuarios.entidades.ChatChamados;
import com.centralti.tdm.domain.usuarios.entidades.ChatSolicitacoesColaboradores;

import java.time.LocalDateTime;

public record ChatChamadosDTO
        (
                String id,
                String message,
                String numeroChamado,
                String userVinculado,
                String nomeUser,
                String arquivo,
                LocalDateTime datahora

        ) {

    public ChatChamadosDTO(ChatChamados chatChamados){
        this(
                chatChamados.getId(),
                chatChamados.getMessage(), chatChamados.getNumeroChamado(),
                chatChamados.getUserVinculado(), chatChamados.getNomeUser(),
                chatChamados.getArquivo(), chatChamados.getDatahora()
        );
    }
}


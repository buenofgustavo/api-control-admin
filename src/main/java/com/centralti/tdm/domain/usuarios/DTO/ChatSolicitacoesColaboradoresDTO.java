package com.centralti.tdm.domain.usuarios.DTO;

import com.centralti.tdm.domain.usuarios.entidades.ChatSolicitacoesColaboradores;

import java.time.LocalDateTime;

public record ChatSolicitacoesColaboradoresDTO
(
            String message,
            String usuario,
            String idVinculado,
            LocalDateTime datahora,
            String nomeUser

    ) {

        public ChatSolicitacoesColaboradoresDTO(ChatSolicitacoesColaboradores chatSolicitacoesColaboradores){
            this(chatSolicitacoesColaboradores.getMessage(), chatSolicitacoesColaboradores.getUserVinculado(),
                    chatSolicitacoesColaboradores.getIdVinculado(),
                    chatSolicitacoesColaboradores.getDatahora(), chatSolicitacoesColaboradores.getNomeUser()
            );
        }
    }


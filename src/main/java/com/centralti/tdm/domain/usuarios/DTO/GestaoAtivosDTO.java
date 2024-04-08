package com.centralti.tdm.domain.usuarios.DTO;

import com.centralti.tdm.domain.usuarios.entidades.GestaoAtivos;
import com.centralti.tdm.domain.usuarios.entidades.SolicitacaoAssociadaColaborador;

public record GestaoAtivosDTO (

        Integer id,

        String nome,

        String tipo,

        String status,

        String descricao,

        String localizacao,

        String atualizadoPor

) {
    public GestaoAtivosDTO(GestaoAtivos gestaoAtivos){
        this(
                gestaoAtivos.getId(), gestaoAtivos.getNome(),
                gestaoAtivos.getTipo(), gestaoAtivos.getStatus(), gestaoAtivos.getDescricao(),
                gestaoAtivos.getLocalizacao(), gestaoAtivos.getAtualizadoPor()
        );
    }
}

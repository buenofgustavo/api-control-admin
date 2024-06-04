package com.centralti.tdm.domain.usuarios.DTO;

import com.centralti.tdm.domain.usuarios.entidades.Arquivos;
import com.centralti.tdm.domain.usuarios.entidades.Chamados;

public record ChamadosDTO(

        String id,

                        String usuarioVinculado,
                        String titulo,
                        String descri,
                        String categoria,
                        String prioridade,
                        String status,
                        Boolean excluido,
                        String atualizado_por


) {



        public ChamadosDTO(Chamados chamados){

            this(
                    chamados.getId(),chamados.getUsuarioVinculado(), chamados.getTitulo(),
                    chamados.getDescri(), chamados.getCategoria(), chamados.getPrioridade(),
                    chamados.getStatus(), chamados.getExcluido(), chamados.getAtualizado_por()
            );
        }

}

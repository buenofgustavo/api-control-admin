package com.centralti.tdm.domain.usuarios.DTO;

import com.centralti.tdm.domain.usuarios.entidades.Chamados;

public record ChamadosDTO(

        String id,

                        String usuario_vinculado,
                        String titulo,
                        String descri,
                        String categoria,
                        String prioridade,
                        byte[] anexo,
                        Integer status,
                        Boolean excluido


) {

        public ChamadosDTO(Chamados chamados){
            this(
                    chamados.getId(),chamados.getUsuario_vinculado(), chamados.getTitulo(),
                    chamados.getDescri(), chamados.getCategoria(), chamados.getPrioridade(),
                    chamados.getAnexo(), chamados.getStatus(), chamados.getExcluido()
            );
        }


}

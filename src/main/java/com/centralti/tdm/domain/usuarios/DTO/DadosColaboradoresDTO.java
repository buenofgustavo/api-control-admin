package com.centralti.tdm.domain.usuarios.DTO;

import com.centralti.tdm.domain.usuarios.entidades.DadosColaboradores;

public record DadosColaboradoresDTO(

    String id,

    String usuario_solicitante,

    String nome,

    String numero,

    String cpf,

    String filial,

    String cargo,

    String departamento,

    String computador,

    String atualizado_por,

    Boolean termo,

    String regimeContratacao,

    Boolean status

) {

    public DadosColaboradoresDTO(DadosColaboradores colaboradores){
        this(
                colaboradores.getId(),colaboradores.getUsuario_solicitante(), colaboradores.getNome(),
                colaboradores.getNumero(), colaboradores.getCpf(), colaboradores.getFilial(),
                colaboradores.getCargo(), colaboradores.getDepartamento(), colaboradores.getComputador(),
                colaboradores.getAtualizado_por(), colaboradores.getTermo(), colaboradores.getRegimeContratacao(), colaboradores.getStatus()
        );
    }

}

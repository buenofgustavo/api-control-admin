package com.centralti.tdm.domain.usuarios.DTO;

import com.centralti.tdm.domain.usuarios.entidades.Chamados;
import com.centralti.tdm.domain.usuarios.entidades.Colaboradores;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public record ColaboradoresDTO(

    String id,

    String usuario_solicitante,

    String nome,

    String numero,

    String cpf,

    String filial,

    String cargo,

    String departamento,

    String computador,

    String atualizado_por

) {
    public ColaboradoresDTO(Colaboradores colaboradores){
        this(
                colaboradores.getId(),colaboradores.getUsuario_solicitante(), colaboradores.getNome(),
                colaboradores.getNumero(), colaboradores.getCpf(), colaboradores.getFilial(),
                colaboradores.getCargo(), colaboradores.getDepartamento(), colaboradores.getComputador(), colaboradores.getAtualizado_por()
        );
    }
}

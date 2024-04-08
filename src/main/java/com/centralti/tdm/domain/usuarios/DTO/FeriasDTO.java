package com.centralti.tdm.domain.usuarios.DTO;

import com.centralti.tdm.domain.usuarios.entidades.Ferias;
import com.centralti.tdm.domain.usuarios.entidades.GestaoAtivos;

import java.time.LocalDate;

public record FeriasDTO (

        Integer id,

        String colaborador,

        LocalDate datini,

        LocalDate datfim,

        String atualizadoPor

) {
    public FeriasDTO(Ferias ferias){
        this(
                ferias.getId(), ferias.getColaborador(),
                ferias.getDatini(), ferias.getDatfim(), ferias.getAtualizadoPor()
        );
    }
}


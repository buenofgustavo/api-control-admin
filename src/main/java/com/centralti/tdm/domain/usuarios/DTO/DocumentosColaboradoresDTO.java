package com.centralti.tdm.domain.usuarios.DTO;

import com.centralti.tdm.domain.usuarios.entidades.DocumentosColaboradores;


public record DocumentosColaboradoresDTO(

        String id,
        String nomeArquivo,
        String cpf

) {



    public DocumentosColaboradoresDTO(DocumentosColaboradores documentosColaboradores){

        this(
                documentosColaboradores.getId(),documentosColaboradores.getNomeArquivo(), documentosColaboradores.getCpf()
        );
    }

}

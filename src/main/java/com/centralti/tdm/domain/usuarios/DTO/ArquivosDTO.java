package com.centralti.tdm.domain.usuarios.DTO;

import com.centralti.tdm.domain.usuarios.entidades.Arquivos;
import com.centralti.tdm.domain.usuarios.entidades.Chamados;

public record ArquivosDTO(

        String id,
        String nomeArquivo,
        String numeroChamado

) {



    public ArquivosDTO(Arquivos arquivos){

        this(
                arquivos.getId(),arquivos.getNomeArquivo(), arquivos.getNumeroChamado()
        );
    }

}

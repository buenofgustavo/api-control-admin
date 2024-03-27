package com.centralti.tdm.domain.usuarios.DTO;

import com.centralti.tdm.domain.usuarios.entidades.Acessos;
import com.centralti.tdm.domain.usuarios.entidades.Computadores;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public record AcessosDTO (

    String id,

    String vr,

    String gmail,

    String freteBras,

    String zoho,

    String szChat,

    String centralTI

) {
    public AcessosDTO(Acessos acessos){
            this(
                    acessos.getId(), acessos.getVr(), acessos.getGmail(), acessos.getFreteBras(), acessos.getZoho(),
                    acessos.getSzChat(), acessos.getCentralTI()
            );
    }

}


package com.centralti.tdm.domain.usuarios.DTO;

import com.centralti.tdm.domain.usuarios.entidades.Departamentos;
import com.centralti.tdm.domain.usuarios.entidades.Ferias;
import com.centralti.tdm.domain.usuarios.entidades.Filiais;

public record FiliaisDTO(

        String id,
        String filiais

) {
    public FiliaisDTO(Filiais filiais){
        this(
                filiais.getId(), filiais.getFiliais()
        );
    }
}

package com.centralti.tdm.domain.usuarios.DTO;

import com.centralti.tdm.domain.usuarios.entidades.Departamentos;
import com.centralti.tdm.domain.usuarios.entidades.Ferias;

public record DepartamentosDTO(

        String id,
        String departamento

) {
    public DepartamentosDTO(Departamentos departamentos){
        this(
                departamentos.getId(), departamentos.getDepartamento()
        );
    }
}

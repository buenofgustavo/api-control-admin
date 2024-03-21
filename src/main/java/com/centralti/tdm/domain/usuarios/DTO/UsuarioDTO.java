package com.centralti.tdm.domain.usuarios.DTO;

import com.centralti.tdm.domain.usuarios.entidades.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import com.centralti.tdm.domain.usuarios.enums.perfis;
import java.util.Set;

public record UsuarioDTO(

        String id,

        @NotBlank    String name,
        @NotNull     String cargo,
        @NotNull     String email,
        @NotNull     String senha,
        @NotNull     Set<perfis> perfis
) {

    public UsuarioDTO(Usuario usuario){
        this(usuario.getId(),usuario.getName(), usuario.getCargo(),
                usuario.getEmail(),usuario.getSenha(), usuario.getPerfis());
    }

}

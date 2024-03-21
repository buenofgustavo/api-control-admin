package com.centralti.tdm.domain.usuarios.entidades;

import com.centralti.tdm.domain.usuarios.DTO.UsuarioDTO;
import com.centralti.tdm.domain.usuarios.enums.perfis;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.util.Set;


@Table(name = "usuarios")
@Entity(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "cargo")
    private String cargo;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @ElementCollection
    @CollectionTable(name = "usuario_perfis", joinColumns = @JoinColumn(name = "usuario_id"))
    @Enumerated(EnumType.STRING) // Especifique o tipo de enumeração
    @Column(name = "perfil", nullable = false)
    private Set<perfis> perfis;


    public Usuario(@Valid UsuarioDTO requestUsuario){
        this.name = requestUsuario.name();
        this.senha = requestUsuario.senha();
        this.email = requestUsuario.email();
        this.perfis= requestUsuario.perfis();
        this.cargo= requestUsuario.cargo();
    }


}

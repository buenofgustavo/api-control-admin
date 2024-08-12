package com.centralti.tdm.domain.usuarios.entidades;

import com.centralti.tdm.domain.usuarios.DTO.RegistroDiarioDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "registro_diario")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistroDiario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="message")
    private String message;

    @Column(name="titulo")
    private String titulo;

    @Column(name="incluido")
    private String incluido;

    @Column(name="datahora")
    private LocalDateTime datahora;

    public RegistroDiario(RegistroDiarioDTO registroDiarioDTO){
        this.message = registroDiarioDTO.message();
        this.titulo = registroDiarioDTO.titulo();
        this.incluido = registroDiarioDTO.incluido();
        this.datahora = registroDiarioDTO.datahora();
    }

}


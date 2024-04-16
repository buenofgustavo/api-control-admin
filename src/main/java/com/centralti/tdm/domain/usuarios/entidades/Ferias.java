package com.centralti.tdm.domain.usuarios.entidades;

import com.centralti.tdm.domain.usuarios.DTO.FeriasDTO;
import com.centralti.tdm.domain.usuarios.DTO.GestaoAtivosDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name = "ferias")
@Entity(name = "ferias")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Ferias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "colaborador")
    private String colaborador;

    @Column(name = "datini")
    private LocalDate datini;

    @Column(name = "datfim")
    private LocalDate datfim;

    @Column(name = "atualizado_por")
    private String atualizadoPor;

    public Ferias(@Valid FeriasDTO feriasDTO) {
        this.id = feriasDTO.id();
        this.colaborador = feriasDTO.colaborador();
        this.datini = feriasDTO.datini();
        this.datfim = feriasDTO.datfim();
        this.atualizadoPor = feriasDTO.atualizadoPor();
    }

}
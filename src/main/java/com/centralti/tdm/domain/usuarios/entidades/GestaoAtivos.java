package com.centralti.tdm.domain.usuarios.entidades;

import com.centralti.tdm.domain.usuarios.DTO.DadosColaboradoresDTO;
import com.centralti.tdm.domain.usuarios.DTO.GestaoAtivosDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Table(name = "gestao_ativos")
@Entity(name = "gestaoAtivos")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class GestaoAtivos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "status")
    private String status;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "localizacao")
    private String localizacao;

    @Column(name = "atualizado_por")
    private String atualizadoPor;

    public GestaoAtivos(@Valid GestaoAtivosDTO gestaoAtivosDTO) {
        this.id = gestaoAtivosDTO.id();
        this.nome = gestaoAtivosDTO.nome();
        this.tipo = gestaoAtivosDTO.tipo();
        this.status = gestaoAtivosDTO.status();
        this.descricao = gestaoAtivosDTO.descricao();
        this.localizacao = gestaoAtivosDTO.localizacao();
        this.atualizadoPor = gestaoAtivosDTO.atualizadoPor();
    }

}

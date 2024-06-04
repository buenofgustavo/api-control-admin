package com.centralti.tdm.domain.usuarios.entidades;

import com.centralti.tdm.domain.usuarios.DTO.AcessosDTO;
import com.centralti.tdm.domain.usuarios.DTO.ArquivosDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "arquivos_chamados")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Arquivos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "nome_arquivo")
    private String nomeArquivo;

    @Column(name = "numero_chamado")
    private String numeroChamado;


    public Arquivos(@Valid ArquivosDTO arquivosDTO) {
        this.id = arquivosDTO.id();
        this.nomeArquivo = arquivosDTO.nomeArquivo();
        this.numeroChamado = arquivosDTO.numeroChamado();
    }
}

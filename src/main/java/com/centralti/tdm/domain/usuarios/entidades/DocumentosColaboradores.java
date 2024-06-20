package com.centralti.tdm.domain.usuarios.entidades;

import com.centralti.tdm.domain.usuarios.DTO.ArquivosDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "documentos_colaboradores")
@Entity(name = "documentos_colaboradores")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DocumentosColaboradores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "nome_arquivo")
    private String nomeArquivo;

    @Column(name = "cpf")
    private String cpf;


    public DocumentosColaboradores(@Valid ArquivosDTO arquivosDTO) {
        this.id = arquivosDTO.id();
        this.nomeArquivo = arquivosDTO.nomeArquivo();
        this.cpf = arquivosDTO.numeroChamado();
    }
}

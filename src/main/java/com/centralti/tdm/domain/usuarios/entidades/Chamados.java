package com.centralti.tdm.domain.usuarios.entidades;


import com.centralti.tdm.domain.usuarios.DTO.ChamadosDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Table(name = "chamados")
@Entity(name = "chamados")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Chamados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "usuario_vinculado")
    private String usuario_vinculado;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descri")
    private String descri;

    @Column(name = "prioridade")
    private String prioridade;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "status")
    private Integer status;

    @Column(name = "excluido")
    private Boolean excluido;

    @Lob
    @Column(name = "anexo", columnDefinition="BLOB")
    private byte[] anexo; // Armazena o anexo como array de bytes

    public Chamados(@Valid ChamadosDTO chamadosDTO) {
        this.id = chamadosDTO.id();
        this.usuario_vinculado = chamadosDTO.usuario_vinculado();
        this.titulo = chamadosDTO.titulo();
        this.descri = chamadosDTO.descri();
        this.categoria = chamadosDTO.categoria();
        this.prioridade = chamadosDTO.prioridade();
        this.anexo = chamadosDTO.anexo();
    }

}

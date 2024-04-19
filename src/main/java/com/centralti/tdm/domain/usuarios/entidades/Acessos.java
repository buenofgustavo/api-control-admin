package com.centralti.tdm.domain.usuarios.entidades;

import com.centralti.tdm.domain.usuarios.DTO.AcessosDTO;
import com.centralti.tdm.domain.usuarios.DTO.ComputadoresDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Table(name = "acessos")
@Entity(name = "acessos")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Acessos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "vr")
    private String vr;

    @Column(name = "gmail")
    private String gmail;

    @Column(name = "frete_bras")
    private String freteBras;

    @Column(name = "zoho")
    private String zoho;

    @Column(name = "sz_chat")
    private String szChat;

    @Column(name = "central_ti")
    private String centralTi;

    @Column(name = "criado_por")
    private String criadoPor;

    @Column(name = "atualizado_por")
    private String atualizadoPor;



    public Acessos(@Valid AcessosDTO acessosDTO) {
        this.id = acessosDTO.id();
        this.cpf = acessosDTO.cpf();
        this.vr = acessosDTO.vr();
        this.gmail = acessosDTO.gmail();
        this.freteBras = acessosDTO.freteBras();
        this.zoho = acessosDTO.zoho();
        this.szChat = acessosDTO.szChat();
        this.centralTi = acessosDTO.centralTi();
        this.criadoPor = acessosDTO.criadoPor();
        this.atualizadoPor = acessosDTO.atualizadoPor();
    }
}

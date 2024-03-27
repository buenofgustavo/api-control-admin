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

    @Column(name = "vr")
    private String vr;

    @Column(name = "gmail")
    private String gmail;

    @Column(name = "freteBras")
    private String freteBras;

    @Column(name = "zoho")
    private String zoho;

    @Column(name = "szChat")
    private String szChat;

    @Column(name = "centralTI")
    private String centralTI;


    public Acessos(@Valid AcessosDTO acessosDTO) {
        this.id = acessosDTO.id();
        this.vr = acessosDTO.vr();
        this.gmail = acessosDTO.gmail();
        this.freteBras = acessosDTO.freteBras();
        this.zoho = acessosDTO.zoho();
        this.szChat = acessosDTO.szChat();
        this.centralTI = acessosDTO.centralTI();
    }
}

package com.centralti.tdm.domain.usuarios.entidades;

import com.centralti.tdm.domain.usuarios.DTO.ColaboradoresDTO;
import com.centralti.tdm.domain.usuarios.DTO.ComputadoresDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Table(name = "uniqueComputadores")
@Entity(name = "uniqueComputadores")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Computadores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "NomeUsuario")
    private String NomeUsuario;

    @Column(name = "NomeComputador")
    private String NomeComputador;

    @Column(name = "Localizacao")
    private String Localizacao;

    @Column(name = "MemoriaRAM")
    private String MemoriaRAM;

    @Column(name = "CapacidadeArmazenamento")
    private String CapacidadeArmazenamento;

    @Column(name = "marca")
    private String marca;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "processador")
    private String processador;

    @Column(name = "SistemaOperacional")
    private String SistemaOperacional;

    @Column(name = "makroInstalado")
    private String makroInstalado;

    @Column(name = "versaoMakro")
    private String versaoMakro;

    @Column(name = "EnderecoMAC")
    private String EnderecoMAC;

    public Computadores(@Valid ComputadoresDTO computadoresDTO) {
        this.id = computadoresDTO.id();
        this.NomeUsuario = computadoresDTO.NomeUsuario();
        this.NomeComputador = computadoresDTO.NomeComputador();
        this.Localizacao = computadoresDTO.Localizacao();
        this.MemoriaRAM = computadoresDTO.MemoriaRAM();
        this.CapacidadeArmazenamento = computadoresDTO.CapacidadeArmazenamento();
        this.marca = computadoresDTO.marca();
        this.modelo = computadoresDTO.modelo();
        this.processador = computadoresDTO.processador();
        this.SistemaOperacional = computadoresDTO.SistemaOperacional();
        this.makroInstalado = computadoresDTO.makroInstalado();
        this.versaoMakro = computadoresDTO.versaoMakro();
        this.EnderecoMAC = computadoresDTO.EnderecoMAC();
    }

}
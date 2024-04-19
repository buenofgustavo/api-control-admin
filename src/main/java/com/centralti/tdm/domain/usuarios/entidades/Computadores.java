package com.centralti.tdm.domain.usuarios.entidades;

import com.centralti.tdm.domain.usuarios.DTO.ComputadoresDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Table(name = "unique_computadores")
@Entity(name = "unique_computadores")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Computadores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "nome_usuario")
    private String nomeUsuario;

    @Column(name = "nome_computador")
    private String nomeComputador;

    @Column(name = "localizacao")
    private String localizacao;

    @Column(name = "memoria_ram")
    private String memoriaRam;

    @Column(name = "capacidade_armazenamento")
    private String capacidadeArmazenamento;

    @Column(name = "marca")
    private String marca;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "processador")
    private String processador;

    @Column(name = "sistema_operacional")
    private String sistemaOperacional;

    @Column(name = "makro_instalado")
    private String makroInstalado;

    @Column(name = "versao_makro")
    private String versaoMakro;

    @Column(name = "endereco_mac")
    private String enderecoMac;

    @Column(name = "user_atual")
    private String userAtual;

    @Column(name = "last_user")
    private String lastUser;

    @Column(name = "nome_user_atual")
    private String nomeUserAtual;

    @Column(name = "nome_last_user")
    private String nomeLastUser;

    public Computadores(@Valid ComputadoresDTO computadoresDTO) {
        this.id = computadoresDTO.id();
        this.nomeUsuario = computadoresDTO.nomeUsuario();
        this.nomeComputador = computadoresDTO.nomeComputador();
        this.localizacao = computadoresDTO.localizacao();
        this.memoriaRam = computadoresDTO.memoriaRam();
        this.capacidadeArmazenamento = computadoresDTO.capacidadeArmazenamento();
        this.marca = computadoresDTO.marca();
        this.modelo = computadoresDTO.modelo();
        this.processador = computadoresDTO.processador();
        this.sistemaOperacional = computadoresDTO.sistemaOperacional();
        this.makroInstalado = computadoresDTO.makroInstalado();
        this.versaoMakro = computadoresDTO.versaoMakro();
        this.enderecoMac = computadoresDTO.enderecoMac();
        this.userAtual = computadoresDTO.userAtual();
        this.lastUser = computadoresDTO.lastUser();
        this.nomeUserAtual = computadoresDTO.nomeUserAtual();
        this.nomeLastUser = computadoresDTO.nomeLastUser();
    }

}
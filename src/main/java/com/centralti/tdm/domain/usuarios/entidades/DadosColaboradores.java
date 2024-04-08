package com.centralti.tdm.domain.usuarios.entidades;


import com.centralti.tdm.domain.usuarios.DTO.DadosColaboradoresDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Table(name = "colaboradores")
@Entity(name = "colaboradores")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class DadosColaboradores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "usuario_solicitante")
    private String usuario_solicitante;

    @Column(name = "nome")
    private String nome;

    @Column(name = "numero")
    private String numero;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "filial")
    private String filial;

    @Column(name = "cargo")
    private String cargo;

    @Column(name = "departamento")
    private String departamento;

    @Column(name = "computador")
    private String computador;

    @Column(name = "atualizado_por")
    private String atualizado_por;

    @Column(name = "termo")
    private Boolean termo;

    @Column(name = "regime_contratacao")
    private String regimeContratacao;

    @Column(name = "status")
    private Boolean status;


    public DadosColaboradores(@Valid DadosColaboradoresDTO colaboradoresDTO) {
        this.id = colaboradoresDTO.id();
        this.nome = colaboradoresDTO.nome();
        this.numero = colaboradoresDTO.numero();
        this.cpf = colaboradoresDTO.cpf();
        this.filial = colaboradoresDTO.filial();
        this.cargo = colaboradoresDTO.cargo();
        this.departamento = colaboradoresDTO.departamento();
        this.computador = colaboradoresDTO.computador();
        this.usuario_solicitante = colaboradoresDTO.usuario_solicitante();
        this.atualizado_por = colaboradoresDTO.atualizado_por();
        this.termo = colaboradoresDTO.termo();
        this.regimeContratacao = colaboradoresDTO.regimeContratacao();
        this.status = colaboradoresDTO.status();
    }

}

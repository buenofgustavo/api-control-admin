package com.centralti.tdm.domain.usuarios.entidades;

import com.centralti.tdm.domain.usuarios.DTO.DadosColaboradoresDTO;
import com.centralti.tdm.domain.usuarios.DTO.SolicitacaoAssociadaColaboradorDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.time.LocalDateTime;


@Table(name = "solicitacao_colaboradores")
@Entity(name = "solicitacaoColaboradores")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class SolicitacaoAssociadaColaborador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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

    @Column(name = "atualizado_por")
    private String atualizado_por;

    @Column(name = "status")
    private String status;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "data_abertura")
    private LocalDateTime dataAbertura;


    public SolicitacaoAssociadaColaborador(@Valid SolicitacaoAssociadaColaboradorDTO solicitacaoAssociadaColaboradorDTO) {
        this.id = solicitacaoAssociadaColaboradorDTO.id();
        this.nome = solicitacaoAssociadaColaboradorDTO.nome();
        this.numero = solicitacaoAssociadaColaboradorDTO.numero();
        this.cpf = solicitacaoAssociadaColaboradorDTO.cpf();
        this.filial = solicitacaoAssociadaColaboradorDTO.filial();
        this.cargo = solicitacaoAssociadaColaboradorDTO.cargo();
        this.departamento = solicitacaoAssociadaColaboradorDTO.departamento();
        this.usuario_solicitante = solicitacaoAssociadaColaboradorDTO.usuario_solicitante();
        this.atualizado_por = solicitacaoAssociadaColaboradorDTO.atualizado_por();
        this.status = solicitacaoAssociadaColaboradorDTO.status();
        this.tipo = solicitacaoAssociadaColaboradorDTO.tipo();
        this.dataAbertura = solicitacaoAssociadaColaboradorDTO.dataAbertura();
    }

}

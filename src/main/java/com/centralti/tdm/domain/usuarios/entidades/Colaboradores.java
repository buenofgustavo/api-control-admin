package com.centralti.tdm.domain.usuarios.entidades;


import com.centralti.tdm.domain.usuarios.DTO.ChamadosDTO;
import com.centralti.tdm.domain.usuarios.DTO.ColaboradoresDTO;
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
public class Colaboradores {
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

    public Colaboradores(@Valid ColaboradoresDTO colaboradoresDTO) {
        this.id = colaboradoresDTO.id();
        this.nome = colaboradoresDTO.nome();
        this.numero = colaboradoresDTO.numero();
        this.cpf = colaboradoresDTO.cpf();
        this.filial = colaboradoresDTO.filial();
        this.cargo = colaboradoresDTO.cargo();
        this.departamento = colaboradoresDTO.departamento();
        this.computador = colaboradoresDTO.computador();
        this.atualizado_por = colaboradoresDTO.atualizado_por();
    }

}

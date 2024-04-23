package com.centralti.tdm.domain.usuarios.entidades;

import com.centralti.tdm.domain.usuarios.DTO.DadosColaboradoresDTO;
import com.centralti.tdm.domain.usuarios.DTO.DepartamentosDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Table(name = "departamentos")
@Entity(name = "departamentos")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Departamentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "departamentos")
    private String departamentos;

    public Departamentos(@Valid DepartamentosDTO departamentosDTO) {
        this.id = departamentosDTO.id();
        this.departamentos = departamentosDTO.departamento();
    }
}

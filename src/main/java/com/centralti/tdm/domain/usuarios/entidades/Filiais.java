package com.centralti.tdm.domain.usuarios.entidades;

import com.centralti.tdm.domain.usuarios.DTO.DepartamentosDTO;
import com.centralti.tdm.domain.usuarios.DTO.FiliaisDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;




import jakarta.persistence.*;
        import jakarta.validation.Valid;
import lombok.*;

@Table(name = "filiais")
@Entity(name = "filiais")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Filiais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "filiais")
    private String filiais;

    public Filiais(@Valid FiliaisDTO filiaisDTO) {
        this.id = filiaisDTO.id();
        this.filiais = filiaisDTO.filiais();
    }
}
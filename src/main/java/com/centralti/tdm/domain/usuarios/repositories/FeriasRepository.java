package com.centralti.tdm.domain.usuarios.repositories;

import com.centralti.tdm.domain.usuarios.entidades.Ferias;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeriasRepository extends JpaRepository<Ferias, String> {
    Ferias findByColaborador(String cpf);
}

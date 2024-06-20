package com.centralti.tdm.domain.usuarios.repositories;

import com.centralti.tdm.domain.usuarios.entidades.DocumentosColaboradores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentosColaboradoresRepository extends JpaRepository<DocumentosColaboradores, String> {
    DocumentosColaboradores findByCpf(String cpf);

}

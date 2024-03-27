package com.centralti.tdm.domain.usuarios.repositories;

import com.centralti.tdm.domain.usuarios.entidades.Colaboradores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColaboradoresRepository extends JpaRepository<Colaboradores, String> {
}

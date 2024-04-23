package com.centralti.tdm.domain.usuarios.repositories;

import com.centralti.tdm.domain.usuarios.entidades.DadosColaboradores;
import com.centralti.tdm.domain.usuarios.entidades.Departamentos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentosRepository extends JpaRepository<Departamentos, String> {
}

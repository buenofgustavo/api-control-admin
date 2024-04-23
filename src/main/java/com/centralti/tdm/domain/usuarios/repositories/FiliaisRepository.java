package com.centralti.tdm.domain.usuarios.repositories;

import com.centralti.tdm.domain.usuarios.entidades.Departamentos;
import com.centralti.tdm.domain.usuarios.entidades.Filiais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FiliaisRepository extends JpaRepository<Filiais, String> {
}
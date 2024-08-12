package com.centralti.tdm.domain.usuarios.repositories;

import com.centralti.tdm.domain.usuarios.entidades.LogComputadores;
import com.centralti.tdm.domain.usuarios.entidades.RegistroDiario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistroDiarioRepository extends JpaRepository<RegistroDiario, String> {
}
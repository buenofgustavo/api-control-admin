package com.centralti.tdm.domain.usuarios.repositories;

import com.centralti.tdm.domain.usuarios.entidades.Acessos;
import com.centralti.tdm.domain.usuarios.entidades.Computadores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputadoresRepository extends JpaRepository<Computadores, String> {

}
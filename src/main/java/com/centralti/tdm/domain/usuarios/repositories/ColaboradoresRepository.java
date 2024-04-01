package com.centralti.tdm.domain.usuarios.repositories;

import com.centralti.tdm.domain.usuarios.entidades.Chamados;
import com.centralti.tdm.domain.usuarios.entidades.Colaboradores;
import com.centralti.tdm.domain.usuarios.entidades.Computadores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColaboradoresRepository extends JpaRepository<Colaboradores, String> {

}

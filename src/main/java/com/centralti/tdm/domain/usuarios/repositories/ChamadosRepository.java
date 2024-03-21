package com.centralti.tdm.domain.usuarios.repositories;

import com.centralti.tdm.domain.usuarios.entidades.Chamados;
import com.centralti.tdm.domain.usuarios.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadosRepository extends JpaRepository<Chamados, String> {

}

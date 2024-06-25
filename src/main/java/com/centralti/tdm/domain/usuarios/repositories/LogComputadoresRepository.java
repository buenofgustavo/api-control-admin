package com.centralti.tdm.domain.usuarios.repositories;

import com.centralti.tdm.domain.usuarios.entidades.ChatSolicitacoesColaboradores;
import com.centralti.tdm.domain.usuarios.entidades.GestaoAtivos;
import com.centralti.tdm.domain.usuarios.entidades.LogComputadores;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogComputadoresRepository extends JpaRepository<LogComputadores, String> {
    List<LogComputadores> findByMacVinculado(String macVinculado);

}

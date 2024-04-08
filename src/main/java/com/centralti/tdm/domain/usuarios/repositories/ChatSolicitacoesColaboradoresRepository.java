package com.centralti.tdm.domain.usuarios.repositories;

import com.centralti.tdm.domain.usuarios.entidades.ChatSolicitacoesColaboradores;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatSolicitacoesColaboradoresRepository extends JpaRepository<ChatSolicitacoesColaboradores, String> {

    List<ChatSolicitacoesColaboradores> findByIdVinculado(String id_vinculado);

}
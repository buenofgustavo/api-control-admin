package com.centralti.tdm.domain.usuarios.repositories;

import com.centralti.tdm.domain.usuarios.entidades.ChatChamados;
import com.centralti.tdm.domain.usuarios.entidades.ChatSolicitacoesColaboradores;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatChamadosRepository  extends JpaRepository<ChatChamados, String> {

    List<ChatChamados> findChatChamadosByNumeroChamado(String id);
    ChatChamados findChatChamadosById(String id);

}

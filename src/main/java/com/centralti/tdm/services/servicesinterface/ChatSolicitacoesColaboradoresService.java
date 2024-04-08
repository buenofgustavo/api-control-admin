package com.centralti.tdm.services.servicesinterface;

import com.centralti.tdm.domain.usuarios.DTO.ChatSolicitacoesColaboradoresDTO;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ChatSolicitacoesColaboradoresService {

    List<ChatSolicitacoesColaboradoresDTO> findByIdVinculado(String idVinculado);
    void createChatMessage(ChatSolicitacoesColaboradoresDTO chatSolicitacoesColaboradoresDTO);

}

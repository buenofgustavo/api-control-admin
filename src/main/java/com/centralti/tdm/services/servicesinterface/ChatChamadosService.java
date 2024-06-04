package com.centralti.tdm.services.servicesinterface;


import com.centralti.tdm.domain.usuarios.DTO.ChatChamadosDTO;
import com.centralti.tdm.domain.usuarios.DTO.ChatSolicitacoesColaboradoresDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface ChatChamadosService {

    List<ChatChamadosDTO> findByNumeroChamado(String id);
    String createChatMessage(ChatChamadosDTO chatChamadosDTO);
    void fazerUploadImagem(List<MultipartFile> files, String idMensagem, String id);
}

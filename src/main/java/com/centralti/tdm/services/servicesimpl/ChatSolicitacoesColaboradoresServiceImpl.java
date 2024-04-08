package com.centralti.tdm.services.servicesimpl;

import com.centralti.tdm.domain.usuarios.DTO.ChatSolicitacoesColaboradoresDTO;
import com.centralti.tdm.domain.usuarios.entidades.ChatSolicitacoesColaboradores;
import com.centralti.tdm.domain.usuarios.repositories.ChatSolicitacoesColaboradoresRepository;
import com.centralti.tdm.services.servicesinterface.ChatSolicitacoesColaboradoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChatSolicitacoesColaboradoresServiceImpl implements ChatSolicitacoesColaboradoresService {

    @Autowired
    ChatSolicitacoesColaboradoresRepository chatSolicitacoesColaboradoresRepository;

    @Override
    public List<ChatSolicitacoesColaboradoresDTO> findByIdVinculado(String idVinculado) {
        List<ChatSolicitacoesColaboradores> chatMessages = chatSolicitacoesColaboradoresRepository.findByIdVinculado(idVinculado);
        return chatMessages.stream()
                .map(ChatSolicitacoesColaboradoresDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public void createChatMessage(ChatSolicitacoesColaboradoresDTO chatSolicitacoesColaboradoresDTO) {
        LocalDateTime dataHoraAtual = LocalDateTime.now();

        ChatSolicitacoesColaboradores chatMessage = new ChatSolicitacoesColaboradores(chatSolicitacoesColaboradoresDTO);
        String emailUsuario = SecurityContextHolder.getContext().getAuthentication().getName();

        chatMessage.setUserVinculado(emailUsuario);
        // Atribuir a data e hora atuais ao objeto ChatMessage
        chatMessage.setDatahora(dataHoraAtual);

        chatSolicitacoesColaboradoresRepository.save(chatMessage);

    }

}


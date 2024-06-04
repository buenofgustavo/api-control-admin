package com.centralti.tdm.services.servicesimpl;

import com.centralti.tdm.domain.usuarios.DTO.ChatChamadosDTO;
import com.centralti.tdm.domain.usuarios.DTO.ChatSolicitacoesColaboradoresDTO;
import com.centralti.tdm.domain.usuarios.entidades.Arquivos;
import com.centralti.tdm.domain.usuarios.entidades.ChatChamados;
import com.centralti.tdm.domain.usuarios.entidades.ChatSolicitacoesColaboradores;
import com.centralti.tdm.domain.usuarios.repositories.ChatChamadosRepository;
import com.centralti.tdm.services.servicesinterface.ChatChamadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChatChamadosServiceImpl implements ChatChamadosService {

    @Autowired
    ChatChamadosRepository chatChamadosRepository;

    @Override
    public List<ChatChamadosDTO> findByNumeroChamado(String id) {
        List<ChatChamados> chatMessages = chatChamadosRepository.findChatChamadosByNumeroChamado(id);
        return chatMessages.stream()
                .map(ChatChamadosDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public String createChatMessage(ChatChamadosDTO chatChamadosDTO) {
        LocalDateTime dataHoraAtual = LocalDateTime.now();

        ChatChamados chatMessage = new ChatChamados(chatChamadosDTO);
        String emailUsuario = SecurityContextHolder.getContext().getAuthentication().getName();

        chatMessage.setUserVinculado(emailUsuario);
        chatMessage.setDatahora(dataHoraAtual);

        chatChamadosRepository.save(chatMessage);

        return chatMessage.getId();
    }

    public void fazerUploadImagem(List<MultipartFile> files, String idMensagem, String idChamado){

        if (files.isEmpty()) {
            System.out.println("Nenhum arquivo foi enviado");
            return;
        }

        try {
            String uploadDir = "C:/Users/Suporte/Documents/FRONTEND_CONTROL_ADMIN/src/assets/img-uploads/files-chat-chamados/";
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    String fileName = file.getOriginalFilename();
                    String filePath = uploadDir + idChamado + "_" + idMensagem + "_" + fileName;
                    File dest = new File(filePath);
                    file.transferTo(dest);

                    ChatChamados chatMessages = chatChamadosRepository.findChatChamadosById(idMensagem);

                    chatMessages.setArquivo(fileName);

                    chatChamadosRepository.save(chatMessages);
                }
            }

            System.out.println("Arquivos salvos com sucesso no servidor e no banco de dados");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os arquivos no servidor: " + e.getMessage());
        }

    }


}

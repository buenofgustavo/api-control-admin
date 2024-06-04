package com.centralti.tdm.controllers;

import com.centralti.tdm.domain.usuarios.DTO.ChatChamadosDTO;
import com.centralti.tdm.domain.usuarios.DTO.ChatSolicitacoesColaboradoresDTO;
import com.centralti.tdm.errors.ErrorResponses;
import com.centralti.tdm.services.servicesinterface.ChatChamadosService;
import com.centralti.tdm.services.servicesinterface.ChatSolicitacoesColaboradoresService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/chat-chamados")
public class ChatChamadosController {

    @Autowired
    ChatChamadosService chatChamadosService;

    @PostMapping
    public ResponseEntity createMessage(@RequestBody ChatChamadosDTO chatChamadosDTO){
        try {
            String chamadoId = chatChamadosService.createChatMessage(chatChamadosDTO);
            return ResponseEntity.ok().body(Collections.singletonMap("id", chamadoId));
        }
        catch (RuntimeException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<List<ChatChamadosDTO>> getMessagesByChamados(@PathVariable String id) {
        try {
            List<ChatChamadosDTO> messages = chatChamadosService.findByNumeroChamado(id);
            return ResponseEntity.ok(messages);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/arquivos/{idChamado}")
    public ResponseEntity createArquivosChamados(@RequestParam("files") List<MultipartFile> files, @RequestParam("id") String id, @PathVariable String idChamado) {
        System.out.println("createArquivosMensagemChamados");
        try {
            chatChamadosService.fazerUploadImagem(files, id, idChamado);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }
    }

}

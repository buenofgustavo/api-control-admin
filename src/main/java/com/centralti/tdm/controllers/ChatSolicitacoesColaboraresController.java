package com.centralti.tdm.controllers;


import com.centralti.tdm.domain.usuarios.DTO.ChatSolicitacoesColaboradoresDTO;
import com.centralti.tdm.errors.ErrorResponses;
import com.centralti.tdm.services.servicesinterface.ChatSolicitacoesColaboradoresService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatSolicitacoesColaboraresController {

    @Autowired
    ChatSolicitacoesColaboradoresService chatSolicitacoesColaboradoresService;

    @PostMapping
    public ResponseEntity createMessage(@RequestBody ChatSolicitacoesColaboradoresDTO chatSolicitacoesColaboradoresDTO){
        try {
            chatSolicitacoesColaboradoresService.createChatMessage(chatSolicitacoesColaboradoresDTO);
            return ResponseEntity.ok().build();
        }
        catch (RuntimeException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
        return ResponseEntity.badRequest().body(errorResponses);
    }

    }

    @GetMapping("{id}")
    public ResponseEntity<List<ChatSolicitacoesColaboradoresDTO>> getMessagesByNfd(@PathVariable String id) {
        try {
            List<ChatSolicitacoesColaboradoresDTO> messages = chatSolicitacoesColaboradoresService.findByIdVinculado(id);
            return ResponseEntity.ok(messages);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
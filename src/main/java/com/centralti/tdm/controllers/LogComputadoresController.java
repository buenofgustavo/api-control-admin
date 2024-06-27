package com.centralti.tdm.controllers;

import com.centralti.tdm.domain.usuarios.DTO.ChatSolicitacoesColaboradoresDTO;
import com.centralti.tdm.domain.usuarios.DTO.LogComputadoresDTO;
import com.centralti.tdm.errors.ErrorResponses;
import com.centralti.tdm.services.servicesinterface.ChatSolicitacoesColaboradoresService;
import com.centralti.tdm.services.servicesinterface.LogComputadoresService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/log-computadores")
public class LogComputadoresController {

    @Autowired
    LogComputadoresService logComputadoresService;

    @PostMapping
    public ResponseEntity<?> createMessage(@RequestBody LogComputadoresDTO logComputadoresDTO) {
        try {
            logComputadoresService.createLogComputadores(logComputadoresDTO);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }

    }

    @GetMapping("{macVinculado}")
    public ResponseEntity<List<LogComputadoresDTO>> getMacVinculado(@PathVariable String macVinculado) {
        try {
            List<LogComputadoresDTO> messages = logComputadoresService.findByMacVinculado(macVinculado);
            return ResponseEntity.ok(messages);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/listar-all")
    public ResponseEntity<List<LogComputadoresDTO>> getAll() {
        try {
            List<LogComputadoresDTO> messages = logComputadoresService.findAll();
            return ResponseEntity.ok(messages);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
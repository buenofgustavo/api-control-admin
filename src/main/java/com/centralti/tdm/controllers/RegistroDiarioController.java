package com.centralti.tdm.controllers;

import com.centralti.tdm.domain.usuarios.DTO.LogComputadoresDTO;
import com.centralti.tdm.domain.usuarios.DTO.RegistroDiarioDTO;
import com.centralti.tdm.errors.ErrorResponses;
import com.centralti.tdm.services.servicesinterface.LogComputadoresService;
import com.centralti.tdm.services.servicesinterface.RegistroDiarioService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registro-diario")
public class RegistroDiarioController {

    @Autowired
    RegistroDiarioService registroDiarioService;

    @PostMapping
    public ResponseEntity<?> createdRegistro(@RequestBody RegistroDiarioDTO registroDiarioDTO) {
        try {
            registroDiarioService.createdRegistro(registroDiarioDTO);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }

    }

    @GetMapping("/listar-all")
    public ResponseEntity<List<RegistroDiarioDTO>> getAll() {
        try {
            List<RegistroDiarioDTO> messages = registroDiarioService.findAll();
            return ResponseEntity.ok(messages);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}

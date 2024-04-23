package com.centralti.tdm.controllers;

import com.centralti.tdm.domain.usuarios.DTO.FiliaisDTO;
import com.centralti.tdm.errors.ErrorResponses;
import com.centralti.tdm.services.servicesinterface.FiliaisService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/filiais")
public class FiliaisController {


    @Autowired
    FiliaisService filiaisService;

    @PostMapping()
    public ResponseEntity create(@RequestBody @Valid FiliaisDTO filiaisDTO) {
        try {
            filiaisService.create(filiaisDTO);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }
    }

    @GetMapping()
    public ResponseEntity findByTipo(){
        try {
            var dados = filiaisService.listar();
            return ResponseEntity.ok(dados);
        } catch (EntityNotFoundException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }
    }

}
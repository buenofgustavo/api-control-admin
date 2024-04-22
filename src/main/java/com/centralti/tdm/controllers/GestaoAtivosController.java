package com.centralti.tdm.controllers;

import com.centralti.tdm.domain.usuarios.DTO.DadosColaboradoresDTO;
import com.centralti.tdm.domain.usuarios.DTO.GestaoAtivosDTO;
import com.centralti.tdm.errors.ErrorResponses;
import com.centralti.tdm.services.servicesinterface.GestaoAtivosService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gestao-ativos")
public class GestaoAtivosController {

    @Autowired
    GestaoAtivosService gestaoAtivosService;

    @PostMapping
    public ResponseEntity createAtivos(@RequestBody @Valid GestaoAtivosDTO gestaoAtivosDTO) {
        try {
            gestaoAtivosService.createdAtivos(gestaoAtivosDTO);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }
    }

    @PutMapping
    public ResponseEntity editAtivos(@RequestBody @Valid GestaoAtivosDTO gestaoAtivosDTO) {
        try {
            gestaoAtivosService.editAtivos(gestaoAtivosDTO);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }
    }

    @GetMapping("listar-tipo/{tipo}")
    @Transactional
    public ResponseEntity findByTipo(@PathVariable String tipo){
        try {
            var dados = gestaoAtivosService.findByTipo(tipo);
            return ResponseEntity.ok(dados);
        } catch (EntityNotFoundException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }
    }

    @GetMapping("listar-all")
    public ResponseEntity findByTipo(){
        try {
            var dados = gestaoAtivosService.findByAll();
            return ResponseEntity.ok(dados);
        } catch (EntityNotFoundException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAtivos(@PathVariable String id) {
        try {
            gestaoAtivosService.deletarAtivos(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }
    }

}

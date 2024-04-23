package com.centralti.tdm.controllers;

import com.centralti.tdm.domain.usuarios.DTO.DadosColaboradoresDTO;
import com.centralti.tdm.domain.usuarios.DTO.DepartamentosDTO;
import com.centralti.tdm.errors.ErrorResponses;
import com.centralti.tdm.services.servicesinterface.DepartamentosService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departamentos")
public class DepartamentosController {
    @Autowired
    DepartamentosService departamentosService;

    @PostMapping()
    public ResponseEntity create(@RequestBody @Valid DepartamentosDTO departamentosDTO) {
        try {
            departamentosService.create(departamentosDTO);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }
    }

    @GetMapping()
    public ResponseEntity findByTipo(){
        try {
            var dados = departamentosService.listar();
            return ResponseEntity.ok(dados);
        } catch (EntityNotFoundException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }
    }

}

package com.centralti.tdm.controllers;

import com.centralti.tdm.domain.usuarios.DTO.AcessosDTO;
import com.centralti.tdm.domain.usuarios.DTO.ChamadosDTO;
import com.centralti.tdm.errors.ErrorResponses;
import com.centralti.tdm.services.servicesinterface.AcessosService;
import com.centralti.tdm.services.servicesinterface.ComputadoresService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/acessos")
public class AcessosController {

    @Autowired
    AcessosService acessosService;

    @PostMapping("cadastrar")
    public ResponseEntity createAcessos(@RequestBody @Valid AcessosDTO acessosDTO) {
        try {
            acessosService.createAcessos(acessosDTO);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }
    }

    @GetMapping("listar/{email}")
    public ResponseEntity findByAcessos(@PathVariable String email) {
        try {
            var acessos = acessosService.findByAcessos(email);
            return ResponseEntity.ok(acessos);
        } catch (EntityNotFoundException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }
    }

    @PutMapping("editar")
    public ResponseEntity editAcessos(@RequestBody AcessosDTO acessosDTO) {
        try {
            acessosService.editAcessos(acessosDTO);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }
    }

}
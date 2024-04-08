package com.centralti.tdm.controllers;

import com.centralti.tdm.errors.ErrorResponses;
import com.centralti.tdm.services.servicesinterface.ChamadosService;
import com.centralti.tdm.services.servicesinterface.ComputadoresService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/computadores")
public class ComputadoresController {

    @Autowired
    ComputadoresService computadoresService;

    @GetMapping("listar/{MAC}")
    public ResponseEntity findByComputadores(@PathVariable String MAC){
        try {
            var computador = computadoresService.findByComputadores(MAC);
            return ResponseEntity.ok(computador);
        } catch (EntityNotFoundException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }
    }

    @GetMapping("/listar")
    public ResponseEntity findComputadoresByStatus() {
        var allChamados = computadoresService.FindAllComputadores();
        return ResponseEntity.ok(allChamados);
    }

    @GetMapping("listar-com-usuario")
    public ResponseEntity FindAllComputadorComUsuario(){
        try {
            var computador = computadoresService.FindAllComputadorComUsuario();
            return ResponseEntity.ok(computador);
        } catch (EntityNotFoundException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }
    }

    @GetMapping("listar-sem-usuario")
    public ResponseEntity FindAllComputadorSemUsuario(){
        try {
            var computador = computadoresService.FindAllComputadorSemUsuario();
            return ResponseEntity.ok(computador);
        } catch (EntityNotFoundException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }
    }

}

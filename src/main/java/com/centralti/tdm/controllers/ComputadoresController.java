package com.centralti.tdm.controllers;

import com.centralti.tdm.errors.ErrorResponses;
import com.centralti.tdm.services.servicesinterface.ChamadosService;
import com.centralti.tdm.services.servicesinterface.ComputadoresService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/deletar/{MAC}")
    public ResponseEntity deleteAtivos(@PathVariable String MAC) {
        try {
            computadoresService.deletarComputador(MAC);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }
    }

    @PutMapping("/editar/{MAC}/{serial}")
    public ResponseEntity editSerial(@PathVariable String MAC, @PathVariable String serial){
        try {
            computadoresService.salvarSerial(MAC, serial);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }
    }

    @PutMapping("/editar-status/{MAC}/{status}")
    public ResponseEntity editStatus(@PathVariable String MAC, @PathVariable String status){
        try {
            computadoresService.salvarStatus(MAC, status);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }
    }

}

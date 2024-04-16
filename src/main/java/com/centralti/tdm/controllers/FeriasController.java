package com.centralti.tdm.controllers;


import com.centralti.tdm.domain.usuarios.DTO.FeriasDTO;
import com.centralti.tdm.domain.usuarios.DTO.GestaoAtivosDTO;
import com.centralti.tdm.errors.ErrorResponses;
import com.centralti.tdm.services.servicesinterface.FeriasService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ferias")
public class FeriasController {

    @Autowired
    FeriasService feriasService;

    @GetMapping("listar-all")
    public ResponseEntity findByAll(){
        try {
            var dados = feriasService.findByAll();
            return ResponseEntity.ok(dados);
        } catch (EntityNotFoundException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }
    }

    @GetMapping("listar-cpf/{cpf}")
    @Transactional
    public ResponseEntity findByCpf(@PathVariable String cpf){
        try {
            var dados = feriasService.findByCpf(cpf);
            return ResponseEntity.ok(dados);
        } catch (EntityNotFoundException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }
    }

    @PutMapping
    public ResponseEntity editFerias(@RequestBody @Valid FeriasDTO feriasDTO) {
        try {
            feriasService.editFerias(feriasDTO);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }
    }

}

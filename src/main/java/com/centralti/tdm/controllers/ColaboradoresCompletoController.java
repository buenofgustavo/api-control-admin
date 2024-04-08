package com.centralti.tdm.controllers;

import com.centralti.tdm.errors.ErrorResponses;
import com.centralti.tdm.services.servicesinterface.ColaboradorCompletoService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradoresCompletoController {

    @Autowired
    ColaboradorCompletoService colaboradorCompletoService;

    @GetMapping("listar-cpf/{cpf}")
    @Transactional
    public ResponseEntity findByAcessosCpf(@PathVariable String cpf) {
        try {
            var dados = colaboradorCompletoService.findByColaborador(cpf);
            return ResponseEntity.ok(dados);
        } catch (EntityNotFoundException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }
    }

    @GetMapping("listar")
    @Transactional
    public ResponseEntity findByAcessos() {
        try {
            var dados = colaboradorCompletoService.findAllColaboradores();
            return ResponseEntity.ok(dados);
        } catch (EntityNotFoundException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }
    }

}

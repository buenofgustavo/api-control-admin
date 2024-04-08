package com.centralti.tdm.controllers;

import com.centralti.tdm.domain.usuarios.DTO.ChamadosDTO;
import com.centralti.tdm.domain.usuarios.DTO.SolicitacaoAssociadaColaboradorDTO;
import com.centralti.tdm.domain.usuarios.entidades.SolicitacaoAssociadaColaborador;
import com.centralti.tdm.domain.usuarios.repositories.SolicitacaoAssociadaColaboradorRepository;
import com.centralti.tdm.errors.ErrorResponses;
import com.centralti.tdm.services.servicesinterface.SolicitacaoAssociadaColaboradorService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/solicitacao-associada-colaborador")
public class SolicitacaoAssociadaColaboradorController {

    @Autowired
    SolicitacaoAssociadaColaboradorService solicitacaoAssociadaColaboradorService;

    @GetMapping("/listar")
    public ResponseEntity findByAllSolicitacao() {
        try {
            var dados = solicitacaoAssociadaColaboradorService.FindAllSolicitacaoAssociada();
            return ResponseEntity.ok(dados);
        } catch (EntityNotFoundException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }
    }

    @GetMapping("/listar/status/{status}")
    @Transactional
    public ResponseEntity findBySolicitacaoStatus(@PathVariable String status) {
        try {
            var dados = solicitacaoAssociadaColaboradorService.findSolicitacaoAssociadaColaboradorByStatus(status);
            return ResponseEntity.ok(dados);
        } catch (EntityNotFoundException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }
    }

    @GetMapping("/listar/tipo/{tipo}")
    @Transactional
    public ResponseEntity findBySolicitacaoTipo(@PathVariable String tipo) {
        try {
            var dados = solicitacaoAssociadaColaboradorService.findSolicitacaoAssociadaColaboradorByTipo(tipo);
            return ResponseEntity.ok(dados);
        } catch (EntityNotFoundException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }
    }

    @PutMapping("/editar/{id}/{status}")
    @Transactional
    public ResponseEntity editSolicitacaoAssociadaColaborador(@PathVariable Integer id, @PathVariable String status) {
        try {
            solicitacaoAssociadaColaboradorService.editSolicitacaoAssociadaColaborador(id, status);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }
    }


}
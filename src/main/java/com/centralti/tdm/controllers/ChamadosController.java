package com.centralti.tdm.controllers;

import com.centralti.tdm.domain.usuarios.DTO.ChamadosDTO;
import com.centralti.tdm.domain.usuarios.DTO.UsuarioDTO;
import com.centralti.tdm.domain.usuarios.entidades.Chamados;
import com.centralti.tdm.domain.usuarios.repositories.UsuarioRepository;
import com.centralti.tdm.errors.ErrorResponses;
import com.centralti.tdm.services.servicesinterface.ChamadosInterface;
import com.centralti.tdm.services.servicesinterface.UsuarioInterface;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/chamados")
public class ChamadosController {

    @Autowired
    UsuarioRepository repository;

    @Autowired
    ChamadosInterface chamadosInterface;

    @PostMapping("cadastrar")
    public ResponseEntity createChamados(@RequestBody @Valid ChamadosDTO chamadosDTO) {
        try {
            chamadosInterface.createChamados(chamadosDTO);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }
    }

    @GetMapping("/listar")
    public ResponseEntity findAllChamados() {
        var allChamados = chamadosInterface.FindAllChamados();
        return ResponseEntity.ok(allChamados);
    }

    @GetMapping("/listar-excluidos")
    public ResponseEntity findAllChamadosExcluidos() {
        var allChamados = chamadosInterface.FindAllChamadosExcluidos();
        return ResponseEntity.ok(allChamados);
    }

    @GetMapping("listar/{id}")
    public ResponseEntity findByChamados(@PathVariable String id){
        try {
            var chamados = chamadosInterface.findByChamados(id);
            return ResponseEntity.ok(chamados);
        } catch (EntityNotFoundException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }
    }

    @GetMapping("/listar-status/{status}")
    public ResponseEntity findChamadosByStatus(@PathVariable Integer status) {
        var allChamados = chamadosInterface.findChamadosByStatus(status);
        return ResponseEntity.ok(allChamados);
    }

    @DeleteMapping("deletar/{id}")
    @Transactional
    public ResponseEntity deleteChamados(@PathVariable String id){
        try {
            chamadosInterface.deleteChamados(id);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }
    }
    @PutMapping("editar")
    @Transactional
    public ResponseEntity editChamados(@RequestBody @Valid ChamadosDTO chamadosDTO){

            try {
                chamadosInterface.editChamados(chamadosDTO);
                return ResponseEntity.ok().build();
            } catch (RuntimeException e) {
                ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
                return ResponseEntity.badRequest().body(errorResponses);
            }
    }

}
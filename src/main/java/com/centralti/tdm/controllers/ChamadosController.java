package com.centralti.tdm.controllers;

import com.centralti.tdm.domain.usuarios.DTO.ChamadosDTO;
import com.centralti.tdm.errors.ErrorResponses;
import com.centralti.tdm.services.servicesimpl.Upload;
import com.centralti.tdm.services.servicesinterface.ChamadosService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/chamados")
public class ChamadosController {

    @Autowired
    ChamadosService chamadosService;

    @Autowired
    Upload upload;

    @PostMapping()
    public ResponseEntity createChamados( @RequestBody ChamadosDTO chamadosDTO) {
            System.out.println("createChamados");
        try {
            String chamadoId = chamadosService.createChamados(chamadosDTO);
            return ResponseEntity.ok().body(Collections.singletonMap("id", chamadoId));
        } catch (RuntimeException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }
    }

    @PostMapping("/arquivos")
    public ResponseEntity createArquivosChamados(@RequestParam("files") List<MultipartFile> files, @RequestParam("id") String id) {
        System.out.println("createArquivosChamados");
        try {
            chamadosService.createArquivosChamados(files, id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }
    }

    @GetMapping()
    public ResponseEntity findAllChamados() {
        var allChamados = chamadosService.FindAllChamados();
        return ResponseEntity.ok(allChamados);
    }

    @GetMapping("/listar-arquivos/{id}")
    public ResponseEntity findAllArquivos(@PathVariable String id) {
        var allChamados = chamadosService.findAllArquivos(id);
        return ResponseEntity.ok(allChamados);
    }

    @GetMapping("/listar-usuario/{usuario}")
    public ResponseEntity findChamadosByUsuario(@PathVariable String usuario) {
        var allChamados = chamadosService.FindChamadosByUsuario(usuario);
        return ResponseEntity.ok(allChamados);
    }

    @GetMapping("listar/{id}")
    public ResponseEntity findByChamados(@PathVariable String id){
        try {
            var chamados = chamadosService.findByChamados(id);
            return ResponseEntity.ok(chamados);
        } catch (EntityNotFoundException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }
    }

    @GetMapping("/listar-status/{status}")
    public ResponseEntity findChamadosByStatus(@PathVariable String status) {
        var allChamados = chamadosService.findChamadosByStatus(status);
        return ResponseEntity.ok(allChamados);
    }

    @DeleteMapping("deletar/{id}")
    @Transactional
    public ResponseEntity deleteChamados(@PathVariable String id){
        try {
            chamadosService.deleteChamados(id);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }
    }
    @PutMapping("/editar/{id}/{status}")
    @Transactional
    public ResponseEntity editChamados(@PathVariable String id, @PathVariable String status){

            try {
                chamadosService.editChamados(id, status);
                return ResponseEntity.ok().build();
            } catch (RuntimeException e) {
                ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
                return ResponseEntity.badRequest().body(errorResponses);
            }
    }

}

package com.centralti.tdm.controllers;

import com.centralti.tdm.errors.ErrorResponses;
import com.centralti.tdm.services.servicesimpl.UploadDocumentosColaboradores;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/documentos-colaboradores")
public class DocumentosColaboradoresController {

    @Autowired
    UploadDocumentosColaboradores uploadDocumentosColaboradores;

    @PostMapping("/arquivos/{cpf}")
    public ResponseEntity createArquivosChamados(@RequestParam("files") List<MultipartFile> files, @PathVariable String cpf) {
        System.out.println("createArquivosMensagemChamados");
        try {
            uploadDocumentosColaboradores.fazerUploadImagem(files, cpf);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }
    }

    @GetMapping("listar/{cpf}")
    public ResponseEntity findByChamados(@PathVariable String cpf){
        try {
            var chamados = uploadDocumentosColaboradores.findDocuments(cpf);
            return ResponseEntity.ok(chamados);
        } catch (EntityNotFoundException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }
    }

}

package com.centralti.tdm.controllers;


import com.centralti.tdm.errors.ErrorResponses;
import com.centralti.tdm.services.servicesinterface.FeriasService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}

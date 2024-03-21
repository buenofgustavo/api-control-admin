package com.centralti.tdm.controllers;

import com.centralti.tdm.domain.usuarios.DTO.UsuarioDTO;
import com.centralti.tdm.domain.usuarios.entidades.Usuario;
import com.centralti.tdm.domain.usuarios.repositories.UsuarioRepository;
import com.centralti.tdm.errors.ErrorResponses;
import com.centralti.tdm.services.servicesinterface.UsuarioInterface;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioRepository repository;

    @Autowired
    UsuarioInterface usuarioInterface;

    @PostMapping("cadastrar")
    public ResponseEntity createUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO){
        try {
            usuarioInterface.createUsuario(usuarioDTO);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }
    }

    @DeleteMapping("deletar/{id}")
    public ResponseEntity<UsuarioDTO> deletePessoa(@PathVariable String id){
        try {
            usuarioInterface.deleteUsuario(id);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/listar")
    public ResponseEntity findAllUsuario(){
        var allUsuarios = usuarioInterface.findAllUsuario();
        return ResponseEntity.ok(allUsuarios);
    }

    @GetMapping("listar/{id}")
    public ResponseEntity findByUsuario(@PathVariable String id){
        try {
            var user = usuarioInterface.findByUsuario(id);
            return ResponseEntity.ok(user);
        } catch (EntityNotFoundException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }
    }


}

package com.centralti.tdm.controllers;


import com.centralti.tdm.domain.usuarios.DTO.AcessosDTO;
import com.centralti.tdm.domain.usuarios.DTO.DadosColaboradoresDTO;
import com.centralti.tdm.errors.ErrorResponses;
import com.centralti.tdm.services.servicesinterface.DadosColaboradoresService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dados-colaboradores")
public class DadosColaboradoresController {

    @Autowired
    DadosColaboradoresService dadosColaboradoresService;

    @PostMapping("cadastrar")
    public ResponseEntity createAcessos(@RequestBody @Valid DadosColaboradoresDTO dadosColaboradoresDTO) {
        try {
            dadosColaboradoresService.createdColaboradores(dadosColaboradoresDTO);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }
    }



    @PutMapping("vincular/{cpf}/{computador}")
    @Transactional
    public ResponseEntity vincularComputador(@PathVariable String cpf, @PathVariable String computador) {
        try {
            dadosColaboradoresService.vincularComputador(cpf, computador);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }
    }

    @PutMapping("desvincular/{cpf}")
    @Transactional
    public ResponseEntity desvincularComputador(@PathVariable String cpf) {
        try {
            dadosColaboradoresService.desvincularComputador(cpf);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }
    }

    @PutMapping("desligar/{cpf}")
    @Transactional
    public ResponseEntity desligarColaborador(@PathVariable String cpf) {
        try {
            dadosColaboradoresService.desligamentoColaborador(cpf);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }
    }

    @PutMapping("mudanca-de-cargo")
    @Transactional
    public ResponseEntity mudancaDeCargo(@RequestBody DadosColaboradoresDTO dadosColaboradoresDTO) {
        try {
            dadosColaboradoresService.mudancaDeCargo(dadosColaboradoresDTO);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }
    }

    @PutMapping("termo-assinado/{cpf}")
    @Transactional
    public ResponseEntity termoAssinado(@PathVariable String cpf) {
        try {
            dadosColaboradoresService.termoAssinado(cpf);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }
    }

    @GetMapping("listar/todos")
    public ResponseEntity findChamadosByStatus() {
        var AlldadosColaboradores = dadosColaboradoresService.FindAllDadosColaboradores();
        return ResponseEntity.ok(AlldadosColaboradores);
    }

    @GetMapping("listar/cpf/{cpf}")
    @Transactional
    public ResponseEntity findByAcessosCpf(@PathVariable String cpf) {
        try {
            var dados = dadosColaboradoresService.findByDadosColaboradoresCpf(cpf);
            return ResponseEntity.ok(dados);
        } catch (EntityNotFoundException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }
    }

    @GetMapping("/listar/ativos")
    public ResponseEntity FindAllColaboradoresAtivos() {
        var AlldadosColaboradores = dadosColaboradoresService.FindAllColaboradoresAtivos();
        return ResponseEntity.ok(AlldadosColaboradores);
    }

    @GetMapping("/listar/desligados")
    public ResponseEntity FindAllColaboradoresInativos() {
        var AlldadosColaboradores = dadosColaboradoresService.FindAllColaboradoresInativos();
        return ResponseEntity.ok(AlldadosColaboradores);
    }

    @GetMapping("/listar/termos-pendentes")
    public ResponseEntity FindAllColaboradoresTermoPendente() {
        var AlldadosColaboradores = dadosColaboradoresService.FindAllColaboradoresTermoPendente();
        return ResponseEntity.ok(AlldadosColaboradores);
    }

    @GetMapping("/listar/sem-computador")
    public ResponseEntity FindAllColaboradoresSemComputador() {
        var AlldadosColaboradores = dadosColaboradoresService.FindAllColaboradoresSemComputador();
        return ResponseEntity.ok(AlldadosColaboradores);
    }

    @GetMapping("listar/regime/{regime}")
    @Transactional
    public ResponseEntity FindAllColaboradoresRegimeContratacao(@PathVariable String regime) {
        try {
            var dados = dadosColaboradoresService.FindAllColaboradoresRegimeContratacao(regime);
            return ResponseEntity.ok(dados);
        } catch (EntityNotFoundException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }
    }

    @GetMapping("listar/filial/{filial}")
    @Transactional
    public ResponseEntity FindAllColaboradoresFilial(@PathVariable String filial) {
        try {
            var dados = dadosColaboradoresService.FindAllColaboradoresFilial(filial);
            return ResponseEntity.ok(dados);
        } catch (EntityNotFoundException e) {
            ErrorResponses errorResponses = new ErrorResponses(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponses);
        }
    }

}

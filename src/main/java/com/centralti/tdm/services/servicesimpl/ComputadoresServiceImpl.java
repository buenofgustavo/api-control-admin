package com.centralti.tdm.services.servicesimpl;

import com.centralti.tdm.domain.usuarios.DTO.ChamadosDTO;
import com.centralti.tdm.domain.usuarios.DTO.ComputadoresDTO;
import com.centralti.tdm.domain.usuarios.entidades.Chamados;
import com.centralti.tdm.domain.usuarios.entidades.Computadores;
import com.centralti.tdm.domain.usuarios.entidades.GestaoAtivos;
import com.centralti.tdm.domain.usuarios.repositories.ChamadosRepository;
import com.centralti.tdm.domain.usuarios.repositories.ComputadoresRepository;
import com.centralti.tdm.domain.usuarios.repositories.LogComputadoresRepository;
import com.centralti.tdm.services.servicesinterface.ChamadosService;
import com.centralti.tdm.services.servicesinterface.ComputadoresService;
import com.centralti.tdm.services.servicesinterface.LogComputadoresService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ComputadoresServiceImpl implements ComputadoresService {

    @Autowired
    ComputadoresRepository computadoresRepository;

    @Autowired
    LogComputadoresService logComputadoresService;

    @Override
    public List<ComputadoresDTO> FindAllComputadores() {
        List<Computadores> allComputadores = computadoresRepository.findAllBy();
        return allComputadores.stream()
                .map(ComputadoresDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public ComputadoresDTO findByComputadores(String MAC) {
        Computadores computador = computadoresRepository.findByEnderecoMac(MAC);
        return new ComputadoresDTO(computador);
    }

    @Override
    public List<ComputadoresDTO> FindAllComputadorComUsuario() {
        List<Computadores> allComputadores = computadoresRepository.findAllByUserAtualIsNotNull();
        return allComputadores.stream()
                .map(ComputadoresDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<ComputadoresDTO> FindAllComputadorSemUsuario() {
        List<Computadores> allComputadores = computadoresRepository.findAllByUserAtualIsNull();
        return allComputadores.stream()
                .map(ComputadoresDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public void deletarComputador(String MAC) {
            Computadores computador = computadoresRepository.findByEnderecoMac(MAC);
            if (computador != null) {
                computadoresRepository.delete(computador);

                String emailUsuario = SecurityContextHolder.getContext().getAuthentication().getName();
                String mensagem = "Computador deletado por " + emailUsuario + ", tendo como último usuário " + computador.getNomeLastUser();
                String tipo = "deletar";

                logComputadoresService.createLogAutomaticoComputadores(mensagem, computador.getEnderecoMac(), computador.getNomeComputador(), tipo);
            } else {
                throw new IllegalArgumentException("Computador não encontrado para o MAC: " + MAC);
            }
    }


    @Override
    public void salvarSerial(String MAC, String serial) {
        Computadores computador = computadoresRepository.findByEnderecoMac(MAC);
        if (computador != null) {
            String emailUsuario = SecurityContextHolder.getContext().getAuthentication().getName();

            computador.setSerial(serial);
            computador.setAtualizadoPor(emailUsuario);
            computadoresRepository.save(computador);

            String mensagem = "Serial " + serial + " salvo por " + emailUsuario;
            String tipo = "serial";
            logComputadoresService.createLogAutomaticoComputadores(mensagem, computador.getEnderecoMac(), computador.getNomeComputador(), tipo);
        } else {
            throw new IllegalArgumentException("Computador não encontrado para o MAC: " + MAC);
        }
    }

    @Override
    public void salvarStatus(String MAC, String status) {
        Computadores computador = computadoresRepository.findByEnderecoMac(MAC);
        if (computador != null) {
            String emailUsuario = SecurityContextHolder.getContext().getAuthentication().getName();

            computador.setStatus(status);
            computador.setAtualizadoPor(emailUsuario);
            computadoresRepository.save(computador);

            String mensagem = "Status " + status + " salvo por " + emailUsuario;
            String tipo = "status";
            logComputadoresService.createLogAutomaticoComputadores(mensagem, computador.getEnderecoMac(), computador.getNomeComputador(), tipo);
        } else {
            throw new IllegalArgumentException("Computador não encontrado para o MAC: " + MAC);
        }
    }

}

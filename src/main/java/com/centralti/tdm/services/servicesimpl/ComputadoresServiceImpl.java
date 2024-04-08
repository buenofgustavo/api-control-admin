package com.centralti.tdm.services.servicesimpl;

import com.centralti.tdm.domain.usuarios.DTO.ChamadosDTO;
import com.centralti.tdm.domain.usuarios.DTO.ComputadoresDTO;
import com.centralti.tdm.domain.usuarios.entidades.Chamados;
import com.centralti.tdm.domain.usuarios.entidades.Computadores;
import com.centralti.tdm.domain.usuarios.repositories.ChamadosRepository;
import com.centralti.tdm.domain.usuarios.repositories.ComputadoresRepository;
import com.centralti.tdm.services.servicesinterface.ChamadosService;
import com.centralti.tdm.services.servicesinterface.ComputadoresService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ComputadoresServiceImpl implements ComputadoresService {

    @Autowired
    ComputadoresRepository computadoresRepository;


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

}

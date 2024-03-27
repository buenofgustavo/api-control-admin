package com.centralti.tdm.services.servicesimpl;

import com.centralti.tdm.domain.usuarios.DTO.ChamadosDTO;
import com.centralti.tdm.domain.usuarios.entidades.Chamados;
import com.centralti.tdm.domain.usuarios.repositories.ChamadosRepository;
import com.centralti.tdm.services.servicesinterface.ChamadosService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChamadosServiceImpl implements ChamadosService {

    @Autowired
    ChamadosRepository chamadosRepository;

    @Override
    public void createChamados(ChamadosDTO chamadosDTO) {

        String emailUsuario = SecurityContextHolder.getContext().getAuthentication().getName();

        Chamados newChamados = new Chamados(chamadosDTO);
        newChamados.setStatus(0);
        newChamados.setAtualizado_por(emailUsuario);
        newChamados.setUsuario_vinculado(emailUsuario);
        newChamados.setExcluido(false);
        chamadosRepository.save(newChamados);
    }


    public void editChamados(ChamadosDTO chamadosDTO) {
        var id = chamadosDTO.id();
        var status = chamadosDTO.status();
        Optional<Chamados> optionalChamados = chamadosRepository.findById(id);
        if(optionalChamados.isPresent()){
            Chamados chamados = optionalChamados.get();
            String emailUsuario = SecurityContextHolder.getContext().getAuthentication().getName();
            chamados.setAtualizado_por(emailUsuario);
            chamados.setStatus(status);
        } else {
            throw new EntityNotFoundException();
        }
    }

    public List<ChamadosDTO> FindAllChamados() {
        List<Chamados> allChamados = chamadosRepository.findAllByExcluidoFalse();
        return allChamados.stream()
                .map(ChamadosDTO::new)
                .collect(Collectors.toList());
    }

    public List<ChamadosDTO> FindAllChamadosExcluidos() {
        List<Chamados> allChamados = chamadosRepository.findAllByExcluidoTrue();
        return allChamados.stream()
                .map(ChamadosDTO::new)
                .collect(Collectors.toList());
    }

    public ChamadosDTO findByChamados(String id) {
        Optional<Chamados> chamadosOptional = chamadosRepository.findById(id);
        Chamados chamados = chamadosOptional.orElseThrow(() -> new EntityNotFoundException("Colaborador não localizado"));
        return new ChamadosDTO(chamados);
    }

    public List<ChamadosDTO> findChamadosByStatus(Integer status) {
            List<Chamados> allChamados = chamadosRepository.findChamadosByStatus(status);
            return allChamados.stream()
                    .map(ChamadosDTO::new)
                    .collect(Collectors.toList());
    }

    public void deleteChamados(String id) {
        Optional<Chamados> optionalChamados = chamadosRepository.findById(id);
        if(optionalChamados.isPresent()){

            String emailUsuario = SecurityContextHolder.getContext().getAuthentication().getName();

            Chamados chamados = optionalChamados.get();

            chamados.setAtualizado_por(emailUsuario);
            chamados.setExcluido(true);
        } else {
            throw new EntityNotFoundException();
        }
    }

}

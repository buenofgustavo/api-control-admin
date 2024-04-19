package com.centralti.tdm.services.servicesimpl;

import com.centralti.tdm.domain.usuarios.DTO.AcessosDTO;
import com.centralti.tdm.domain.usuarios.DTO.ChamadosDTO;
import com.centralti.tdm.domain.usuarios.entidades.Acessos;
import com.centralti.tdm.domain.usuarios.entidades.Chamados;
import com.centralti.tdm.domain.usuarios.repositories.AcessosRepository;
import com.centralti.tdm.services.servicesinterface.AcessosService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AcessosServiceImpl implements AcessosService {

    @Autowired
    AcessosRepository acessosRepository;

    public AcessosDTO findByAcessos(String cpf){
        Optional<Acessos> acessosOptional = acessosRepository.findByCpf(cpf);
        Acessos acessos = acessosOptional.orElseThrow(() -> new EntityNotFoundException("Acessos não localizado"));
        return new AcessosDTO(acessos);
    }

    @Override
    public void createAcessos(AcessosDTO acessosDTO){

        String emailUsuario = SecurityContextHolder.getContext().getAuthentication().getName();

        Acessos newAcessos = new Acessos(acessosDTO);
        newAcessos.setCriadoPor(emailUsuario);
        acessosRepository.save(newAcessos);
    }

    @Override
    public void editAcessos(AcessosDTO acessosDTO){

        Optional<Acessos> optionalAcessos = acessosRepository.findByCpf(acessosDTO.cpf());
        if(optionalAcessos.isPresent()){
            Acessos acessos = optionalAcessos.get();

            acessos.setVr(acessosDTO.vr());
            acessos.setGmail(acessosDTO.gmail());
            acessos.setFreteBras(acessosDTO.freteBras());
            acessos.setZoho(acessosDTO.zoho());
            acessos.setSzChat(acessosDTO.szChat());
            acessos.setCentralTi(acessosDTO.centralTi());

            String emailUsuario = SecurityContextHolder.getContext().getAuthentication().getName();
            acessos.setAtualizadoPor(emailUsuario);

            acessosRepository.save(acessos);

        } else {
            throw new EntityNotFoundException();
        }
    }



}

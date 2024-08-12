package com.centralti.tdm.services.servicesinterface;

import com.centralti.tdm.domain.usuarios.DTO.LogComputadoresDTO;
import com.centralti.tdm.domain.usuarios.DTO.RegistroDiarioDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RegistroDiarioService {

    void createdRegistro(RegistroDiarioDTO registroDiarioDTO);
    List<RegistroDiarioDTO> findAll();

}
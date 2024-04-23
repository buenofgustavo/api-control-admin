package com.centralti.tdm.services.servicesinterface;

import com.centralti.tdm.domain.usuarios.DTO.FiliaisDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FiliaisService {
    void create(FiliaisDTO filiaisDTO);
    List<FiliaisDTO> listar();
}


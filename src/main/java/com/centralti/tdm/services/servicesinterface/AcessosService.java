package com.centralti.tdm.services.servicesinterface;

import com.centralti.tdm.domain.usuarios.DTO.AcessosDTO;
import com.centralti.tdm.domain.usuarios.DTO.ChamadosDTO;
import org.springframework.stereotype.Service;

@Service
public interface AcessosService {

    void editAcessos(AcessosDTO acessosDTO);
    void createAcessos(AcessosDTO acessosDTO);
    AcessosDTO findByAcessos(String email);

}

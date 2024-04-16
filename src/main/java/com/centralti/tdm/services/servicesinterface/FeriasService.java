package com.centralti.tdm.services.servicesinterface;

import com.centralti.tdm.domain.usuarios.DTO.FeriasDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FeriasService {

    void createdFerias(FeriasDTO feriasDTO);
    List<FeriasDTO> findByAll();
    FeriasDTO findByCpf(String cpf);
    void editFerias(FeriasDTO feriasDTO);

}

package com.centralti.tdm.services.servicesinterface;

import com.centralti.tdm.domain.usuarios.DTO.ColaboradorCompletoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ColaboradorCompletoService {
    ColaboradorCompletoDTO findByColaborador(String gmail);
    List<ColaboradorCompletoDTO> findAllColaboradores();
}

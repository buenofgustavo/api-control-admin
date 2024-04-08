package com.centralti.tdm.services.servicesinterface;

import com.centralti.tdm.domain.usuarios.DTO.ComputadoresDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ComputadoresService {

    List<ComputadoresDTO> FindAllComputadores();
    ComputadoresDTO findByComputadores(String MAC);
    List<ComputadoresDTO> FindAllComputadorComUsuario();
    List<ComputadoresDTO> FindAllComputadorSemUsuario();

}

package com.centralti.tdm.services.servicesinterface;

import com.centralti.tdm.domain.usuarios.DTO.GestaoAtivosDTO;
import com.centralti.tdm.domain.usuarios.entidades.GestaoAtivos;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GestaoAtivosService {
    void createdAtivos(GestaoAtivosDTO gestaoAtivosDTO);
    List<GestaoAtivosDTO> findByAll();
    List<GestaoAtivosDTO> findByTipo(String tipo);
    void editAtivos(GestaoAtivosDTO gestaoAtivosDTO);
    void deletarAtivos(String id);
}

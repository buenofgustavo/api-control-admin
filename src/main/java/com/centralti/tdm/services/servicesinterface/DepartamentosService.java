package com.centralti.tdm.services.servicesinterface;

import com.centralti.tdm.domain.usuarios.DTO.DepartamentosDTO;
import com.centralti.tdm.domain.usuarios.entidades.Departamentos;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartamentosService {
    void create(DepartamentosDTO departamentosDTO);
    List<DepartamentosDTO> listar();
}

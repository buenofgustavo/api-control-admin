package com.centralti.tdm.services.servicesinterface;

import com.centralti.tdm.domain.usuarios.DTO.ChamadosDTO;
import com.centralti.tdm.domain.usuarios.DTO.UsuarioDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChamadosInterface {

    void createChamados(ChamadosDTO chamadosDTO);
    void editChamados(String id, Number status);
    List<ChamadosDTO> FindAllChamados();
    ChamadosDTO findByChamados(String id);
    void deleteChamados(String id);



}

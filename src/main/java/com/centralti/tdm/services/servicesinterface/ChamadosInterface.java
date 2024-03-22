package com.centralti.tdm.services.servicesinterface;

import com.centralti.tdm.domain.usuarios.DTO.ChamadosDTO;
import com.centralti.tdm.domain.usuarios.DTO.UsuarioDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChamadosInterface {

    void createChamados(ChamadosDTO chamadosDTO);
    void editChamados(ChamadosDTO chamadosDTO);
    List<ChamadosDTO> FindAllChamados();
    ChamadosDTO findByChamados(String id);
    void deleteChamados(String id);
    List<ChamadosDTO> findChamadosByStatus(Integer status);
    List<ChamadosDTO> FindAllChamadosExcluidos();

}

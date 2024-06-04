package com.centralti.tdm.services.servicesinterface;

import com.centralti.tdm.domain.usuarios.DTO.ArquivosDTO;
import com.centralti.tdm.domain.usuarios.DTO.ChamadosDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface ChamadosService {

    String createChamados(ChamadosDTO chamadosDTO);
    void editChamados(String id, String status);
    List<ChamadosDTO> FindAllChamados();
    List<ArquivosDTO> findAllArquivos(String id);
    ChamadosDTO findByChamados(String id);
    void deleteChamados(String id);
    List<ChamadosDTO> findChamadosByStatus(String status);
    List<ChamadosDTO> FindChamadosByUsuario(String usuario);
    void createArquivosChamados(List<MultipartFile> files, String id);

}

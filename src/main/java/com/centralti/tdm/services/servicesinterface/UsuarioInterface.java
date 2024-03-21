package com.centralti.tdm.services.servicesinterface;

import com.centralti.tdm.domain.usuarios.DTO.UsuarioDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsuarioInterface {

    void createUsuario(UsuarioDTO pessoaDTO);

    List<UsuarioDTO> findAllUsuario();

    UsuarioDTO findByUsuario(String id);

    void deleteUsuario(String id);

}

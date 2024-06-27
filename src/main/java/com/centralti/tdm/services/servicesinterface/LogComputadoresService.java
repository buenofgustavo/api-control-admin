package com.centralti.tdm.services.servicesinterface;

import com.centralti.tdm.domain.usuarios.DTO.ChatSolicitacoesColaboradoresDTO;
import com.centralti.tdm.domain.usuarios.DTO.LogComputadoresDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LogComputadoresService {

        List<LogComputadoresDTO> findByMacVinculado(String macVinculado);
        void createLogComputadores(LogComputadoresDTO logComputadoresDTO);
        void createLogAutomaticoComputadores(String mensagem, String mac, String nome_computador, String tipo);
        List<LogComputadoresDTO> findAll();
}

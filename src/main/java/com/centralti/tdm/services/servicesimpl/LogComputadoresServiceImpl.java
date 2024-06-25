package com.centralti.tdm.services.servicesimpl;

import com.centralti.tdm.domain.usuarios.DTO.ChatSolicitacoesColaboradoresDTO;
import com.centralti.tdm.domain.usuarios.DTO.LogComputadoresDTO;
import com.centralti.tdm.domain.usuarios.entidades.ChatSolicitacoesColaboradores;
import com.centralti.tdm.domain.usuarios.entidades.LogComputadores;
import com.centralti.tdm.domain.usuarios.repositories.GestaoAtivosRepository;
import com.centralti.tdm.domain.usuarios.repositories.LogComputadoresRepository;
import com.centralti.tdm.services.servicesinterface.LogComputadoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LogComputadoresServiceImpl implements LogComputadoresService {

    @Autowired
    LogComputadoresRepository logComputadoresRepository;

    @Override
    public List<LogComputadoresDTO> findByMacVinculado(String macVinculado) {
        List<LogComputadores> chatMessages = logComputadoresRepository.findByMacVinculado(macVinculado);
        return chatMessages.stream()
                .map(LogComputadoresDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public void createLogComputadores(LogComputadoresDTO logComputadoresDTO) {

        LocalDateTime dataHoraAtual = LocalDateTime.now();

        LogComputadores chatMessage = new LogComputadores(logComputadoresDTO);
        String emailUsuario = SecurityContextHolder.getContext().getAuthentication().getName();

        chatMessage.setUserVinculado(emailUsuario);
        chatMessage.setDatahora(dataHoraAtual);

        logComputadoresRepository.save(chatMessage);
    }

    @Override
    public void createLogAutomaticoComputadores(String mensagem, String mac, String nome_computador) {
        String emailUsuario = SecurityContextHolder.getContext().getAuthentication().getName();

        LogComputadores log = new LogComputadores();
        log.setMessage(mensagem);
        log.setMacVinculado(mac);
        log.setComputadorVinculado(nome_computador);
        log.setUserVinculado("Log automático");
        log.setNomeUser("Log@ControlAdmin");
        log.setDatahora(LocalDateTime.now());

        logComputadoresRepository.save(log);
    }

}

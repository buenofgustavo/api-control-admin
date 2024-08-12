package com.centralti.tdm.services.servicesimpl;

import com.centralti.tdm.domain.usuarios.DTO.LogComputadoresDTO;
import com.centralti.tdm.domain.usuarios.DTO.RegistroDiarioDTO;
import com.centralti.tdm.domain.usuarios.entidades.LogComputadores;
import com.centralti.tdm.domain.usuarios.entidades.RegistroDiario;
import com.centralti.tdm.domain.usuarios.repositories.RegistroDiarioRepository;
import com.centralti.tdm.services.servicesinterface.RegistroDiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistroDiarioServiceImpl implements RegistroDiarioService {

    @Autowired
    RegistroDiarioRepository registroDiarioRepository;

    @Override
    public void createdRegistro(RegistroDiarioDTO registroDiarioDTO) {
        LocalDateTime dataHoraAtual = LocalDateTime.now();

        RegistroDiario newRegistro = new RegistroDiario(registroDiarioDTO);
        String emailUsuario = SecurityContextHolder.getContext().getAuthentication().getName();

        newRegistro.setIncluido(emailUsuario);
        newRegistro.setDatahora(dataHoraAtual);

        registroDiarioRepository.save(newRegistro);
    }

    @Override
    public List<RegistroDiarioDTO> findAll() {
        List<RegistroDiario> chatMessages = registroDiarioRepository.findAll();
        return chatMessages.stream()
                .map(RegistroDiarioDTO::new)
                .collect(Collectors.toList());
    }
}

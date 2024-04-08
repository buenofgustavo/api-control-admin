package com.centralti.tdm.services.servicesimpl;

import com.centralti.tdm.domain.usuarios.DTO.FeriasDTO;
import com.centralti.tdm.domain.usuarios.DTO.GestaoAtivosDTO;
import com.centralti.tdm.domain.usuarios.entidades.Ferias;
import com.centralti.tdm.domain.usuarios.entidades.GestaoAtivos;
import com.centralti.tdm.domain.usuarios.repositories.FeriasRepository;
import com.centralti.tdm.services.servicesinterface.FeriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeriasServiceImpl implements FeriasService {

    @Autowired
    FeriasRepository feriasRepository;

    @Override
    public void createdFerias(FeriasDTO feriasDTO) {
        Ferias ferias = new Ferias(feriasDTO);

        String emailUsuario = SecurityContextHolder.getContext().getAuthentication().getName();
        ferias.setAtualizadoPor(emailUsuario);

        feriasRepository.save(ferias);
    }

    @Override
    public List<FeriasDTO> findByAll() {
        LocalDate dataAtual = LocalDate.now();

        List<Ferias> allAtivos = feriasRepository.findAll();
        return allAtivos.stream()
                .filter(ferias -> dataAtual.isAfter(ferias.getDatini()) && dataAtual.isBefore(ferias.getDatfim().plusDays(1)))
                .map(FeriasDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public FeriasDTO findByCpf(String cpf) {
        return null;
    }
}

package com.centralti.tdm.services.servicesimpl;

import com.centralti.tdm.domain.usuarios.DTO.ChamadosDTO;
import com.centralti.tdm.domain.usuarios.DTO.FeriasDTO;
import com.centralti.tdm.domain.usuarios.DTO.GestaoAtivosDTO;
import com.centralti.tdm.domain.usuarios.DTO.SolicitacaoAssociadaColaboradorDTO;
import com.centralti.tdm.domain.usuarios.entidades.Chamados;
import com.centralti.tdm.domain.usuarios.entidades.Ferias;
import com.centralti.tdm.domain.usuarios.entidades.GestaoAtivos;
import com.centralti.tdm.domain.usuarios.entidades.SolicitacaoAssociadaColaborador;
import com.centralti.tdm.domain.usuarios.repositories.FeriasRepository;
import com.centralti.tdm.services.servicesinterface.FeriasService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
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
                .filter(ferias -> {
                    LocalDate datini = ferias.getDatini();
                    LocalDate datfim = ferias.getDatfim();

                    // Verificar se datini e datfim não são nulos
                    return datini != null && datfim != null &&
                            // Verificar se a data atual está após datini
                            dataAtual.isAfter(datini) &&
                            // Verificar se a data atual está antes ou igual a datfim
                            (dataAtual.isBefore(datfim.plusDays(1)) || dataAtual.isEqual(datfim.plusDays(1)));
                })
                .map(FeriasDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public FeriasDTO findByCpf(String cpf) {
        Ferias ferias = feriasRepository.findByColaborador(cpf);
        if (ferias != null) {
            return new FeriasDTO(ferias);
        } else {
            return null; // ou lançar uma exceção ou manipular de outra forma, conforme necessário
        }
    }

    @Override
    public void editFerias(FeriasDTO feriasDTO) {
        Ferias ferias = feriasRepository.findByColaborador(feriasDTO.colaborador());

        String emailUsuario = SecurityContextHolder.getContext().getAuthentication().getName();
        ferias.setAtualizadoPor(emailUsuario);
        ferias.setDatini(feriasDTO.datini());
        ferias.setDatfim(feriasDTO.datfim());

        feriasRepository.save(ferias);
    }
}


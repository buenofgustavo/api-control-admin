package com.centralti.tdm.services.servicesimpl;

import com.centralti.tdm.domain.usuarios.DTO.DadosColaboradoresDTO;
import com.centralti.tdm.domain.usuarios.DTO.SolicitacaoAssociadaColaboradorDTO;
import com.centralti.tdm.domain.usuarios.entidades.DadosColaboradores;
import com.centralti.tdm.domain.usuarios.entidades.SolicitacaoAssociadaColaborador;
import com.centralti.tdm.domain.usuarios.repositories.SolicitacaoAssociadaColaboradorRepository;
import com.centralti.tdm.services.servicesinterface.SolicitacaoAssociadaColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SolicitacaoAssociadaColaboradorServiceImpl implements SolicitacaoAssociadaColaboradorService {

    @Autowired
    SolicitacaoAssociadaColaboradorRepository solicitacaoAssociadaColaboradorRepository;

    @Override
    public void createdSolicitacaoAssociadaColaborador(SolicitacaoAssociadaColaboradorDTO solicitacaoAssociadaColaboradorDTO) {
        String emailUsuario = SecurityContextHolder.getContext().getAuthentication().getName();

        SolicitacaoAssociadaColaborador newSolicitacaoAssociadaColaborador = new SolicitacaoAssociadaColaborador(solicitacaoAssociadaColaboradorDTO);
        newSolicitacaoAssociadaColaborador.setUsuario_solicitante(emailUsuario);
        newSolicitacaoAssociadaColaborador.setDataAbertura(LocalDateTime.now());
        solicitacaoAssociadaColaboradorRepository.save(newSolicitacaoAssociadaColaborador);
    }

    @Override
    public List<SolicitacaoAssociadaColaboradorDTO> findSolicitacaoAssociadaColaboradorByStatus(String status) {
        List<SolicitacaoAssociadaColaborador> allSolicitacoes = solicitacaoAssociadaColaboradorRepository.findSolicitacaoAssociadaColaboradorByStatusIs(status);
        return allSolicitacoes.stream()
                .map(SolicitacaoAssociadaColaboradorDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<SolicitacaoAssociadaColaboradorDTO> findSolicitacaoAssociadaColaboradorByTipo(String tipo) {
        List<SolicitacaoAssociadaColaborador> allSolicitacoes = solicitacaoAssociadaColaboradorRepository.findSolicitacaoAssociadaColaboradorByTipoIs(tipo);
        return allSolicitacoes.stream()
                .map(SolicitacaoAssociadaColaboradorDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<SolicitacaoAssociadaColaboradorDTO> findSolicitacaoAssociadaColaboradorByCpf(String cpf) {
        List<SolicitacaoAssociadaColaborador> allSolicitacoes = solicitacaoAssociadaColaboradorRepository.findByCpf(cpf);
        return allSolicitacoes.stream()
                .map(SolicitacaoAssociadaColaboradorDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public SolicitacaoAssociadaColaboradorDTO findSolicitacaoAssociadaColaboradorById(String id) {
        SolicitacaoAssociadaColaborador allSolicitacoes = solicitacaoAssociadaColaboradorRepository.findById(id).orElse(null);;
        return new SolicitacaoAssociadaColaboradorDTO(allSolicitacoes) ;
    }

    @Override
    public List<SolicitacaoAssociadaColaboradorDTO> FindAllSolicitacaoAssociada() {
        List<SolicitacaoAssociadaColaborador> allSolicitacoes = solicitacaoAssociadaColaboradorRepository.findAllBy();
        return allSolicitacoes.stream()
                .map(SolicitacaoAssociadaColaboradorDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public void editSolicitacaoAssociadaColaborador(Integer id, String status) {

        SolicitacaoAssociadaColaborador solicitacaoAssociadaColaborador = solicitacaoAssociadaColaboradorRepository.findById(id);

        if(solicitacaoAssociadaColaborador.getStatus().equals(status)){
            throw new RuntimeException("Este status já está atribuído");
        }

        String emailUsuario = SecurityContextHolder.getContext().getAuthentication().getName();

        solicitacaoAssociadaColaborador.setAtualizado_por(emailUsuario);
        solicitacaoAssociadaColaborador.setStatus(status);

        solicitacaoAssociadaColaboradorRepository.save(solicitacaoAssociadaColaborador);
    }


}

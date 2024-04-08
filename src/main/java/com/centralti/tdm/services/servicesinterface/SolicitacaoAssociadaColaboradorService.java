package com.centralti.tdm.services.servicesinterface;

import com.centralti.tdm.domain.usuarios.DTO.DadosColaboradoresDTO;
import com.centralti.tdm.domain.usuarios.DTO.SolicitacaoAssociadaColaboradorDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SolicitacaoAssociadaColaboradorService {
    void createdSolicitacaoAssociadaColaborador(SolicitacaoAssociadaColaboradorDTO solicitacaoAssociadaColaboradorDTO);
    List<SolicitacaoAssociadaColaboradorDTO> findSolicitacaoAssociadaColaboradorByStatus(String status);
    List<SolicitacaoAssociadaColaboradorDTO> findSolicitacaoAssociadaColaboradorByTipo(String tipo);
    List<SolicitacaoAssociadaColaboradorDTO> findSolicitacaoAssociadaColaboradorByCpf(String cpf);
    SolicitacaoAssociadaColaboradorDTO findSolicitacaoAssociadaColaboradorById(String id);
    List<SolicitacaoAssociadaColaboradorDTO> FindAllSolicitacaoAssociada();
    void editSolicitacaoAssociadaColaborador(Integer id,String status);
}

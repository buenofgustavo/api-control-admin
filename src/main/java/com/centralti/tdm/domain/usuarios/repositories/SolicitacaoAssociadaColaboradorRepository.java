package com.centralti.tdm.domain.usuarios.repositories;

import com.centralti.tdm.domain.usuarios.entidades.DadosColaboradores;
import com.centralti.tdm.domain.usuarios.entidades.SolicitacaoAssociadaColaborador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SolicitacaoAssociadaColaboradorRepository extends JpaRepository<SolicitacaoAssociadaColaborador, String> {
    List<SolicitacaoAssociadaColaborador> findAllBy();
    List<SolicitacaoAssociadaColaborador> findSolicitacaoAssociadaColaboradorByStatusIs(String status);
    List<SolicitacaoAssociadaColaborador> findSolicitacaoAssociadaColaboradorByTipoIs(String tipo);
    List<SolicitacaoAssociadaColaborador> findByCpf(String cpf);
    SolicitacaoAssociadaColaborador findById(Integer id);

}

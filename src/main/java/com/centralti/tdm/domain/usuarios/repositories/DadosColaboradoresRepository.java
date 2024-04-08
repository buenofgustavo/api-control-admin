package com.centralti.tdm.domain.usuarios.repositories;

import com.centralti.tdm.domain.usuarios.entidades.Computadores;
import com.centralti.tdm.domain.usuarios.entidades.DadosColaboradores;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DadosColaboradoresRepository extends JpaRepository<DadosColaboradores, String> {
    DadosColaboradores findByCpf(String cpf);
    List<DadosColaboradores> findAllBy();
    List<DadosColaboradores> findDadosColaboradoresByStatusIsTrue();
    List<DadosColaboradores> findDadosColaboradoresByStatusIsFalse();
    List<DadosColaboradores> findDadosColaboradoresByTermoIsFalse();
    List<DadosColaboradores> findDadosColaboradoresByComputadorIsNull();
    List<DadosColaboradores> findDadosColaboradoresByRegimeContratacaoIs(String regime);
    List<DadosColaboradores> findDadosColaboradoresByFilialIs(String filial);



}

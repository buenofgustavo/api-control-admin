package com.centralti.tdm.domain.usuarios.repositories;

import com.centralti.tdm.domain.usuarios.DTO.ComputadoresDTO;
import com.centralti.tdm.domain.usuarios.entidades.Acessos;
import com.centralti.tdm.domain.usuarios.entidades.Chamados;
import com.centralti.tdm.domain.usuarios.entidades.Computadores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ComputadoresRepository extends JpaRepository<Computadores, String> {
    Computadores findByEnderecoMac(String EnderecoMac);
    List<Computadores> findAllBy();
    List<Computadores> findAllByUserAtualIsNull();
    List<Computadores> findAllByUserAtualIsNotNull();

    @Query("SELECT u.nomeComputador, u.nomeUsuario, u.enderecoMac, c.nome, c.filial, u.serial " +
            "FROM unique_computadores u JOIN colaboradores c ON u.enderecoMac = c.computador")
    List<Object[]> findAllComputadoresWithDetails();

    @Query("SELECT u.nomeComputador, u.nomeUsuario, u.enderecoMac, c.nome, c.filial, u.serial " +
            "FROM unique_computadores u JOIN colaboradores c ON u.enderecoMac = c.computador " +
            "WHERE c.filial = :filial")
    List<Object[]> findComputadoresByFilial(@Param("filial") String filial);
}
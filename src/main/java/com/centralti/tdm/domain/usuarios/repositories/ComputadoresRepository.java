package com.centralti.tdm.domain.usuarios.repositories;

import com.centralti.tdm.domain.usuarios.entidades.Acessos;
import com.centralti.tdm.domain.usuarios.entidades.Chamados;
import com.centralti.tdm.domain.usuarios.entidades.Computadores;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComputadoresRepository extends JpaRepository<Computadores, String> {
    Computadores findByEnderecoMac(String EnderecoMac);
    List<Computadores> findAllBy();
    List<Computadores> findAllByUserAtualIsNull();
    List<Computadores> findAllByUserAtualIsNotNull();
}
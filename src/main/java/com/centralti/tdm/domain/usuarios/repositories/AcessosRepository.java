package com.centralti.tdm.domain.usuarios.repositories;

import com.centralti.tdm.domain.usuarios.entidades.Acessos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface AcessosRepository extends JpaRepository<Acessos, String> {
    Optional<Acessos> findByCpf(String cpf);
}

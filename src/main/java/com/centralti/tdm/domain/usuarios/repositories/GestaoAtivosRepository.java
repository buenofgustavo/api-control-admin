package com.centralti.tdm.domain.usuarios.repositories;

import com.centralti.tdm.domain.usuarios.entidades.GestaoAtivos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GestaoAtivosRepository extends JpaRepository<GestaoAtivos, String> {
    List<GestaoAtivos> findAllByTipo(String tipo);
    GestaoAtivos findById(Integer id);
}

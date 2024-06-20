package com.centralti.tdm.domain.usuarios.repositories;

import com.centralti.tdm.domain.usuarios.entidades.Arquivos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ArquivosRepository extends JpaRepository<Arquivos, String> {
    List<Arquivos> findArquivosByNumeroChamado(String id);
}

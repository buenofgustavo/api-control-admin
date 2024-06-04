package com.centralti.tdm.domain.usuarios.repositories;

import com.centralti.tdm.domain.usuarios.entidades.Acessos;
import com.centralti.tdm.domain.usuarios.entidades.Arquivos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ArquivosRepository extends JpaRepository<Arquivos, String> {
    List<Arquivos> findArquivosByNumeroChamado(String id);
}

package com.centralti.tdm.services.servicesimpl;

import com.centralti.tdm.domain.usuarios.DTO.ComputadoresDTO;
import com.centralti.tdm.domain.usuarios.DTO.GestaoAtivosDTO;
import com.centralti.tdm.domain.usuarios.entidades.ChatSolicitacoesColaboradores;
import com.centralti.tdm.domain.usuarios.entidades.Computadores;
import com.centralti.tdm.domain.usuarios.entidades.GestaoAtivos;
import com.centralti.tdm.domain.usuarios.entidades.SolicitacaoAssociadaColaborador;
import com.centralti.tdm.domain.usuarios.repositories.GestaoAtivosRepository;
import com.centralti.tdm.services.servicesinterface.GestaoAtivosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GestaoAtivosServiceImpl implements GestaoAtivosService {

    @Autowired
    GestaoAtivosRepository gestaoAtivosRepository;

    @Override
    public void createdAtivos(GestaoAtivosDTO gestaoAtivosDTO) {

        GestaoAtivos gestaoAtivos = new GestaoAtivos(gestaoAtivosDTO);

        String emailUsuario = SecurityContextHolder.getContext().getAuthentication().getName();
        gestaoAtivos.setAtualizadoPor(emailUsuario);


        gestaoAtivosRepository.save(gestaoAtivos);
    }

    @Override
    public List<GestaoAtivosDTO> findByAll() {
        List<GestaoAtivos> allAtivos = gestaoAtivosRepository.findAll();
        return allAtivos.stream()
                .map(GestaoAtivosDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<GestaoAtivosDTO> findByTipo(String tipo) {
        List<GestaoAtivos> allAtivos = gestaoAtivosRepository.findAllByTipo(tipo);
        return allAtivos.stream()
                .map(GestaoAtivosDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public void editAtivos(GestaoAtivosDTO gestaoAtivosDTO) {
        GestaoAtivos gestaoAtivos = gestaoAtivosRepository.findById(gestaoAtivosDTO.id());

        String emailUsuario = SecurityContextHolder.getContext().getAuthentication().getName();

        gestaoAtivos.setNome(gestaoAtivosDTO.nome());
        gestaoAtivos.setTipo(gestaoAtivosDTO.tipo());
        gestaoAtivos.setStatus(gestaoAtivosDTO.status());
        gestaoAtivos.setDescricao(gestaoAtivosDTO.descricao());
        gestaoAtivos.setLocalizacao(gestaoAtivosDTO.localizacao());
        gestaoAtivos.setAtualizadoPor(emailUsuario);

        gestaoAtivosRepository.save(gestaoAtivos);
    }

    @Override
    public void deletarAtivos(String id) {
        Optional<GestaoAtivos> gestaoAtivosOptional = gestaoAtivosRepository.findById(id);

        if (gestaoAtivosOptional.isPresent()) {
            GestaoAtivos gestaoAtivos = gestaoAtivosOptional.get();
            gestaoAtivosRepository.delete(gestaoAtivos);
            // ou gestaoAtivosRepository.deleteById(id); se você tiver o método deleteById no seu repositório
        } else {
            // Lidar com o caso em que o objeto não é encontrado
            throw new NoSuchElementException("Ativo não encontrada com o ID: " + id);
        }
    }

}

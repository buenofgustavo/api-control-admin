package com.centralti.tdm.services.servicesimpl;

import com.centralti.tdm.domain.usuarios.DTO.UsuarioDTO;
import com.centralti.tdm.domain.usuarios.entidades.Usuario;
import com.centralti.tdm.domain.usuarios.repositories.UsuarioRepository;
import com.centralti.tdm.services.servicesinterface.UsuarioInterface;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioInterface {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public void createUsuario(UsuarioDTO usuarioDTO){
        Usuario existingUsuario = this.usuarioRepository.findByEmail(usuarioDTO.email());
        if (existingUsuario != null){
            throw new RuntimeException("Colaborador já existente!");
        }
        Usuario newUsuario = new Usuario(usuarioDTO);
        usuarioRepository.save(newUsuario);
    }

    @Override
    public void deleteUsuario(String id){
        usuarioRepository.deleteById(id);
    }

    public UsuarioDTO findByUsuario(String id){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        Usuario usuario = usuarioOptional.orElseThrow(() -> new EntityNotFoundException("Colaborador não localizado"));
        return new UsuarioDTO(usuario);
    }

    @Override
    public List<UsuarioDTO> findAllUsuario() {
        List<Usuario> allUsuario = usuarioRepository.findAll();
        return allUsuario.stream()
                .map(UsuarioDTO::new)
                .collect(Collectors.toList());
    }

}

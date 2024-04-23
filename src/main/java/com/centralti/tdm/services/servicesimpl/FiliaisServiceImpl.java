package com.centralti.tdm.services.servicesimpl;

import com.centralti.tdm.domain.usuarios.DTO.FiliaisDTO;
import com.centralti.tdm.domain.usuarios.entidades.Filiais;
import com.centralti.tdm.domain.usuarios.repositories.FiliaisRepository;
import com.centralti.tdm.services.servicesinterface.FiliaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FiliaisServiceImpl implements FiliaisService {

    @Autowired
    FiliaisRepository filiaisRepository;

    @Override
    public void create(FiliaisDTO departamentosDTO) {
        Filiais departamentos = new Filiais(departamentosDTO);

        filiaisRepository.save(departamentos);
    }

    @Override
    public List<FiliaisDTO> listar() {
        List<Filiais> allFiliais = filiaisRepository.findAll();
        return allFiliais.stream()
                .map(FiliaisDTO::new) // Verifique se o construtor de FiliaisDTO aceita um objeto Filiais
                .collect(Collectors.toList());
    }


}
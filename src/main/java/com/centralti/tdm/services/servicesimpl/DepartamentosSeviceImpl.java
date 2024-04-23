package com.centralti.tdm.services.servicesimpl;

import com.centralti.tdm.domain.usuarios.DTO.DepartamentosDTO;
import com.centralti.tdm.domain.usuarios.DTO.GestaoAtivosDTO;
import com.centralti.tdm.domain.usuarios.entidades.Departamentos;
import com.centralti.tdm.domain.usuarios.entidades.Ferias;
import com.centralti.tdm.domain.usuarios.entidades.GestaoAtivos;
import com.centralti.tdm.domain.usuarios.repositories.DepartamentosRepository;
import com.centralti.tdm.services.servicesinterface.DepartamentosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartamentosSeviceImpl implements DepartamentosService {

    @Autowired
    DepartamentosRepository departamentosRepository;

    @Override
    public void create(DepartamentosDTO departamentosDTO) {
        Departamentos departamentos = new Departamentos(departamentosDTO);

        departamentosRepository.save(departamentos);
    }

    @Override
    public List<DepartamentosDTO> listar() {
        List<Departamentos> allAtivos = departamentosRepository.findAll();
        return allAtivos.stream()
                .map(DepartamentosDTO::new)
                .collect(Collectors.toList());
    }
}

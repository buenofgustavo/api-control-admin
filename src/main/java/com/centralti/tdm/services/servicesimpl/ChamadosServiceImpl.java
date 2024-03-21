package com.centralti.tdm.services.servicesimpl;

import com.centralti.tdm.domain.usuarios.DTO.ChamadosDTO;
import com.centralti.tdm.domain.usuarios.repositories.ChamadosRepository;
import com.centralti.tdm.domain.usuarios.repositories.UsuarioRepository;
import com.centralti.tdm.services.servicesinterface.ChamadosInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChamadosServiceImpl implements ChamadosInterface {

    @Autowired
    ChamadosRepository chamadosRepository;

    public void createChamados(ChamadosDTO chamadosDTO){

        

    }


    public void editChamados(String id, Number status) {

    }

    public List<ChamadosDTO> FindAllChamados() {
        // Criando uma lista fictícia de chamados
        List<ChamadosDTO> chamadosFicticios = new ArrayList<>();
        chamadosFicticios.add(new ChamadosDTO("1", "Usuário1", "Título do Chamado 1", "Descrição do Chamado 1",
                "Categoria1", "Prioridade Alta", new byte[0], "Aberto"));
        chamadosFicticios.add(new ChamadosDTO("2", "Usuário2", "Título do Chamado 2", "Descrição do Chamado 2",
                "Categoria2", "Prioridade Baixa", new byte[0], "Fechado"));
        chamadosFicticios.add(new ChamadosDTO("3", "Usuário3", "Título do Chamado 3", "Descrição do Chamado 3",
                "Categoria3", "Prioridade Média", new byte[0], "Aberto"));
        return chamadosFicticios;
    }

    public ChamadosDTO findByChamados(String id) {

        return new ChamadosDTO("1", "Usuário1", "Título do Chamado", "Descrição do Chamado",
                "Categoria1", "Prioridade Alta", new byte[0], "Aberto");
    }

    public void deleteChamados(String id) {

    }

}

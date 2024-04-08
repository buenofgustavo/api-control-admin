package com.centralti.tdm.services.servicesinterface;

import com.centralti.tdm.domain.usuarios.DTO.DadosColaboradoresDTO;
import com.centralti.tdm.domain.usuarios.entidades.DadosColaboradores;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DadosColaboradoresService {
    List<DadosColaboradoresDTO> FindAllColaboradoresAtivos();
    List<DadosColaboradoresDTO> FindAllColaboradoresInativos();
    List<DadosColaboradoresDTO> FindAllDadosColaboradores();
    List<DadosColaboradoresDTO> FindAllColaboradoresTermoPendente();
    List<DadosColaboradoresDTO> FindAllColaboradoresSemComputador();
    List<DadosColaboradoresDTO> FindAllColaboradoresRegimeContratacao(String regime);
    List<DadosColaboradoresDTO> FindAllColaboradoresFilial(String filial);



    DadosColaboradoresDTO findByDadosColaboradoresCpf(String cpf);
    void createdColaboradores(DadosColaboradoresDTO colaboradoresDTO);
    void vincularComputador(String cpf, String computador);
    void desvincularComputador(String cpf);
    void desligamentoColaborador(String cpf);
    void mudancaDeCargo(DadosColaboradoresDTO dadosColaboradoresDTO);
    void termoAssinado(String cpf);
}

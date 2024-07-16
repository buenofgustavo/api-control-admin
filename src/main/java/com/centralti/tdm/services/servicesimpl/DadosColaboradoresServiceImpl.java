package com.centralti.tdm.services.servicesimpl;

import com.centralti.tdm.domain.usuarios.DTO.*;
import com.centralti.tdm.domain.usuarios.entidades.Computadores;
import com.centralti.tdm.domain.usuarios.entidades.DadosColaboradores;
import com.centralti.tdm.domain.usuarios.repositories.ComputadoresRepository;
import com.centralti.tdm.domain.usuarios.repositories.DadosColaboradoresRepository;
import com.centralti.tdm.services.servicesinterface.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DadosColaboradoresServiceImpl implements DadosColaboradoresService {

    @Autowired
    DadosColaboradoresRepository dadosColaboradoresRepository;

    @Autowired
    AcessosService acessosService;

    @Autowired
    ComputadoresRepository computadoresRepository;

    @Autowired
    SolicitacaoAssociadaColaboradorService solicitacaoAssociadaColaboradorService;

    @Autowired
    FeriasService feriasService;

    @Autowired
    LogComputadoresService logComputadoresService;

    @Override
    public List<DadosColaboradoresDTO> FindAllColaboradoresAtivos() {
        List<DadosColaboradores> allChamados = dadosColaboradoresRepository.findDadosColaboradoresByStatusIsTrue();
        return allChamados.stream()
                .map(DadosColaboradoresDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<DadosColaboradoresDTO> FindAllColaboradoresInativos() {
        List<DadosColaboradores> allChamados = dadosColaboradoresRepository.findDadosColaboradoresByStatusIsFalse();
        return allChamados.stream()
                .map(DadosColaboradoresDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<DadosColaboradoresDTO> FindAllDadosColaboradores() {
        List<DadosColaboradores> allChamados = dadosColaboradoresRepository.findAllBy();
        return allChamados.stream()
                .map(DadosColaboradoresDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<DadosColaboradoresDTO> FindAllColaboradoresTermoPendente() {
        List<DadosColaboradores> allChamados = dadosColaboradoresRepository.findDadosColaboradoresByTermoIsFalse();
        return allChamados.stream()
                .map(DadosColaboradoresDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<DadosColaboradoresDTO> FindAllColaboradoresSemComputador() {
        List<DadosColaboradores> allChamados = dadosColaboradoresRepository.findDadosColaboradoresByComputadorIsNull();
        return allChamados.stream()
                .map(DadosColaboradoresDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<DadosColaboradoresDTO> FindAllColaboradoresRegimeContratacao(String regime) {
        List<DadosColaboradores> allChamados = dadosColaboradoresRepository.findDadosColaboradoresByRegimeContratacaoIs(regime);
        return allChamados.stream()
                .map(DadosColaboradoresDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<DadosColaboradoresDTO> FindAllColaboradoresFilial(String filial) {
        List<DadosColaboradores> allChamados = dadosColaboradoresRepository.findDadosColaboradoresByFilialIs(filial);
        return allChamados.stream()
                .map(DadosColaboradoresDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public DadosColaboradoresDTO findByDadosColaboradoresCpf(String cpf) {
        DadosColaboradores dados = dadosColaboradoresRepository.findByCpf(cpf);
        return new DadosColaboradoresDTO(dados);
    }

    @Override
    public void createdColaboradores(DadosColaboradoresDTO colaboradoresDTO) {
        String emailUsuario = SecurityContextHolder.getContext().getAuthentication().getName();

        String cpf = colaboradoresDTO.cpf();

        // Verifica se já existe um registro com o mesmo CPF
        DadosColaboradores existingColaborador = dadosColaboradoresRepository.findByCpf(cpf);
        if (existingColaborador != null && !existingColaborador.getStatus()) {
            existingColaborador.setStatus(true);
            existingColaborador.setNumero(colaboradoresDTO.numero());
            existingColaborador.setCargo(colaboradoresDTO.cargo());
            existingColaborador.setFilial(colaboradoresDTO.filial());
            existingColaborador.setDepartamento(colaboradoresDTO.departamento());
            existingColaborador.setRegimeContratacao(colaboradoresDTO.regimeContratacao());
            existingColaborador.setTermo(false);
            existingColaborador.setAtualizado_por(emailUsuario);

            String status = "Em aberto";
            String tipo = "Solicitação de acessos";
            SolicitacaoAssociadaColaboradorDTO solicitacaoAssociadaColaboradorDTO = new SolicitacaoAssociadaColaboradorDTO(null,emailUsuario,colaboradoresDTO.nome(),colaboradoresDTO.numero(),colaboradoresDTO.cpf(),colaboradoresDTO.filial(),colaboradoresDTO.cargo(),colaboradoresDTO.departamento(),null,status, tipo, LocalDateTime.now());
            solicitacaoAssociadaColaboradorService.createdSolicitacaoAssociadaColaborador(solicitacaoAssociadaColaboradorDTO);

            dadosColaboradoresRepository.save(existingColaborador);
        } else {
            // Se não existir ou se o status já estiver como true, cria um novo registro
            DadosColaboradores newDadosColaboradores = new DadosColaboradores(colaboradoresDTO);
            Boolean status = true;
            newDadosColaboradores.setStatus(status);
            newDadosColaboradores.setUsuario_solicitante(emailUsuario);
            newDadosColaboradores.setAtualizado_por(emailUsuario);
            dadosColaboradoresRepository.save(newDadosColaboradores);

            String status_em_aberto = "Em aberto";
            String tipo_acesso = "Solicitação de acessos";
            SolicitacaoAssociadaColaboradorDTO solicitacaoAssociadaColaboradorDTO = new SolicitacaoAssociadaColaboradorDTO(null, emailUsuario, colaboradoresDTO.nome(), colaboradoresDTO.numero(), colaboradoresDTO.cpf(), colaboradoresDTO.filial(), colaboradoresDTO.cargo(), colaboradoresDTO.departamento(), emailUsuario, status_em_aberto, tipo_acesso, LocalDateTime.now());
            solicitacaoAssociadaColaboradorService.createdSolicitacaoAssociadaColaborador(solicitacaoAssociadaColaboradorDTO);

            FeriasDTO feriasDTO = new FeriasDTO(null, colaboradoresDTO.cpf(), null, null, emailUsuario);
            feriasService.createdFerias(feriasDTO);

            AcessosDTO acessosDTO = new AcessosDTO(null, cpf, null, null, null, null, null, null, null, null);
            acessosService.createAcessos(acessosDTO);
        }
    }

    @Override
    public void vincularComputador(String cpf, String computador) {
        DadosColaboradores dadosColaboradores = dadosColaboradoresRepository.findByCpf(cpf);

        Computadores computadores = computadoresRepository.findByEnderecoMac(computador);
        String statusVazio = null;

        if (computadores == null) {
            // Se o computador não for encontrado, lança uma exceção ou trata o erro de outra forma
            throw new RuntimeException("O computador com o endereço MAC fornecido não foi encontrado.");
        }

        if(dadosColaboradores.getComputador() != null){
            throw new RuntimeException("O colaborador já possui computador.");
        }

        if (computadores.getUserAtual() != null) {
            // Se o computador já tiver um usuário atual, lança uma exceção ou trata o erro de outra forma
            throw new RuntimeException("Este computador já está vinculado a um usuário.");
        } else{
            String emailUsuario = SecurityContextHolder.getContext().getAuthentication().getName();
            dadosColaboradores.setAtualizado_por(emailUsuario);
            dadosColaboradores.setComputador(computador);
            Boolean termo = false;
            dadosColaboradores.setTermo(termo);

            computadores.setStatus(statusVazio);
            computadores.setUserAtual(cpf);
            computadores.setNomeUserAtual(dadosColaboradores.getNome());
            computadoresRepository.save(computadores);

            dadosColaboradoresRepository.save(dadosColaboradores);

            String mensagem = "Computador vinculado ao usuário " + dadosColaboradores.getNome() + " por " + emailUsuario;
            String tipo = "vincular";
            logComputadoresService.createLogAutomaticoComputadores(mensagem, computadores.getEnderecoMac(), computadores.getNomeComputador(), tipo);
        }

    }

    @Override
    public void desvincularComputador(String cpf) {
        DadosColaboradores dadosColaboradores = dadosColaboradoresRepository.findByCpf(cpf);
        String mac = dadosColaboradores.getComputador();

        String computadorVazio = null;
        String userVazio = null;

        String emailUsuario = SecurityContextHolder.getContext().getAuthentication().getName();
        String status = "Alerta";

        // Verifica se o MAC do computador não é vazio
        if (mac != null && !mac.isEmpty()) {
            Computadores computadores = computadoresRepository.findByEnderecoMac(mac);
            if (computadores != null) {
                Boolean termo = false;
                dadosColaboradores.setTermo(false);

                computadores.setUserAtual(userVazio);
                computadores.setNomeUserAtual(userVazio);

                computadores.setLastUser(cpf);
                computadores.setNomeLastUser(dadosColaboradores.getNome());
                computadores.setStatus(status);

                computadoresRepository.save(computadores);

                String mensagem = "Computador do usuário " + dadosColaboradores.getNome() + " desvinculado por " + emailUsuario;
                String tipo = "desvincular";
                logComputadoresService.createLogAutomaticoComputadores(mensagem, computadores.getEnderecoMac(), computadores.getNomeComputador(), tipo);

            }
        }

        dadosColaboradores.setComputador(computadorVazio);
        dadosColaboradores.setAtualizado_por(emailUsuario);

        dadosColaboradoresRepository.save(dadosColaboradores);
    }

    @Override
    public void desligamentoColaborador(String cpf) {

        DadosColaboradores dadosColaboradores = dadosColaboradoresRepository.findByCpf(cpf);
        String emailUsuario = SecurityContextHolder.getContext().getAuthentication().getName();
        dadosColaboradores.setAtualizado_por(emailUsuario);

        if(!dadosColaboradores.getStatus()){
            throw new RuntimeException("Este usuário já está desligado");
        }

        Boolean status = false;
        dadosColaboradores.setStatus(status);

        String mac = dadosColaboradores.getComputador();
        String computadorVazio = null;
        String userVazio = null;
        String statusVazio = null;

        // Verifica se o MAC do computador não é vazio
        if (mac != null && !mac.isEmpty()) {
            Computadores computadores = computadoresRepository.findByEnderecoMac(mac);
            if (computadores != null) {

                computadores.setUserAtual(userVazio);
                computadores.setNomeUserAtual(userVazio);

                computadores.setLastUser(cpf);
                computadores.setNomeLastUser(dadosColaboradores.getNome());
                computadores.setStatus(statusVazio);
                computadoresRepository.save(computadores);

                String mensagem = "Colaborador desligado: computador do usuário " + dadosColaboradores.getNome() + " desvinculado por " + emailUsuario;
                String tipo = "desligamento";
                logComputadoresService.createLogAutomaticoComputadores(mensagem, computadores.getEnderecoMac(), computadores.getNomeComputador(), tipo);

            }
        }

        String status_solicitacao = "Em aberto";
        String tipo_solicitacao = "Solicitação de desligamento";
        SolicitacaoAssociadaColaboradorDTO solicitacaoAssociadaColaboradorDTO = new SolicitacaoAssociadaColaboradorDTO(null,emailUsuario, dadosColaboradores.getNome(), dadosColaboradores.getNumero(),dadosColaboradores.getCpf(),dadosColaboradores.getFilial(),dadosColaboradores.getCargo(),dadosColaboradores.getDepartamento(),emailUsuario,status_solicitacao, tipo_solicitacao, LocalDateTime.now());
        solicitacaoAssociadaColaboradorService.createdSolicitacaoAssociadaColaborador(solicitacaoAssociadaColaboradorDTO);

        // Define o computador do colaborador como vazio
        dadosColaboradores.setComputador(computadorVazio);
        // Salva as alterações no repositório
        dadosColaboradoresRepository.save(dadosColaboradores);
    }

    @Override
    public void mudancaDeCargo(DadosColaboradoresDTO dadosColaboradoresDTO) {
        DadosColaboradores dadosColaboradores = dadosColaboradoresRepository.findByCpf(dadosColaboradoresDTO.cpf());

        String emailUsuario = SecurityContextHolder.getContext().getAuthentication().getName();
        dadosColaboradores.setAtualizado_por(emailUsuario);

        dadosColaboradores.setCargo(dadosColaboradoresDTO.cargo());
        dadosColaboradores.setFilial(dadosColaboradoresDTO.filial());
        dadosColaboradores.setDepartamento(dadosColaboradoresDTO.departamento());
        dadosColaboradores.setRegimeContratacao(dadosColaboradoresDTO.regimeContratacao());

        String status_solicitacao = "Em aberto";
        String tipo_solicitacao = "Solicitação de mudança de cargo";
        SolicitacaoAssociadaColaboradorDTO solicitacaoAssociadaColaboradorDTO = new SolicitacaoAssociadaColaboradorDTO(null,emailUsuario,dadosColaboradores.getNome(),dadosColaboradores.getNumero(),dadosColaboradores.getCpf(),dadosColaboradores.getFilial(),dadosColaboradores.getCargo(),dadosColaboradores.getDepartamento(),emailUsuario,status_solicitacao, tipo_solicitacao, LocalDateTime.now());
        solicitacaoAssociadaColaboradorService.createdSolicitacaoAssociadaColaborador(solicitacaoAssociadaColaboradorDTO);


        dadosColaboradoresRepository.save(dadosColaboradores);
    }

    @Override
    public void termoAssinado(String cpf) {
        DadosColaboradores dadosColaboradores = dadosColaboradoresRepository.findByCpf(cpf);

        if (dadosColaboradores.getTermo() == true) {
            // Se o computador não for encontrado, lança uma exceção ou trata o erro de outra forma
            throw new RuntimeException("O colaborador já possui termo assinado.");
        }

        String emailUsuario = SecurityContextHolder.getContext().getAuthentication().getName();
        dadosColaboradores.setAtualizado_por(emailUsuario);

        Boolean termo = true;

        dadosColaboradores.setTermo(termo);

        dadosColaboradoresRepository.save(dadosColaboradores);
    }


}

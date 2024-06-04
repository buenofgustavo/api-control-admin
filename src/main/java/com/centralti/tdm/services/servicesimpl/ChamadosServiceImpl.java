package com.centralti.tdm.services.servicesimpl;

import com.centralti.tdm.domain.usuarios.DTO.ArquivosDTO;
import com.centralti.tdm.domain.usuarios.DTO.ChamadosDTO;
import com.centralti.tdm.domain.usuarios.entidades.Arquivos;
import com.centralti.tdm.domain.usuarios.entidades.Chamados;
import com.centralti.tdm.domain.usuarios.repositories.ArquivosRepository;
import com.centralti.tdm.domain.usuarios.repositories.ChamadosRepository;
import com.centralti.tdm.services.servicesinterface.ChamadosService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChamadosServiceImpl implements ChamadosService {

    @Autowired
    ChamadosRepository chamadosRepository;


    private final Upload upload;

    @Autowired
    ArquivosRepository arquivosRepository;

    @Autowired
    public ChamadosServiceImpl(ArquivosRepository arquivosRepository) {
        this.upload = new Upload(arquivosRepository);
    }

    @Override
    public String createChamados(ChamadosDTO chamadosDTO) {

        Chamados newChamados = new Chamados(chamadosDTO);

        String emailUsuario = SecurityContextHolder.getContext().getAuthentication().getName();

        newChamados.setStatus("Em aberto");
        newChamados.setAtualizado_por(emailUsuario);
        newChamados.setUsuarioVinculado(emailUsuario);
        newChamados.setExcluido(false);
        Chamados savedChamados = chamadosRepository.save(newChamados);

        return savedChamados.getId();
    }

    @Override
    public void createArquivosChamados(List<MultipartFile> files, String id) {

        try {
            upload.fazerUploadImagem(files, id);
            System.out.println("Salvo com sucesso: " + id);
        } catch (Exception e) {
            System.out.println("Erro ao salvar " + e.getMessage());
        }
    }

    public void editChamados(String id, String status) {
        Optional<Chamados> optionalChamados = chamadosRepository.findById(id);
        if(optionalChamados.isPresent()){
            Chamados chamados = optionalChamados.get();
            String emailUsuario = SecurityContextHolder.getContext().getAuthentication().getName();
            chamados.setAtualizado_por(emailUsuario);
            chamados.setStatus(status);

            chamadosRepository.save(chamados);

        } else {
            throw new EntityNotFoundException();
        }
    }

    public List<ChamadosDTO> FindAllChamados() {
        List<Chamados> allChamados = chamadosRepository.findAllByExcluidoFalse();
        return allChamados.stream()
                .map(ChamadosDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<ArquivosDTO> findAllArquivos(String id) {
        List<Arquivos> allChamados = arquivosRepository.findArquivosByNumeroChamado(id);
        return allChamados.stream()
                .map(ArquivosDTO::new)
                .collect(Collectors.toList());
    }



    public List<ChamadosDTO> FindChamadosByUsuario(String usuario) {
        List<Chamados> allChamados = chamadosRepository.findChamadosByUsuarioVinculado(usuario);
        return allChamados.stream()
                .map(ChamadosDTO::new)
                .collect(Collectors.toList());
    }

    public ChamadosDTO findByChamados(String id) {
        Optional<Chamados> chamadosOptional = chamadosRepository.findById(id);
        Chamados chamados = chamadosOptional.orElseThrow(() -> new EntityNotFoundException("Chamado não localizado"));
        return new ChamadosDTO(chamados);
    }

    public List<ChamadosDTO> findChamadosByStatus(String status) {
        List<Chamados> allChamados = chamadosRepository.findChamadosByStatus(status);
        return allChamados.stream()
                .map(ChamadosDTO::new)
                .collect(Collectors.toList());
    }

    public void deleteChamados(String id) {
        Optional<Chamados> optionalChamados = chamadosRepository.findById(id);
        if(optionalChamados.isPresent()){

            String emailUsuario = SecurityContextHolder.getContext().getAuthentication().getName();

            Chamados chamados = optionalChamados.get();

            chamados.setAtualizado_por(emailUsuario);
            chamados.setExcluido(true);
        } else {
            throw new EntityNotFoundException();
        }
    }

}

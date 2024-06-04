package com.centralti.tdm.services.servicesimpl;
import com.centralti.tdm.domain.usuarios.DTO.ArquivosDTO;
import com.centralti.tdm.domain.usuarios.DTO.ChamadosDTO;
import com.centralti.tdm.domain.usuarios.entidades.Chamados;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.centralti.tdm.domain.usuarios.repositories.ArquivosRepository;
import com.centralti.tdm.domain.usuarios.entidades.Arquivos;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class Upload {

    private final ArquivosRepository arquivosRepository;

    public Upload(ArquivosRepository arquivosRepository) {
        this.arquivosRepository = arquivosRepository;
    }

    public void fazerUploadImagem(List<MultipartFile> files, String idChamado){

        if (files.isEmpty()) {
            System.out.println("Nenhum arquivo foi enviado");
            return;
        }

        try {
            String uploadDir = "C:/Users/Suporte/Documents/FRONTEND_CONTROL_ADMIN/src/assets/img-uploads/files-chamados/";
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    String fileName = file.getOriginalFilename();
                    String filePath = uploadDir + idChamado + "_" + fileName;
                    File dest = new File(filePath);
                    file.transferTo(dest);

                    Arquivos arquivo = new Arquivos();
                    arquivo.setNomeArquivo(fileName);
                    arquivo.setNumeroChamado(idChamado);

                    arquivosRepository.save(arquivo);
                }
            }

            System.out.println("Arquivos salvos com sucesso no servidor e no banco de dados");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os arquivos no servidor: " + e.getMessage());
        }

    }



}

package com.centralti.tdm.services.servicesimpl;

import com.centralti.tdm.domain.usuarios.DTO.DocumentosColaboradoresDTO;
import com.centralti.tdm.domain.usuarios.entidades.DocumentosColaboradores;
import com.centralti.tdm.domain.usuarios.repositories.DocumentosColaboradoresRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class UploadDocumentosColaboradores {

    private final DocumentosColaboradoresRepository documentosColaboradoresRepository;

    public UploadDocumentosColaboradores(DocumentosColaboradoresRepository documentosColaboradoresRepository) {
        this.documentosColaboradoresRepository = documentosColaboradoresRepository;
    }

    public void fazerUploadImagem(List<MultipartFile> files, String cpf){

        if (files.isEmpty()) {
            System.out.println("Nenhum arquivo foi enviado");
            return;
        }

        try {
            String uploadDir = "C:/Users/Suporte/Documents/FRONTEND_CONTROL_ADMIN/src/assets/img-uploads/files-documentos/";
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    String fileName = file.getOriginalFilename();
                    String filePath = uploadDir + cpf + "_" + fileName;
                    File dest = new File(filePath);
                    file.transferTo(dest);

                    DocumentosColaboradores documentosColaboradores = new DocumentosColaboradores();
                    documentosColaboradores.setNomeArquivo(fileName);
                    documentosColaboradores.setCpf(cpf);

                    documentosColaboradoresRepository.save(documentosColaboradores);
                }
            }

            System.out.println("Arquivos salvos com sucesso no servidor e no banco de dados");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os arquivos no servidor: " + e.getMessage());
        }

    }

    public DocumentosColaboradoresDTO findDocuments(String cpf) {
        DocumentosColaboradores documentosColaboradores = documentosColaboradoresRepository.findByCpf(cpf);

        return new DocumentosColaboradoresDTO(documentosColaboradores);
    }

}

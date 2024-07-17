package com.centralti.tdm.services.servicesimpl;

import com.centralti.tdm.domain.usuarios.entidades.GestaoAtivos;
import com.centralti.tdm.domain.usuarios.repositories.GestaoAtivosRepository;
import com.centralti.tdm.services.servicesinterface.ExportService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.poi.ss.usermodel.*;

import java.io.IOException;
import java.util.List;


@Service
public class ExportServiceImpl implements ExportService {

    @Autowired
    private GestaoAtivosRepository gestaoAtivosRepository;

    public void exportAtivosToExcel(HttpServletResponse response, String localizacao, String atualizadoPor) throws IOException {
        List<GestaoAtivos> listaEntidades;

        if (!"todos".equals(localizacao) && !"todos".equals(atualizadoPor)) {
            listaEntidades = gestaoAtivosRepository.findByLocalizacaoAndAtualizadoPor(localizacao, atualizadoPor);
        } else if (!"todos".equals(localizacao)) {
            listaEntidades = gestaoAtivosRepository.findByLocalizacao(localizacao);
        } else if (!"todos".equals(atualizadoPor)) {
            listaEntidades = gestaoAtivosRepository.findByAtualizadoPor(atualizadoPor);
        } else {
            listaEntidades = gestaoAtivosRepository.findAll();
        }

        String nomeArquivo = "rel_" + localizacao + "_" + atualizadoPor;
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("relatorio");

        int rowNum = 0;
        Row headerRow = sheet.createRow(rowNum++);
        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("Nome");
        headerRow.createCell(2).setCellValue("Tipo");
        headerRow.createCell(3).setCellValue("Status");
        headerRow.createCell(4).setCellValue("Descrição");
        headerRow.createCell(5).setCellValue("Localização");
        headerRow.createCell(6).setCellValue("Serial");
        headerRow.createCell(7).setCellValue("Atualizado Por");

        for (GestaoAtivos entidade : listaEntidades) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(entidade.getId());
            row.createCell(1).setCellValue(entidade.getNome());
            row.createCell(2).setCellValue(entidade.getTipo());
            row.createCell(3).setCellValue(entidade.getStatus());
            row.createCell(4).setCellValue(entidade.getDescricao());
            row.createCell(5).setCellValue(entidade.getLocalizacao());
            row.createCell(6).setCellValue(entidade.getSerial());
            row.createCell(7).setCellValue(entidade.getAtualizadoPor());
        }

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + nomeArquivo + "\"");

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();

        outputStream.close();
    }

}

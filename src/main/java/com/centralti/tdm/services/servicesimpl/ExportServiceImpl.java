package com.centralti.tdm.services.servicesimpl;

import com.centralti.tdm.domain.usuarios.DTO.ComputadoresDTO;
import com.centralti.tdm.domain.usuarios.entidades.Computadores;
import com.centralti.tdm.domain.usuarios.entidades.GestaoAtivos;
import com.centralti.tdm.domain.usuarios.repositories.ComputadoresRepository;
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

    @Autowired
    private ComputadoresRepository computadoresRepository;

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

    @Override
    public void exportNotebooksToExcel(HttpServletResponse response, String filial) throws IOException {
        List<Object[]> listaEntidades;
        if ("todos".equalsIgnoreCase(filial)) {
            listaEntidades = computadoresRepository.findAllComputadoresWithDetails();
        } else {
            listaEntidades = computadoresRepository.findComputadoresByFilial(filial);
        }

        String nomeArquivo = "rel_" + filial;
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("relatorio");

        int rowNum = 0;
        Row headerRow = sheet.createRow(rowNum++);
        headerRow.createCell(0).setCellValue("nome_computador");
        headerRow.createCell(1).setCellValue("nome_usuario");
        headerRow.createCell(2).setCellValue("endereco_mac");
        headerRow.createCell(3).setCellValue("nome");
        headerRow.createCell(4).setCellValue("filial");
        headerRow.createCell(5).setCellValue("serial");

        for (Object[] entidade : listaEntidades) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue((String) entidade[0]); // nome_computador
            row.createCell(1).setCellValue((String) entidade[1]); // nome_usuario
            row.createCell(2).setCellValue((String) entidade[2]); // endereco_mac
            row.createCell(3).setCellValue((String) entidade[3]); // nome
            row.createCell(4).setCellValue((String) entidade[4]); // filial
            row.createCell(5).setCellValue((String) entidade[5]); // serial
        }

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + nomeArquivo + "\"");

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();

        outputStream.close();

    }

    @Override
    public void exportNotebooksSemVinculoToExcel(HttpServletResponse response) throws IOException {
        List<Computadores> listaEntidades = computadoresRepository.findAllByUserAtualIsNull();

        String nomeArquivo = "relatorio_computadores.xlsx";
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("relatorio");

        int rowNum = 0;
        Row headerRow = sheet.createRow(rowNum++);
        headerRow.createCell(0).setCellValue("nome_computador");
        headerRow.createCell(1).setCellValue("nome_usuario");
        headerRow.createCell(2).setCellValue("endereco_mac");
        headerRow.createCell(3).setCellValue("marca");
        headerRow.createCell(4).setCellValue("modelo");
        headerRow.createCell(5).setCellValue("processador");
        headerRow.createCell(6).setCellValue("status");
        headerRow.createCell(7).setCellValue("serial");

        for (Computadores entidade : listaEntidades) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(entidade.getNomeComputador()); // nome_computador
            row.createCell(1).setCellValue(entidade.getNomeUsuario()); // nome_usuario
            row.createCell(2).setCellValue(entidade.getEnderecoMac()); // endereco_mac
            row.createCell(3).setCellValue(entidade.getMarca()); // marca
            row.createCell(4).setCellValue(entidade.getModelo()); // marca
            row.createCell(5).setCellValue(entidade.getProcessador()); // marca
            row.createCell(6).setCellValue(entidade.getStatus()); // nome
            row.createCell(7).setCellValue(entidade.getSerial()); // filial
        }

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + nomeArquivo + "\"");

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();

        outputStream.close();
    }

}

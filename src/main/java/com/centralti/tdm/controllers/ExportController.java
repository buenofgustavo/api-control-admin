package com.centralti.tdm.controllers;

import com.centralti.tdm.services.servicesinterface.ExportService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/export")
public class ExportController {
    @Autowired
    private ExportService exportService;

    @GetMapping("/ativos/{localizacao}/{atualizadoPor}")
    public ResponseEntity<?> exportToExcel(HttpServletResponse response,
                                                @PathVariable String localizacao,
                                                @PathVariable String atualizadoPor) throws IOException
    {
        System.out.println(localizacao + ' ' + atualizadoPor);
        exportService.exportAtivosToExcel(response, localizacao, atualizadoPor);
        return ResponseEntity.status(HttpStatus.OK).body("Exportação para Excel iniciada com sucesso: " + localizacao + ", " + atualizadoPor);

    }

    @GetMapping("/notebooks/{filial}")
    public ResponseEntity<?> exportNotebooksToExcel(HttpServletResponse response,
                                           @PathVariable String filial
                                           ) throws IOException
    {
        System.out.println(filial);
        exportService.exportNotebooksToExcel(response, filial);
        return ResponseEntity.status(HttpStatus.OK).body("Exportação para Excel iniciada com sucesso: " + filial);

    }

    @GetMapping("/notebooks-inativos")
    public ResponseEntity<?> exportNotebooksSemVinculoToExcel(HttpServletResponse response) throws IOException
    {
        exportService.exportNotebooksSemVinculoToExcel(response);
        return ResponseEntity.status(HttpStatus.OK).body("Exportação para Excel iniciada com sucesso" );
    }

}

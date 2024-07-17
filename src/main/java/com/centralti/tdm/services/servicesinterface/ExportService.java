package com.centralti.tdm.services.servicesinterface;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface ExportService {

    public void exportAtivosToExcel(HttpServletResponse response, String localizacao, String atualizadoPor) throws IOException;

}

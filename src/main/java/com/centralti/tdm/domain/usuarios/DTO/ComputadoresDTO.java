package com.centralti.tdm.domain.usuarios.DTO;

import com.centralti.tdm.domain.usuarios.entidades.Computadores;

public record ComputadoresDTO (

    String id,

    String NomeUsuario,

    String NomeComputador,

    String Localizacao,

    String MemoriaRAM,

    String CapacidadeArmazenamento,

    String marca,

    String modelo,

    String processador,

    String SistemaOperacional,

    String makroInstalado,

    String versaoMakro,

    String EnderecoMAC

) {
    public ComputadoresDTO(Computadores computadores){
            this(
                    computadores.getId(),computadores.getNomeUsuario(), computadores.getNomeComputador(),
                    computadores.getLocalizacao(), computadores.getMemoriaRAM(), computadores.getCapacidadeArmazenamento(),
                    computadores.getMarca(), computadores.getModelo(), computadores.getProcessador(), computadores.getSistemaOperacional(),
                    computadores.getMakroInstalado(), computadores.getVersaoMakro(), computadores.getEnderecoMAC()
            );
        }
    }

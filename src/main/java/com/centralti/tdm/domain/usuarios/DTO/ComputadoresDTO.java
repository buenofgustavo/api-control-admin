package com.centralti.tdm.domain.usuarios.DTO;

import com.centralti.tdm.domain.usuarios.entidades.Computadores;

public record ComputadoresDTO (

    String id,

    String nomeUsuario,

    String nomeComputador,

    String localizacao,

    String memoriaRam,

    String capacidadeArmazenamento,

    String marca,

    String modelo,

    String processador,

    String sistemaOperacional,

    String makroInstalado,

    String versaoMakro,

    String enderecoMac,

    String userAtual,

    String lastUser,

    String nomeUserAtual,

    String nomeLastUser

) {
    public ComputadoresDTO(Computadores computadores){
            this(
                    computadores.getId(),computadores.getNomeUsuario(), computadores.getNomeComputador(),
                    computadores.getLocalizacao(), computadores.getMemoriaRam(), computadores.getCapacidadeArmazenamento(),
                    computadores.getMarca(), computadores.getModelo(), computadores.getProcessador(), computadores.getSistemaOperacional(),
                    computadores.getMakroInstalado(), computadores.getVersaoMakro(), computadores.getEnderecoMac(), computadores.getUserAtual(),
                    computadores.getLastUser(), computadores.getNomeUserAtual(), computadores.getNomeLastUser()
            );
        }
    }

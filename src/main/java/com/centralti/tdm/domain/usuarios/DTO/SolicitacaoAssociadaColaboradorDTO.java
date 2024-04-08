package com.centralti.tdm.domain.usuarios.DTO;

import com.centralti.tdm.domain.usuarios.entidades.DadosColaboradores;
import com.centralti.tdm.domain.usuarios.entidades.SolicitacaoAssociadaColaborador;

public record SolicitacaoAssociadaColaboradorDTO(

        Integer id,

        String usuario_solicitante,

        String nome,

        String numero,

        String cpf,

        String filial,

        String cargo,

        String departamento,

        String atualizado_por,

        String status,

        String tipo

) {

    public SolicitacaoAssociadaColaboradorDTO(SolicitacaoAssociadaColaborador solicitacaoAssociadaColaborador){
        this(
                solicitacaoAssociadaColaborador.getId(),solicitacaoAssociadaColaborador.getUsuario_solicitante(), solicitacaoAssociadaColaborador.getNome(),
                solicitacaoAssociadaColaborador.getNumero(), solicitacaoAssociadaColaborador.getCpf(), solicitacaoAssociadaColaborador.getFilial(),
                solicitacaoAssociadaColaborador.getCargo(), solicitacaoAssociadaColaborador.getDepartamento(),
                solicitacaoAssociadaColaborador.getAtualizado_por(), solicitacaoAssociadaColaborador.getStatus(), solicitacaoAssociadaColaborador.getTipo()
        );
    }

}

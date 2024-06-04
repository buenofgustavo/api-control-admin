package com.centralti.tdm.domain.usuarios.entidades;

import com.centralti.tdm.domain.usuarios.DTO.ChatChamadosDTO;
import com.centralti.tdm.domain.usuarios.DTO.ChatSolicitacoesColaboradoresDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Table(name = "chat_chamados")
@Entity(name = "chat_chamados")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class ChatChamados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name="message")
    private String message;

    @Column(name="numero_chamado")
    private String numeroChamado;

    @Column(name="user_vinculado")
    private String userVinculado;

    @Column(name = "nome_user")
    private String nomeUser;

    @Column(name = "arquivo")
    private String arquivo;

    @Column(name="datahora")
    private LocalDateTime datahora;

    public ChatChamados(ChatChamadosDTO chatChamadosDTO){
        this.message = chatChamadosDTO.message();
        this.numeroChamado = chatChamadosDTO.numeroChamado();
        this.nomeUser = chatChamadosDTO.nomeUser();
        this.arquivo = chatChamadosDTO.arquivo();
    }

}

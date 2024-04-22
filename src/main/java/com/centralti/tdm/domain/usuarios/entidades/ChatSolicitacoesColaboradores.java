package com.centralti.tdm.domain.usuarios.entidades;

import com.centralti.tdm.domain.usuarios.DTO.ChatSolicitacoesColaboradoresDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Table(name = "chat_solicitacoes_colaboradores")
@Entity(name = "chat_solicitacoes_colaboradores")
@Getter

@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class ChatSolicitacoesColaboradores {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name="message")
        private String message;

        @Column(name="id_vinculado")
        private String idVinculado;

        @Column(name="user_vinculado")
        private String userVinculado;

        @Column(name = "nome_user")
        private String nomeUser;

        @Column(name="datahora")
        private LocalDateTime datahora;

        public ChatSolicitacoesColaboradores(ChatSolicitacoesColaboradoresDTO ChatSolicitacoesColaboradoresDTO){
            this.message = ChatSolicitacoesColaboradoresDTO.message();
            this.idVinculado = ChatSolicitacoesColaboradoresDTO.idVinculado();
            this.nomeUser = ChatSolicitacoesColaboradoresDTO.nomeUser();
        }

}

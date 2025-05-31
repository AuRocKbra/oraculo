package com.br.oraculo.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TB_COMENTARIOS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comentario implements Serializable {
    @Serial
    private static final long serialVersionUID = 149834949L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_COMENTARIO")
    private Integer codigoComentario;

    @Column(name = "DS_COMENTARIO")
    private String comentarioUsuario;

    @Column(name = "DT_COMENTARIO")
    private Date dataComentario;

    @ManyToOne
    @JoinColumn(name = "CD_TICKET")
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "CD_USUARIO")
    private Usuario usuario;

    public Comentario(String comentario, Ticket ticket, Usuario usuario){
        this.comentarioUsuario = comentario;
        this.usuario = usuario;
        this.ticket = ticket;
    }
}

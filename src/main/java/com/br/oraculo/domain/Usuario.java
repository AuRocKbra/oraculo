package com.br.oraculo.domain;

import com.br.oraculo.utils.CriptografiaEHash;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TB_USUARIO")
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements Serializable {

    @Serial
    private static final long serialVersionUID = 43435201L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_USUARIO")
    private Integer codigoUsuario;

    @Column(name = "NM_USUARIO")
    private String nomeUsuario;

    @Column(name = "NM_LOGIN")
    private String loginUsuario;

    @Column(name = "DS_SENHA")
    private String senhaUsuario;

    @Column(name = "FL_ATIVO")
    private Boolean statusUsuario;

    @Column(name = "FL_BLOQUEADO")
    private Boolean statusBloqueado;

    @Column(name = "DT_CADASTRO")
    private Date dataCadastro;

    @Column(name = "DT_ATUALIZACAO")
    private Date dataAtualização;

    public Usuario(String nomeUsuario, String loginUsuario, String senhaUsuario){
        this.nomeUsuario = nomeUsuario;
        this.loginUsuario = loginUsuario;
        this.senhaUsuario = CriptografiaEHash.calculaHashSenhaHexaDecimal(senhaUsuario);
        this.statusUsuario = Boolean.TRUE;
        this.statusBloqueado = Boolean.FALSE;
        this.dataCadastro = new Date();
    }
}

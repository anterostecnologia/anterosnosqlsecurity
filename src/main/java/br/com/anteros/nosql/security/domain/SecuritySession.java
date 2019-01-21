package br.com.anteros.nosql.security.domain;

import java.io.Serializable;
import java.util.Date;

import br.com.anteros.nosql.persistence.metadata.annotations.Entity;
import br.com.anteros.nosql.persistence.metadata.annotations.Id;
import br.com.anteros.nosql.persistence.metadata.annotations.Property;
import br.com.anteros.nosql.persistence.metadata.annotations.Reference;
import br.com.anteros.nosql.persistence.metadata.annotations.Temporal;
import br.com.anteros.nosql.persistence.metadata.annotations.type.TemporalType;

/**
 * 
 * @author eduardogreco
 *
 */

@Entity(value = "SEGURANCASESSAO")
public class SecuritySession implements Serializable {

	/*
	 * Identificação do Objeto de sessão
	 */
	@Id
	private Long id;

	/*
	 * Id. da sessão no banco de dados
	 */
	@Property(value = "idSessaoBancoDados", required = true)
	private Long idSessaoBancoDados;

	/*
	 * Usuário da sessão
	 */
	@Reference(lazy=true, required=true, value="usuario")
	private Security usuario;

	/*
	 * Data/hora do login da sessão
	 */
	@Temporal(type=TemporalType.DATE_TIME, value="dhLoginSessao", required=true)
	private Date dhLoginSessao;

	/*
	 * Data/hora do logout da sessão
	 */
	@Temporal(type=TemporalType.DATE_TIME, value="dhLogoutSessao", required=true)
	private Date dhLogoutSessao;

	/*
	 * Endereço IP
	 */
	@Property(value = "enderecoIP", required = true)
	private String enderecoIP;

	/*
	 * Nome do sistema
	 */
	@Property(value = "sistema", required = true)
	private String sistema;

	/*
	 * Versão do sistema
	 */
	@Property(value = "versao", required = true)
	private String versao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdSessaoBancoDados() {
		return idSessaoBancoDados;
	}

	public void setIdSessaoBancoDados(Long idSessaoBancoDados) {
		this.idSessaoBancoDados = idSessaoBancoDados;
	}

	public Security getUsuario() {
		return usuario;
	}

	public void setUsuario(Security usuario) {
		this.usuario = usuario;
	}

	public Date getDhLoginSessao() {
		return dhLoginSessao;
	}

	public void setDhLoginSessao(Date dhLoginSessao) {
		this.dhLoginSessao = dhLoginSessao;
	}

	public Date getDhLogoutSessao() {
		return dhLogoutSessao;
	}

	public void setDhLogoutSessao(Date dhLogoutSessao) {
		this.dhLogoutSessao = dhLogoutSessao;
	}

	public String getEnderecoIP() {
		return enderecoIP;
	}

	public void setEnderecoIP(String enderecoIP) {
		this.enderecoIP = enderecoIP;
	}

	public String getSistema() {
		return sistema;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

}

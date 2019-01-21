/*******************************************************************************
 * Copyright 2012 Anteros Tecnologia
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package br.com.anteros.nosql.security.domain;

import java.io.Serializable;
import java.util.Set;

import br.com.anteros.nosql.persistence.metadata.annotations.Cascade;
import br.com.anteros.nosql.persistence.metadata.annotations.Entity;
import br.com.anteros.nosql.persistence.metadata.annotations.Id;
import br.com.anteros.nosql.persistence.metadata.annotations.Index;
import br.com.anteros.nosql.persistence.metadata.annotations.IndexField;
import br.com.anteros.nosql.persistence.metadata.annotations.Indexes;
import br.com.anteros.nosql.persistence.metadata.annotations.Property;
import br.com.anteros.nosql.persistence.metadata.annotations.Reference;
import br.com.anteros.nosql.persistence.metadata.annotations.type.CascadeType;
import br.com.anteros.security.store.domain.IAction;

/**
 * Seguranca
 * 
 * Classe abstrata que vai representar qualquer objeto que necessite de controle
 * de acesso a determinados Recursos/Ações dentro de um Sistema.
 * 
 * @author Edson Martins edsonmartins2005@gmail.com
 */
@Entity(value = "SEGURANCA")
@Indexes({ @Index(name = "IX_SEGURANCA_ID_HORARIO", fields = { @IndexField("horario") }),
		@Index(name = "SEGURANCA_PERFIL", fields = { @IndexField("perfil") }),
		@Index(name = "UK_SEGURANCA_LOGIN", fields = { @IndexField("login") }) })
public class Security implements Serializable {

	public static final String SECURITY_PACKAGE = "br.com.anteros.security.model";
	/*
	 * Identificação do Objeto de Segurança
	 */
	@Id
	private String id;

	@Property(value = "nome", required = true)
	private String nome;

	@Property(value = "descricao", required = true)
	private String descricao;

	@Property(value = "tpSeguranca", required = true)
	private String tipoSeguranca;

	/*
	 * Lista de Ações permitidas para um determinado objeto de Segurança.
	 */
	@Reference(lazy = true, value = "acoes")
	private Set<IAction> acoes;

	/*
	 * Lista de horários de acesso permitidos para um determinado objeto de
	 * Segurança.
	 */
	@Reference(lazy = true, mappedBy = "seguranca", value = "horarioAcessoSistema")
	@Cascade(values = { CascadeType.DELETE_ORPHAN })
	private Set<SecurityAccess> horarioAcessoSistema;

	/*
	 * Email do usuário
	 */
	@Property(value = "email")
	private String email;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Set<IAction> getActionList() {
		return acoes;
	}

	public void setAcoes(Set<IAction> acoes) {
		this.acoes = acoes;
	}

	public Set<SecurityAccess> getHorarioAcessoSistema() {
		return horarioAcessoSistema;
	}

	public void setHorarioAcessoSistema(Set<SecurityAccess> horarioAcessoSistema) {
		this.horarioAcessoSistema = horarioAcessoSistema;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTipoSeguranca() {
		return tipoSeguranca;
	}

	public void setTipoSeguranca(String tipoSeguranca) {
		this.tipoSeguranca = tipoSeguranca;
	}

}

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
import java.util.ArrayList;
import java.util.List;

import br.com.anteros.nosql.persistence.metadata.annotations.Cascade;
import br.com.anteros.nosql.persistence.metadata.annotations.Entity;
import br.com.anteros.nosql.persistence.metadata.annotations.Id;
import br.com.anteros.nosql.persistence.metadata.annotations.Index;
import br.com.anteros.nosql.persistence.metadata.annotations.IndexField;
import br.com.anteros.nosql.persistence.metadata.annotations.IndexOptions;
import br.com.anteros.nosql.persistence.metadata.annotations.Indexes;
import br.com.anteros.nosql.persistence.metadata.annotations.Property;
import br.com.anteros.nosql.persistence.metadata.annotations.Reference;
import br.com.anteros.nosql.persistence.metadata.annotations.type.CascadeType;
import br.com.anteros.security.store.domain.IAction;
import br.com.anteros.security.store.domain.IResource;

/**
 * Recurso
 * 
 * Classe que representa o objeto que será controlado o acesso pelo usuário dentro de um sistema.
 * Ex: Formulário, relatório, etc. Terá uma lista de ações específicas que serão atribuídas posteriormente
 * a qualquer objeto que extenda Seguranca como um Papel, um Usuario ou um Grupo.
 * 
 * @author Edson Martins edsonmartins2005@gmail.com
 */
@Entity(value = "SEGURANCARECURSO")
@Indexes(value = {
		@Index(name = "UK_SEGURANCARECURSO_NOME_RECUR", options= @IndexOptions( unique = true),
				fields = {@IndexField(value="sistema"), @IndexField(value="nomeRecurso")})})
public class Resource implements Serializable, IResource {

	/*
	 * Identificação do Recurso
	 */
	@Id
	private String id;

	/*
	 * Nome do Recurso
	 */
	@Property(value = "nomeRecurso")
	private String nome;

	/*
	 * Descrição do Recurso
	 */
	@Property(value = "descricaoRecurso")
	private String descricao;

	/*
	 * Lista de Ações que serão controladas acesso para um Recurso.
	 */
	@Reference(mappedBy = "recurso", lazy=true)
	@Cascade(values = CascadeType.DELETE_ORPHAN)
	private List<IAction> acoes;

	/*
	 * Sistema a qual pertence o Recurso.
	 */
	@Reference(lazy=true, value="sistema")
	private System sistema;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getResourceName() {
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

	public List<IAction> getActionList() {
		if (acoes==null)
			acoes = new ArrayList<IAction>();
		return acoes;
	}

	public void setAcoes(List<IAction> acoes) {
		this.acoes = acoes;
	}

	public System getSystem() {
		return sistema;
	}

	public void setSistema(System sistema) {
		this.sistema = sistema;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sistema == null) ? 0 : sistema.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Resource other = (Resource) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sistema == null) {
			if (other.sistema != null)
				return false;
		} else if (!sistema.equals(other.sistema))
			return false;
		return true;
	}

	@Override
	public IResource addAction(IAction action) {
		getActionList().add(action);
		return this;
	}

	@Override
	public String getResourceId() {
		return id;
	}

}

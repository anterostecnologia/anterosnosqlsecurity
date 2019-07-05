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

import br.com.anteros.nosql.persistence.metadata.annotations.Entity;
import br.com.anteros.nosql.persistence.metadata.annotations.Id;
import br.com.anteros.nosql.persistence.metadata.annotations.Index;
import br.com.anteros.nosql.persistence.metadata.annotations.IndexField;
import br.com.anteros.nosql.persistence.metadata.annotations.IndexOptions;
import br.com.anteros.nosql.persistence.metadata.annotations.Indexes;
import br.com.anteros.nosql.persistence.metadata.annotations.Property;
import br.com.anteros.nosql.persistence.metadata.annotations.Reference;
import br.com.anteros.security.store.domain.ISystem;

/**
 * Sistema
 * 
 * Classe que representa um Sistema que necessite de controle de acesso de
 * Recursos/Ações.
 * 
 * @author Edson Martins edsonmartins2005@gmail.com
 */
@Entity(value="SEGURANCASISTEMA")
@Indexes(value = {
		@Index(name = "UK_SEGURANCASISTEMA_NOME_SIST", fields = {@IndexField("nomeSistema")}, options=@IndexOptions(unique = true)) })
public class System implements Serializable, ISystem {

	/*
	 * Identificação do Sistema
	 */
	@Id
	private String id;

	/*
	 * Nome do Sistema
	 */
	@Property(value = "nome",  required = true)
	private String nome;

	/*
	 * Descrição do Sistema
	 */
	@Property(value = "DS_SISTEMA", required = true)
	private String descricao;

	/*
	 * Versão mínima do Sistema
	 */
	@Property(value = "VERSAO_MINIMA", required = true)
	private String versaoMinima;

	/*
	 * Lista de Recursos que pertencem a um Sistema.
	 */
	@Reference(lazy=true,mappedBy = "sistema", value="recursos")
	private Set<Resource> recursos;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSystemName() {
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

	public String getVersaoMinima() {
		return versaoMinima;
	}

	public void setVersaoMinima(String versaoMinima) {
		this.versaoMinima = versaoMinima;
	}

	public Set<Resource> getRecursos() {
		return recursos;
	}

	public void setRecursos(Set<Resource> recursos) {
		this.recursos = recursos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((versaoMinima == null) ? 0 : versaoMinima.hashCode());
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
		System other = (System) obj;
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
		if (versaoMinima == null) {
			if (other.versaoMinima != null)
				return false;
		} else if (!versaoMinima.equals(other.versaoMinima))
			return false;
		return true;
	}

	@Override
	public String getSystemId() {
		return id;
	}

}

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

import br.com.anteros.nosql.persistence.metadata.annotations.Entity;
import br.com.anteros.nosql.persistence.metadata.annotations.Id;
import br.com.anteros.nosql.persistence.metadata.annotations.Property;

/**
 * Terminal
 * 
 * Classe que representa o cadastro dos terminais de Acesso ex: computador, coletor etc
 * 
 * @author Edson Martins edsonmartins2005@gmail.com
 */

@Entity(value="SEGURANCATERMINALACESSO")
public class Terminal implements Serializable {
	/*
	 * Identificador do terminal de acesso
	 */
	@Id
	private Long id;
	
	/*
	 * Nome do terminal de acesso
	 */
	@Property(value="nome", required=true)
	private String nome;
	
	/*
	 * Descrição do terminal de acesso
	 */
	@Property(value="descricao", required=true)
	private String descricao;
	
	/*
	 * Endereço IP do terminal de acesso
	 */
	@Property(value="enderecoIP", required=true)
	private String enderecoIP;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEnderecoIP() {
		return enderecoIP;
	}

	public void setEnderecoIP(String enderecoIP) {
		this.enderecoIP = enderecoIP;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

}

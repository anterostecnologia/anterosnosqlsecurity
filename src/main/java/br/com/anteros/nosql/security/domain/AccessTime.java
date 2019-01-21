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
import java.util.List;

import br.com.anteros.nosql.persistence.metadata.annotations.Entity;
import br.com.anteros.nosql.persistence.metadata.annotations.Id;
import br.com.anteros.nosql.persistence.metadata.annotations.Property;
import br.com.anteros.nosql.persistence.metadata.annotations.Reference;


/**
 * HorarioAcesso
 * 
 * Classe que representa Horário de Acesso que será permitido ao Usuário utilizar o sistema.
 * 
 * @author Edson Martins edsonmartins2005@gmail.com
 */
@Entity(value="SEGURANCAHORARIO")
public class AccessTime implements Serializable {

	/*
	 * Identificação
	 */
	@Id
	private Long id;

	/*
	 * Descrição do horário de acesso
	 */
	@Property(value = "DS_HORARIO", required=true)
	private String descricao;

	/*
	 * Intervalos do horário de acesso
	 */
	@Reference(mappedBy = "horarioAcesso", value="intervalos")
	private List<AccessTimeInterval> intervalos;

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

	public List<AccessTimeInterval> getIntervalos() {
		return intervalos;
	}

	public void setIntervalos(List<AccessTimeInterval> intervalos) {
		this.intervalos = intervalos;
	}
}

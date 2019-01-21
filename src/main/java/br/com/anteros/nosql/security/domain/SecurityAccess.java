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
import br.com.anteros.nosql.persistence.metadata.annotations.Reference;


/**
 *SegurancaHorarioAcesso
 *
 * Classe que representa os terminais e sistemas que um usuário pode acessar em um de
 * determinado horário de acesso
 * 
 * @author Edson Martins edsonmartins2005@gmail.com
 */

@Entity(value = "SEGURANCAACESSO")
public class SecurityAccess implements Serializable {

	/*
	 * Identificador do segurança horário de acesso
	 */
	@Id
	private Long id;

	/*
	 * Identificador do horário de acesso
	 */
	@Reference(lazy=true, required=true, value="horarioAcesso")
	private AccessTime horarioAcesso;

	/*
	 * Identificador do segurança
	 */
	@Reference(lazy=true, required=true, value="seguranca")
	private Security seguranca;

	/*
	 * Terminal de acesso
	 */
	@Reference(lazy=true, required=true, value="terminal")
	private Terminal terminal;

	/*
	 * Identificador do sistema
	 */
	@Reference(lazy=true, required=true, value="sistema")
	private System sistema;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Security getSeguranca() {
		return seguranca;
	}

	public void setSeguranca(Security seguranca) {
		this.seguranca = seguranca;
	}

	public AccessTime getHorarioAcesso() {
		return horarioAcesso;
	}

	public void setHorarioAcesso(AccessTime horarioAcesso) {
		this.horarioAcesso = horarioAcesso;
	}

	public Terminal getTerminal() {
		return terminal;
	}

	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}

	public System getSistema() {
		return sistema;
	}

	public void setSistema(System sistema) {
		this.sistema = sistema;
	}

}

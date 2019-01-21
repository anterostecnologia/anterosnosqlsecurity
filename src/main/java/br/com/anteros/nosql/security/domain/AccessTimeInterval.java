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
import br.com.anteros.nosql.persistence.metadata.annotations.Reference;

/**
 * HorarioAcessoIntervalo
 * 
 * Classe que representa o intervalo de Horário de Acesso que será permitido ao Usuário utilizar o sistema.
 * 
 * @author Edson Martins edsonmartins2005@gmail.com
 */
@Entity(value="SEGURANCAHORARIOINTERVALO")
public class AccessTimeInterval implements Serializable {

	
	/*
	 * Identificação
	 */
	@Id
	private Long id;
	
	/*
	 * Horário de acesso a qual pertence o intervalo
	 */
	@Reference(lazy=true, value="horarioAcesso")
	private AccessTime horarioAcesso;

	/*
	 * Dia da semana
	 */
	@Property(value = "diaSemana")
	private Long diaDaSemana;

	/*
	 * Hora Inicial
	 */
	@Property(value = "horaInicial")
	private String horaInicial;

	/*
	 * Hora Final
	 */
	@Property(value = "horaFinal")
	private String horaFinal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDiaDaSemana() {
		return diaDaSemana;
	}

	public void setDiaDaSemana(Long diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
	}

	
	public AccessTime getHorarioAcesso() {
		return horarioAcesso;
	}

	public void setHorarioAcesso(AccessTime horarioAcesso) {
		this.horarioAcesso = horarioAcesso;
	}

	public String getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(String horaInicial) {
		this.horaInicial = horaInicial;
	}

	public String getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}

}

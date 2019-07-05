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

import java.util.List;

import br.com.anteros.nosql.persistence.metadata.annotations.DiscriminatorValue;
import br.com.anteros.nosql.persistence.metadata.annotations.Entity;
import br.com.anteros.nosql.persistence.metadata.annotations.Property;
import br.com.anteros.nosql.persistence.metadata.annotations.Reference;
import br.com.anteros.nosql.persistence.metadata.annotations.Transient;
import br.com.anteros.persistence.metadata.annotation.Column;
import br.com.anteros.persistence.metadata.annotation.Lob;
import br.com.anteros.security.store.domain.IProfile;
import br.com.anteros.security.store.domain.IUser;

/**
 * Usuario
 * 
 * Classe que representa um usuário dentro de um Sistema. Pode ser uma Pessoa ou até mesmo um usuário virtual como
 * o próprio Sistema.
 * 
 * @author Edson Martins edsonmartins2005@gmail.com
 */

@Entity(value="SEGURANCA")
@DiscriminatorValue(value = "USUARIO")
public class User extends Security implements IUser {

	/*
	 * Login do usuário
	 */
	@Property(value = "login")
	private String login;

	/*
	 * Senha do usuário
	 */
	@Property(value = "senha")
	private String senha;

	/*
	 * O usuário deve alterar a senha no próximo Login?
	 */
	@Property(value = "alterarSenhaProximoLogin", required = true, defaultValue = "false")
	private Boolean alterarSenhaProximoLogin;

	/*
	 * O usuário pode alterar a senha?
	 */
	@Property(value = "permiteAlterarSenha", required = true, defaultValue = "false")
	private Boolean permiteAlterarSenha;

	/*
	 * Permite o usuário efetuar vários logins em um mesmo sistema?
	 */
	@Property(value = "permiteMultiplosLogins", required = true, defaultValue = "false")
	private Boolean permiteMultiplosLogins;

	/*
	 * A senha do usuário nunca expira?
	 */
	@Property(value = "senhaNuncaExpira", required = true, defaultValue = "false")
	private Boolean senhaNuncaExpira;

	/*
	 * Conta do usuário está desativada?
	 */
	@Property(value = "contaDesativada", required = true, defaultValue = "false")
	private Boolean contaDesativada=Boolean.FALSE;

	/*
	 * Conta do usuário está bloqueada?
	 */
	@Property(value = "contaBloqueada", required = true, defaultValue = "false")
	private Boolean contaBloqueada=Boolean.FALSE;
	
	
	@Property(value = "boHorarioLivre", required = true, defaultValue = "false")
	private Boolean boHorarioLivre;

	@Property(value = "boAdministrador", required = true, defaultValue = "false")
	private Boolean boAdministrador;

	/*
	 * Horário de acesso do usuário
	 */
	@Reference(lazy=true, value="horarioAcesso")
	private AccessTime horarioAcesso;

	/*
	 * Grupos que o usuário é membro
	 */
	@Reference(lazy=true, value="grupos")
	private List<Group> grupos;

	/*
	 * Perfil (papel) do usuário dentro do sistema
	 */
	@Reference(lazy=true, value="perfil")
	private Profile perfil;
	
	@Property(value="avatar")
	private String avatar;

	public Boolean getAlterarSenhaProximoLogin() {
		return alterarSenhaProximoLogin;
	}

	public void setAlterarSenhaProximoLogin(Boolean alterarSenhaProximoLogin) {
		this.alterarSenhaProximoLogin = alterarSenhaProximoLogin;
	}

	public Boolean getPermiteAlterarSenha() {
		return permiteAlterarSenha;
	}

	public void setPermiteAlterarSenha(Boolean permiteAlterarSenha) {
		this.permiteAlterarSenha = permiteAlterarSenha;
	}

	public Boolean getSenhaNuncaExpira() {
		return senhaNuncaExpira;
	}

	public void setSenhaNuncaExpira(Boolean senhaNuncaExpira) {
		this.senhaNuncaExpira = senhaNuncaExpira;
	}

	public boolean isInactiveAccount() {
		return contaDesativada;
	}

	public void setContaDesativada(Boolean contaDesativada) {
		this.contaDesativada = contaDesativada;
	}

	public boolean isBlockedAccount() {
		return contaBloqueada;
	}

	public void setContaBloqueada(Boolean contaBloqueada) {
		this.contaBloqueada = contaBloqueada;
	}

	public Boolean getPermiteMultiplosLogins() {
		return permiteMultiplosLogins;
	}

	public void setPermiteMultiplosLogins(Boolean permiteMultiplosLogins) {
		this.permiteMultiplosLogins = permiteMultiplosLogins;
	}

	public String getPassword() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	// public HorarioAcesso getHorarioAcesso() {
	// return horarioAcesso;
	// }
	//
	// public void setHorarioAcesso(HorarioAcesso horarioAcesso) {
	// this.horarioAcesso = horarioAcesso;
	// }

	public List<Group> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Group> grupos) {
		this.grupos = grupos;
	}

	public Profile getProfile() {
		return perfil;
	}

	public void setPerfil(Profile perfil) {
		this.perfil = perfil;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Transient
	public boolean isExpired() {
		return (contaBloqueada || contaDesativada);
	}
	
	public Boolean getBoHorarioLivre() {
		return boHorarioLivre;
	}

	public void setBoHorarioLivre(Boolean boHorarioLivre) {
		this.boHorarioLivre = boHorarioLivre;
	}

	public boolean isAdministrator() {
		return boAdministrador;
	}

	public void setBoAdministrador(Boolean boAdministrador) {
		this.boAdministrador = boAdministrador;
	}

	public AccessTime getHorarioAcesso() {
		return horarioAcesso;
	}

	public void setHorarioAcesso(AccessTime horarioAcesso) {
		this.horarioAcesso = horarioAcesso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
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
		User other = (User) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}

	@Override
	public boolean isPasswordNeverExpire() {
		return senhaNuncaExpira;
	}

	@Override
	public IProfile getUserProfile() {
		return (IProfile) perfil;
	}

	@Override
	public String getUserId() {
		return getId()+"";
	}

	@Override
	public String getAvatar() {
		return avatar;
	}



}
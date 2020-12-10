package org.generation.BlogPessoal.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.JoinColumn;


@Entity //expecifica que é uma entidade, uma tabela
public class Usuario implements UserDetails,  Serializable {
    
	//previne erros de versões sobrepostas
	private static final long serialVersionUID = 1L;

	//atributos
	@Id //identificador da tabela id
	private String login;
	private String nomeCompleto;
	private String senha;
	
	@ManyToMany //indica que tabela é muito pra muito
	@JoinTable(name = "usuarios_roles", joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "login"), 
	inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "nomeRole"))
	private List<Role> roles;

	//segurança
	@Override //Ele é uma forma de garantir que você está sobrescrevendo um método e não criando um novo.
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.roles;

	}
	@Override //Ele é uma forma de garantir que você está sobrescrevendo um método e não criando um novo.
	public String getPassword() {
		return this.senha;   	}
	@Override
	public String getUsername() {
		return this.login;  
		}

	
	@Override
	//indica se a conta do usuario exirou
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	//indica se o usuario esta bloqueado ou desbloqueado
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	//indica se a credencial esta expirada
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	//indica se esta habilitado ou desabilitado
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	//getters and setters encapsula metodos
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
	
	
	

}

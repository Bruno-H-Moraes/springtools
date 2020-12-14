package org.generation.blogPessoal.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity // <--- Anotação para criar a table
public class Usuario implements UserDetails, Serializable {
    
	//previne erros de versões sobrepostas
	private static final long serialVersionUID = 1L;

	//Atributos----------------------------------------------------------------------------------------------
	@Id
	private String login;
	private String nomeCompleto;
	private String senha;

	//Relação muito para muitos: Ajuntando coluna de tabelas diferentes.
	@ManyToMany
	@JoinTable(name = "usuarios_roles", joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "login"),                    
	                                    inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "nomeRole"))
	private List<Role> roles;

	//Segurança----------------------------------------------------------------------------------------------
	
	//Anotação para suobreposição de métodos
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.roles;    }
	@Override
	public String getPassword() {
		return this.senha;   	}
	@Override
	public String getUsername() {
		return this.login;  	}
	@Override
	
	
	//Metodos de segurança do usuário
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;   	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;    	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true; 	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	public void setPassword(String encode) {
		// TODO Auto-generated method stub

		
		
		//Getters and Setters
	}

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

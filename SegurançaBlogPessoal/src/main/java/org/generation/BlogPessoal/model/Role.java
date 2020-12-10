package org.generation.BlogPessoal.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

@Entity //expecifica que é uma entidade, uma tabela
//classe que confere a autoridade 
public class Role implements GrantedAuthority {
	
	@Id //identificador
	private String nomeRole;
	
	@ManyToMany(mappedBy = "roles") //indica que a tabela é muito pra muitos
	private List<Usuario> usuarios;

	@Override //Ele é uma forma de garantir que você está sobrescrevendo um método e não criando um novo.
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.nomeRole;
	}
	//getters and setters // encapsula os metodos

	public String getNomeRole() {
		return nomeRole;
	}

	public void setNomeRole(String nomeRole) {
		this.nomeRole = nomeRole;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	

}

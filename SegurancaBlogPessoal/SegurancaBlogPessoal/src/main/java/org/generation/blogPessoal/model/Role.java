package org.generation.blogPessoal.model; //PACOTE 

//IMPORTS
import java.util.List; 
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import org.springframework.security.core.GrantedAuthority;


@Entity
public class Role implements GrantedAuthority { //IMPLEMENTA A CLASSE ROLE UM MÉTODO
	// GRANTEDAUTHORITY: TRANSFORMA EM UMA CLASSE COM PRIVILÉGIOS
	
	@Id
	private String nomeRole;
	
	@ManyToMany(mappedBy = "roles")//MANY TO MANY: FAZ O RELACIONAMENTO DE TABELAS(MATRIZ)
	//MAPPEDBY: DIZ DE ONDE IRÁ TRAZER A INFORMAÇÃO
	private List<Usuario> usuarios;

	@Override 
	public String getAuthority() {// GETAUTHORITY RETORNA OS PRIVILEGIOS
		// TODO Auto-generated method stub
		return this.nomeRole;

	}
	//GETTERS E SETTERS

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

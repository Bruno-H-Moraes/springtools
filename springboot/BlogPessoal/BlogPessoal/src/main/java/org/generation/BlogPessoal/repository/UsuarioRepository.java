package org.generation.BlogPessoal.repository;

import java.util.Optional;

import org.generation.BlogPessoal.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

//herandando da classe jpa
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	
	//metodo que puxa as informações do login
	public Optional<Usuario> findByUsuario(String usuario);

}

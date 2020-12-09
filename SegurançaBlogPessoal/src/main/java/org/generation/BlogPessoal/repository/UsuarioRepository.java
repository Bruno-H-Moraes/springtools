package org.generation.BlogPessoal.repository;

import org.generation.BlogPessoal.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{
	
	Usuario findByLogin(String login);

}

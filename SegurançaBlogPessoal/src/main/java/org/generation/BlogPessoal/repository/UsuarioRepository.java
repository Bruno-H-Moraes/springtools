package org.generation.BlogPessoal.repository;

import org.generation.BlogPessoal.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

//herandando da classe jpa
public interface UsuarioRepository extends JpaRepository<Usuario, String>{
	//metodo que puxa as informações do login
	Usuario findByLogin(String login);

}

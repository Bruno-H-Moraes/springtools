package org.generation.blogPessoal.repository;

import org.generation.blogPessoal.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,String>{
	Usuario findByLogin(String login);

}
//Metodo utilizado para a implementação do CRUD(cirar,ler,atualizar e deletar)


package org.generation.blogPessoal.repository;

import org.generation.blogPessoal.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

//Interface que herda de JPARepository <Classe da tabela, tipo do dado> e armazena os dados dentro do banco
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
	//Método para encontra o Usuário pelo ID 
	Usuario findByLogin(String login);

}

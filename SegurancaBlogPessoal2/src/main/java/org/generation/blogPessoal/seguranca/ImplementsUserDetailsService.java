package org.generation.blogPessoal.seguranca;

import javax.transaction.Transactional;

import org.generation.blogPessoal.model.Usuario;
import org.generation.blogPessoal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;


@Repository // Anotação para persistência dos métodos do reositório 
@Transactional // Anotação que faz transação de dados entre os banco de dados
public class ImplementsUserDetailsService implements UserDetailsService{ // Classe que implementa a interface UserDetailsService (Retornar os dados do usuário)

	@Autowired // Injeção de métodos e define a persistência da classe repository
	private UsuarioRepository usuarioRepository;
	
	@Override // --> Anotação que sobreescreve método
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException { // Método da interface UserDetailsService que recebe o login do user
		Usuario usuario = usuarioRepository.findByLogin(login);
		
		if(usuario == null){ // --> Caso o método não encontre a informação retorna uma mensagem
			throw new UsernameNotFoundException("Usuario(a) não encontrado(a)!");
		}
		return new User(usuario.getUsername(), usuario.getPassword(), true, true, true, true, usuario.getAuthorities()); // --> Retorna as informações do usuário como autenticada.
	}

}

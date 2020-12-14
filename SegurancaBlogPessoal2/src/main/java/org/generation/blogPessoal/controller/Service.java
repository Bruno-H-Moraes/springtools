package org.generation.blogPessoal.controller;
import org.generation.blogPessoal.model.Usuario;
import org.generation.blogPessoal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@org.springframework.stereotype.Service // --> Anotação para marcar a classe como um provedor de serviços
public class Service {

	@Autowired // Injeção de métodos e define a persistência da classe repository
	private UsuarioRepository repository;

	public Usuario CadastrarUsuario(Usuario usuario) { // --> Método de cadastro e encripitação das informações da tabela usuario
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(); // <-- Instância para codificação
		String senhaEncoder = encoder.encode(usuario.getSenha()); // <-- Encriptando as informções
		usuario.setSenha(senhaEncoder);// <-- Definindo a senha
		return repository.save(usuario);
	}
}
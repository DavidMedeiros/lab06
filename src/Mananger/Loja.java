/* 114211306 - David de Medeiros Souza: LAB 6- Turma 3 */

package Mananger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Exceptions.EntradaException;
import Usuario.Usuario;

public class Loja {

	private List<Usuario> listaDeUsuarios;

	public Loja() {
		this.listaDeUsuarios = new ArrayList<Usuario>();
	}

	/**
	 * Metodo utilizado para criar um usuario e adiciona-lo a lista de usuarios.
	 * 
	 * @param nome
	 *            Nome do usuario.
	 * @param login
	 *            login do usuario.
	 * @throws EntradaException
	 */

	public Usuario criaUsuario(String nome, String login) throws EntradaException {
		Usuario usuario = new Usuario(nome, login);
		listaDeUsuarios.add(usuario);
		
		return usuario;
	}

	/**
	 * Metodo para retorno da lista de usuarios.
	 * 
	 * @return List<Usuario> - Lista de usuarios.
	 */

	public List<Usuario> getListaDeUsuarios() {
		return listaDeUsuarios;
	}

	/**
	 * Metodo para pesquisar um usuario na lista de usuario. Caso o usuario
	 * esteja contido na lista, o metodo retorna true. Caso contrario, retorna
	 * false.
	 * 
	 * @param nome
	 *            Nome do usuario a ser pesquisado
	 * @return
	 */

	public boolean pesquisaUsuario(String nome) {
		for (Usuario usuario : listaDeUsuarios) {
			if (usuario.getNome().equals(nome)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Metodo utilizado para ordenar os usuarios da lista de usuarios.
	 */
	
	public void ordenaUsuarios(){
		Collections.sort(listaDeUsuarios);
	}
}
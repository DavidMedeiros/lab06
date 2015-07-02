/* 114211306 - David de Medeiros Souza: LAB 6 - Turma 3 */

package Mananger;

import java.util.HashSet;
import java.util.List;

import Exceptions.EntradaException;
import Jogo.Jogabilidade;
import Jogo.Jogo;
import Usuario.Usuario;

public class Facade {
	
	private Controller controller;
	
	/**
	 * Construtor da classe Controller.
	 */
	
	public Facade() {
		this.controller = new Controller();
	}
	
	/**
	 * Metodo utilizado para criar jogo (fowarding).
	 * 
	 * @param nome
	 *            Nome do jogo.
	 * @param preco
	 *            Preco do jogo.
	 * @param tipo
	 *            Tipo do jogo a ser criado.
	 * @param jogabilidade
	 *            Jogabilidades do jogo.
	 * @return Jogo - retorna o jogo que foi criado.
	 */
	
	public Jogo criaJogo(String nome, double preco, String tipo, HashSet<Jogabilidade> jogabilidade) {
		try {
			return controller.criaJogo(nome, preco, tipo, jogabilidade);
		} catch (EntradaException e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
	/**
	 * Metodo utilizado para criar um usuario (fowarding).
	 * 
	 * @param nome
	 *            Nome do usuario
	 * @param login
	 *            Login do usuario
	 * @return boolean - retorna um boolean indicando se um usuario foi criado.
	 */
	
	public boolean criaUsuario(String nome, String login) {
		try {
			controller.criaUsuario(nome, login);
			return true;
		} catch (EntradaException e) {
			System.out.println(e.getMessage());
		}
		
		return false;
	}

	/**
	 * Metodo utilizado para vender um jogo.
	 * 
	 * @param usuario
	 *            Usuario a quem se deseja vender o jogo.
	 * @param jogo
	 *            Jogo que se deseja vender ao usuario.
	 */
	
	public void venderJogo(Usuario usuario, Jogo jogo) {
		controller.venderJogo(usuario, jogo);
	}
	
	/**
	 * Metodo utilizado para tentar adiconar dinheiro ao usuario.
	 * 
	 * @param usuario
	 *            Usuario ao qual se deseja adicionar dinheiro.
	 * @param valor
	 *            Valor do dinheiro que se deseja adicionar.
	 * @return boolean - Retorna um boolean indicando se o dinheiro foi
	 *         adicionado de forma correta.
	 */
	
	public boolean adicionaDinheiro(Usuario usuario, double valor) {
		try {
			controller.adicionaDinheiro(usuario, valor);
			return true;
		} catch (EntradaException e) {
			System.out.println(e.getMessage());
		}

		return false;
	}

	/**
	 * Metodo utilizado para imprimir as informacoes do P2CG.
	 */
	
	public void imprimeInformacoes() {
		controller.imprimeInformacoes();
	}
	
	/**
	 * Metodo utilizado para imprimir os top5 usuarios que possuem mais x2p.
	 */
	
	public void imprimeUsuariosTop5() {
		controller.imprimeUsuariosTop5();
	}
	
	/**
	 * Metodo utilizado para retornar a lista de usuarios.
	 * 
	 * @return List<Usuario>
	 */
	
	public List<Usuario> getListaDeUsuarios() {
		return controller.getListaDeUsuarios();
	}
	
	/**
	 * Metodo utilizado para ordenar os usuarios da lista de usuarios.
	 */
	
	public void ordenaUsuarios(){
		controller.ordenaUsuarios();
	}
}

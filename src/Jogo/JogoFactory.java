/* 114211306 - David de Medeiros Souza: LAB 6- Turma 3 */

package Jogo;

import java.util.HashSet;

import Exceptions.EntradaException;
import Exceptions.StringInvalidaException;

public class JogoFactory {
	
	/**
	 * Metodo responsavel por criar um jogo do tipo RPG.
	 * 
	 * @param nome
	 *            Nome do jogo.
	 * @param preco
	 *            Preco do jogo.
	 * @param jogabilidade
	 *            Lista de jogabilidades.
	 * @return Retorna um Jogo do tipo RPG.
	 * @throws EntradaException 
	 */
	
	private Jogo criaJogoRpg(String nome, double preco, HashSet<Jogabilidade> jogabilidade) throws EntradaException {
		Rpg jogoRpg = new Rpg(nome, preco);
		jogoRpg.setJogabilidades(jogabilidade);
		
		return jogoRpg;
	}

	/**
	 * Metodo responsavel por criar um jogo do tipo Luta.
	 * 
	 * @param nome
	 *            Nome do jogo.
	 * @param preco
	 *            Preco do jogo.
	 * @param jogabilidade
	 *            Lista de jogabilidades.
	 * @return Retorna um Jogo do tipo Luta.
	 * @throws EntradaException 
	 */
	
	private Jogo criaJogoLuta(String nome, double preco,HashSet<Jogabilidade> jogabilidade) throws EntradaException {
		Luta jogoLuta = new Luta(nome, preco);
		jogoLuta.setJogabilidades(jogabilidade);
		
		return jogoLuta;
	}
	
	/**
	 * Metodo responsavel por criar um jogo do tipo Plataforma.
	 * 
	 * @param nome
	 *            Nome do jogo.
	 * @param preco
	 *            Preco do jogo.
	 * @param jogabilidade
	 *            Lista de jogabilidades.
	 * @return Retorna um Jogo do tipo Plataforma.
	 * @throws EntradaException 
	 */
	
	private Jogo criaJogoPlataforma(String nome, double preco, HashSet<Jogabilidade> jogabilidade) throws EntradaException {
		Plataforma jogoPlataforma = new Plataforma(nome, preco);
		jogoPlataforma.setJogabilidades(jogabilidade);
		
		return jogoPlataforma;
	}

	/**
	 * Metodo responsavel por criar um jogo de um tipo passado como parametro.
	 * 
	 * @param nome
	 *            Nome do jogo.
	 * @param preco
	 *            Preco do jogo.
	 * @param tipo
	 *            Tipo do jogo.
	 * @param jogabilidade
	 *            Lista de jogabilidades.
	 * @return Retorna um jogo do tipo que foi passado como parametro.
	 * @throws EntradaException
	 *             Uma excessão sera lancada caso o tipo passado seja vazio.
	 */
	
	public Jogo criaJogo(String nome, double preco, String tipo, HashSet<Jogabilidade> jogabilidade) throws EntradaException {
		
		if (tipo == null || tipo.equals("")) {
			throw new StringInvalidaException();
		}

		if (tipo.equals("Rpg")) {
			return criaJogoRpg(nome, preco, jogabilidade);
		}
		if (tipo.equals("Luta")) {
			return criaJogoLuta(nome, preco, jogabilidade);
		}
		if (tipo.equals("Plataforma")) {
			return criaJogoPlataforma(nome, preco, jogabilidade);
		}
		
		return null;
	}
}
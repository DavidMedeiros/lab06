/* 114211306 - David de Medeiros Souza: LAB 6- Turma 3 */

package Usuario;

import Exceptions.DadoInvalidoException;
import Exceptions.EntradaException;
import Exceptions.LogicaException;
import Jogo.Jogo;

public abstract class Jogador {
	
	public Jogador() {
		
	}
	
	/**
	 * Metodo responsavel por informar o valor de um jogo, dependendo do tipo de usuario, o
	 * desconto do jogo mudara.
	 * 
	 * @param jogo
	 *            Jogo que serah comprado.
	 * @return Retorna o pre�o do desconto que serah dado.
	 */
	
	public abstract double calculaPrecoDesconto(double preco);
	
	
	/**
	 * Metodo responsavel por recompensar um determinado de tipo de usuario,
	 * dependendo das suas jogabilidades.
	 * 
	 * @param nomeDoJogo
	 *            Nome do Jogo.
	 * @param score
	 *            Score da jogada atual.
	 * @param zerouOJogo
	 *            Indica��o se o usuario zerou o jogo.
	 * @return 
	 * @throws DadoInvalidoException 
	 * @throws EntradaException Uma excess�o ser� lan�ada caso uma entrada seja vazia.
	 * @throws LogicaException Uma excess�o ser� lan�ada caso o jogo a ser recompensado n�o seja encontrado.
	 */
	
	public abstract int ganhouPartida(Jogo jogo, int score, boolean zerouOJogo) throws DadoInvalidoException;
	
	/**
	 * Metodo responsavel por punir um determinado de tipo de usuario,
	 * dependendo das suas jogabilidades.
	 * 
	 * @param nomeDoJogo
	 *            Nome do Jogo.
	 * @param score
	 *            Score da jogada atual.
	 * @param zerouOJogo
	 *            Indica��o se o usuario zerou o jogo.
	 * @throws DadoInvalidoException 
	 * @throws EntradaException Uma excess�o ser� lan�ada caso uma entrada seja vazia.
	 * @throws LogicaException Uma excess�o ser� lan�ada caso o jogo a ser punido n�o seja encontrado.
	 */
	
	public abstract int perdeuPartida(Jogo jogo, int score, boolean zerouOJogo) throws DadoInvalidoException;
	
}

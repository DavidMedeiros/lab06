/* 114211306 - David de Medeiros Souza: LAB 6- Turma 3 */

package Usuario;

import Exceptions.DadoInvalidoException;
import Exceptions.EntradaException;
import Exceptions.LogicaException;
import Jogo.Jogabilidade;
import Jogo.Jogo;

public class Veterano extends Jogador {
	
	public static final double DESCONTO_PARA_VETERANO = 0.2;

	/**
	 * Metodo responsavel por retornar o valor do jogo ja com o desconto. O
	 * valor do desconto muda de acordo com o tipo de jogador.
	 */
	
	public double calculaPrecoDesconto(double preco) {
		double precoComDesconto = preco - (preco * DESCONTO_PARA_VETERANO);
		return precoComDesconto;
	}
	
	/**
	 * Metodo responsavel por recompensar o usuario dependendo das suas jogabilidades.
	 * 
	 * @param nomeDoJogo
	 *            Nome do Jogo.
	 * @param score
	 *            Score da jogada atual.
	 * @param zerouOJogo
	 *            Indica se o usuario zerou o jogo.
	 * @throws DadoInvalidoException 
	 * @throws EntradaException Uma excessao sera lancada caso uma entrada seja vazia.
	 * @throws LogicaException  Uma excessao sera lancada caso o jogo a ser recompensado nao seja encontrado.
	 */
	
	@Override
	public int ganhouPartida(Jogo jogo, int score, boolean zerouOJogo) throws DadoInvalidoException {
	
		int pontuacaoX2p = 0;
		pontuacaoX2p += jogo.joga(score, zerouOJogo);

		if (jogo.getJogabilidades().contains(Jogabilidade.ONLINE)) {
			pontuacaoX2p += 10;
		}
		if (jogo.getJogabilidades().contains(Jogabilidade.COOPERATIVO)) {
			pontuacaoX2p += 20;
		}
		
		return pontuacaoX2p;
	}
	
	/**
	 * Metodo responsavel por punir o usuario dependendo das suas jogabilidades.
	 * 
	 * @param nomeDoJogo
	 *            Nome do Jogo.
	 * @param score
	 *            Score da jogada atual.
	 * @param zerouOJogo
	 *            Indica se o usuario zerou o jogo.
	 * @throws DadoInvalidoException 
	 * @throws EntradaException Uma excessao sera lancada caso uma entrada seja vazia.
	 * @throws LogicaException  Uma excessao sera lancada caso o jogo a ser punido nao seja encontrado.
	 */
	
	@Override
	public int perdeuPartida(Jogo jogo, int score, boolean zerouOJogo) throws DadoInvalidoException {
	
		int pontuacaoX2p = 0;
		pontuacaoX2p += jogo.joga(score, zerouOJogo);
		
		if (jogo.getJogabilidades().contains(Jogabilidade.COMPETITIVO)) {
			pontuacaoX2p = pontuacaoX2p - 10;
		}
		if (jogo.getJogabilidades().contains(Jogabilidade.COOPERATIVO)) {
			pontuacaoX2p = pontuacaoX2p - 20;
		}
		
		return pontuacaoX2p;                     
	}
	
	
	/**
	 * Metodo utilizado para indicar o tipo de usuario.
	 * 
	 * @return Retorna o nome da classe.
	 */	
	
	@Override
	public String toString() {
		return "Veterano";
	}
}
/* 114211306 - David de Medeiros Souza: LAB 6- Turma 3 */

package Jogo;

import Exceptions.DadoInvalidoException;
import Exceptions.EntradaException;

public class Luta extends Jogo {

	/**
	 * Metodo Construtor da Classe Luta.
	 * 
	 * @param nome
	 *            Nome do Jogo.
	 * @param preco
	 *            Preco do Jogo.
	 * @throws EntradaException 
	 */
	
	public Luta(String nome, double preco) throws EntradaException {
		super(nome, preco);
	}

	/**
	 * Metodo responsavel por jogar o jogo do tipo Luta, atualizando se necessario, o maior
	 * score e a quantidade de vezes zeradas. Alem de atualizar a
	 * quantidade de vezes jogadas.
	 * 
	 * @param score
	 *            Score da jogada atual.
	 * @param zerouOJogo
	 *            Indica se o usuario zerou o jogo.
	 * @return Retorna o calculo da pontuacao x2p para o jogo do tipo Luta.
	 * @throws DadoInvalidoException 
	 */
	
	@Override
	public int joga(int score, boolean zerouOJogo) throws DadoInvalidoException {
		
		if (score < 0 || score > 100000)
			throw new DadoInvalidoException();
		if (score > this.maiorScore)
			this.maiorScore = score;
		if (zerouOJogo)
			this.vezesZeradas += 1;
		this.vezesJogadas += 1;
		
		return (this.maiorScore / 1000);
	}
	
	/**
	 * Metodo utilizado para indicar o tipo do jogo.
	 * 
	 * @return Retorna o nome do jogo +  nome da classe.
	 */	

	@Override
	public String toString() {
		return getNome() + " - Luta";
	}

}
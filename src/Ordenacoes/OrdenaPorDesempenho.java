/* 114211306 - David de Medeiros Souza: LAB 6 - Turma 3 */

package Ordenacoes;

import java.util.Comparator;

import Jogo.Jogo;

public class OrdenaPorDesempenho implements Comparator<Jogo> {

	/**
	 * Metodo utilizado para ordenar jogos por desempenho. Ou seja, ordena jogos
	 * pelo seus scores.
	 */
	
	@Override
	public int compare(Jogo jogo1, Jogo jogo2) {
		if (jogo1.getMaiorScore() < jogo2.getMaiorScore() ) {
			return -1;
		}
		if (jogo1.getMaiorScore() > jogo2.getMaiorScore() ) {
			return 1;
		}
		return 0;
	}
}

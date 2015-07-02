/* 114211306 - David de Medeiros Souza: LAB 6 - Turma 3 */

package Ordenacoes;

import java.util.Comparator;

import Jogo.Jogo;

public class OrdenaPorExperiencia implements Comparator<Jogo> {

	/**
	 * Metodo utilizado para ordenar jogos por experiencia. Ou seja, ordena jogos
	 * pela quantidade de vezes que foram zerados.
	 */
	
	@Override
	public int compare(Jogo jogo1, Jogo jogo2) {
		if (jogo1.getVezesZeradas() < jogo2.getVezesZeradas() ) {
			return -1;
		}
		if (jogo1.getVezesZeradas() > jogo2.getVezesZeradas() ) {
			return 1;
		}
		return 0;
	}
}

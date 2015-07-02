/* 114211306 - David de Medeiros Souza: LAB 6- Turma 3 */

package Ordenacoes;

import java.util.Comparator;

import Jogo.Jogo;

public class OrdenaPorVicio implements Comparator<Jogo> {

	@Override
	public int compare(Jogo jogo1, Jogo jogo2) {
		if (jogo1.getVezesJogadas() < jogo2.getVezesJogadas() ) {
			return -1;
		}
		if (jogo1.getVezesJogadas() > jogo2.getVezesJogadas() ) {
			return 1;
		}
		return 0;
	}
}

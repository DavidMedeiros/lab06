/* 114211306 - David de Medeiros Souza: LAB 6- Turma 3 */

// TODO JAVADOC

package Jogo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Ordenacoes.OrdenaPorDesempenho;
import Ordenacoes.OrdenaPorExperiencia;
import Ordenacoes.OrdenaPorVicio;

public class CatalogoJogos {
	private List<Jogo> listaDeJogosComprados;
	
	public CatalogoJogos() {
		this.listaDeJogosComprados = new ArrayList<Jogo>();
	}
	
	public void adicionaJogo(Jogo jogo) {
		listaDeJogosComprados.add(jogo);
	}
	
	public void removeJogo(Jogo jogo) {
		listaDeJogosComprados.remove(jogo);
	}
	
	public boolean pesquisaJogo(String nomeDoJogo) {
		for (Jogo jogo : listaDeJogosComprados) {
			if (jogo.getNome().equals(nomeDoJogo)) {
				return true;
			}
		}
		return false;
	}
	
	public Jogo jogoComMaiorScore() {
		Jogo jogoComMaiorScore = listaDeJogosComprados.get(0);
		
		for (Jogo jogo : listaDeJogosComprados) {
			if (jogo.getMaiorScore() >= jogoComMaiorScore.getMaiorScore()) {
				jogoComMaiorScore = jogo;
			}
		}
		
		return jogoComMaiorScore;
	}
	
	public Jogo jogoComMaisJogadas() {
		Jogo jogoComMaisJogadas = listaDeJogosComprados.get(0);
		
		for (Jogo jogo : listaDeJogosComprados) {
			if (jogo.getVezesJogadas() >= jogoComMaisJogadas.getVezesJogadas()) {
				jogoComMaisJogadas = jogo;
			}
		}
		
		return jogoComMaisJogadas;
	}

	public Jogo jogoMaisZerado() {
		Jogo jogoMaisZerado = listaDeJogosComprados.get(0);
		
		for (Jogo jogo : listaDeJogosComprados) {
			if (jogo.getVezesZeradas() >= jogoMaisZerado.getVezesZeradas()) {
				jogoMaisZerado = jogo;
			}
		}
		
		return jogoMaisZerado;
	}
	
	public List<Jogo> jogosComJogabilidadeComum(Jogabilidade jogabilidade) {
		List<Jogo> listaDeJogosComMesmaJogabilidade = new ArrayList<Jogo>();
		
		for (Jogo jogo : listaDeJogosComprados) {
			if (jogo.getJogabilidades().contains(jogabilidade)) {
				listaDeJogosComMesmaJogabilidade.add(jogo);
			}
		}
		
		return listaDeJogosComMesmaJogabilidade;
	}
	
	public void ordenaCatalogoJogos(TiposOrdenacao tipoOrdenacao) {
		
		if (tipoOrdenacao.equals(TiposOrdenacao.DEFAULT)) {
			Collections.sort(listaDeJogosComprados);
		}
		if (tipoOrdenacao.equals(TiposOrdenacao.DESEMPENHO)) {
			OrdenaPorDesempenho comparator = new OrdenaPorDesempenho();
			Collections.sort(listaDeJogosComprados, comparator);
		}
		if (tipoOrdenacao.equals(TiposOrdenacao.EXPERIENCIA)) {
			OrdenaPorExperiencia comparator = new OrdenaPorExperiencia();
			Collections.sort(listaDeJogosComprados, comparator);
		}
		if (tipoOrdenacao.equals(TiposOrdenacao.VICIO)) {
			OrdenaPorVicio comparator = new OrdenaPorVicio();
			Collections.sort(listaDeJogosComprados, comparator);
		}
	}
	
	public List<Jogo> getListaDeJogosComprados() {
		return listaDeJogosComprados;
	}

	public void setListaDeJogosComprados(List<Jogo> listaDeJogosComprados) {
		this.listaDeJogosComprados = listaDeJogosComprados;
	}
}

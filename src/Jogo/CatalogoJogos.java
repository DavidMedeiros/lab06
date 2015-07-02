/* 114211306 - David de Medeiros Souza: LAB 6 - Turma 3 */

package Jogo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Ordenacoes.OrdenaPorDesempenho;
import Ordenacoes.OrdenaPorExperiencia;
import Ordenacoes.OrdenaPorVicio;

public class CatalogoJogos {
	
	private List<Jogo> listaDeJogosComprados;
	
	/**
	 * Construtor da classe CatalogoJogos.
	 */
	
	public CatalogoJogos() {
		this.listaDeJogosComprados = new ArrayList<Jogo>();
	}
	
	/**
	 * Metodo para adicionar um jogo no catalogo de jogos
	 * (listaDeJogosComprados).
	 * 
	 * @param jogo
	 *            Jogo que sera adicionado.
	 */
	
	public void adicionaJogo(Jogo jogo) {
		listaDeJogosComprados.add(jogo);
	}
	
	/**
	 * Metodo para remover um jogo no catalogo de jogos
	 * (listaDeJogosComprados).
	 * 
	 * @param jogo
	 *            Jogo que sera removido.
	 */
	
	public void removeJogo(Jogo jogo) {
		listaDeJogosComprados.remove(jogo);
	}
	
	/**
	 * Metodo para pesquisar um jogo no catalogo de jogos.
	 * 
	 * @param nomeDoJogo
	 *            Nome do jogo a ser pesquisado.
	 * @return Caso o jogo seja encontrado eh retornado um boolean.
	 */
	
	public boolean pesquisaJogo(String nomeDoJogo) {
		for (Jogo jogo : listaDeJogosComprados) {
			if (jogo.getNome().equals(nomeDoJogo)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Metodo para encontrar no catalogo o jogo com maior score.
	 * 
	 * @return Retorna o jogo com maior score do catalogo de jogos.
	 */

	public Jogo jogoComMaiorScore() {
		Jogo jogoComMaiorScore = listaDeJogosComprados.get(0);

		for (Jogo jogo : listaDeJogosComprados) {
			if (jogo.getMaiorScore() >= jogoComMaiorScore.getMaiorScore()) {
				jogoComMaiorScore = jogo;
			}
		}

		return jogoComMaiorScore;
	}
	
	/**
	 * Metodo para encontrar no catalogo o jogo com mais jogadas.
	 * 
	 * @return Retorna o jogo com mais jogadas do catalogo de jogos.
	 */

	
	public Jogo jogoComMaisJogadas() {
		Jogo jogoComMaisJogadas = listaDeJogosComprados.get(0);
		
		for (Jogo jogo : listaDeJogosComprados) {
			if (jogo.getVezesJogadas() >= jogoComMaisJogadas.getVezesJogadas()) {
				jogoComMaisJogadas = jogo;
			}
		}
		
		return jogoComMaisJogadas;
	}
	
	/**
	 * Metodo para encontrar no catalogo o jogo que foi mais zerado.
	 * 
	 * @return Retorna o jogo zerado mais vezes do catalogo de jogos.
	 */


	public Jogo jogoMaisZerado() {
		Jogo jogoMaisZerado = listaDeJogosComprados.get(0);

		for (Jogo jogo : listaDeJogosComprados) {
			if (jogo.getVezesZeradas() >= jogoMaisZerado.getVezesZeradas()) {
				jogoMaisZerado = jogo;
			}
		}

		return jogoMaisZerado;
	}
	
	/**
	 * Metodo para encontrar jogos com uma certa jogabilidade em comum.
	 * 
	 * @param jogabilidade
	 *            Jogabilidade a ser buscada nos jogos.
	 * @return List<Jogo> que possuem a jogabilidade informada.
	 */
	
	public List<Jogo> jogosComJogabilidadeComum(Jogabilidade jogabilidade) {
		List<Jogo> listaDeJogosComMesmaJogabilidade = new ArrayList<Jogo>();

		for (Jogo jogo : listaDeJogosComprados) {
			if (jogo.getJogabilidades().contains(jogabilidade)) {
				listaDeJogosComMesmaJogabilidade.add(jogo);
			}
		}

		return listaDeJogosComMesmaJogabilidade;
	}
	
	/**
	 * Metodo utilizado para ordenar o catalogo de jogos de acordo com um tipo
	 * de ordenacao especificado.
	 * 
	 * @param tipoOrdenacao
	 *            Tipo de ordenacao que se deseja ordenar o catalogo.
	 */

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
	
	/**
	 * Metodo para retorno do catalogo de jogos (Lista de jogos comprados).
	 * 
	 * @return List<Jogo> - Lista de jogos comprados.
	 */
	
	public List<Jogo> getListaDeJogosComprados() {
		return listaDeJogosComprados;
	}

	/**
	 * Metodo para alteracao do catalogo de jogos (Lista de jogos comprados).
	 */
	
	public void setListaDeJogosComprados(List<Jogo> listaDeJogosComprados) {
		this.listaDeJogosComprados = listaDeJogosComprados;
	}
}

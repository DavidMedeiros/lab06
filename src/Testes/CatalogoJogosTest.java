/* 114211306 - David de Medeiros Souza: LAB 6 - Turma 3 */

package Testes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Exceptions.EntradaException;
import Jogo.CatalogoJogos;
import Jogo.Jogabilidade;
import Jogo.Jogo;
import Jogo.JogoFactory;
import Jogo.TiposOrdenacao;

public class CatalogoJogosTest {
	
	private Jogo jogo1;
	private Jogo jogo2;
	private Jogo jogo3;
	
	private HashSet<Jogabilidade> jogabilidades1;
	private HashSet<Jogabilidade> jogabilidades2;
	private HashSet<Jogabilidade> jogabilidades3;
	
	private JogoFactory factory;
	private CatalogoJogos catalogoJogos;
	
	@Before
	public void setUp() {
		catalogoJogos = new CatalogoJogos();
		factory = new JogoFactory();
		
		// CRIA JOGOS DE FORMA CORRETA, USA METODO JOGAR E POPULA CATALOGO DE JOGOS
		try {
			jogabilidades1 = new HashSet<>();
			jogabilidades1.add(Jogabilidade.OFFLINE);
			jogo1 = factory.criaJogo("Super Mario", 50, "Plataforma", jogabilidades1);
			
			jogabilidades2 = new HashSet<>();
			jogabilidades2.add(Jogabilidade.MULTIPLAYER);
			jogo2 = factory.criaJogo("The Streets", 100, "Luta", jogabilidades2);
			
			jogabilidades3 = new HashSet<>();
			jogabilidades3.add(Jogabilidade.OFFLINE);
			jogabilidades3.add(Jogabilidade.MULTIPLAYER);
			jogo3 = factory.criaJogo("Magicka", 25, "Rpg" , jogabilidades3);
			
			jogo1.joga(3020, true);
			jogo1.joga(100, true);
			jogo2.joga(9301, false);
			jogo3.joga(290, true);
			jogo3.joga(900, true);
			jogo3.joga(20, false);
			
			catalogoJogos.adicionaJogo(jogo1);
			catalogoJogos.adicionaJogo(jogo2);
			catalogoJogos.adicionaJogo(jogo3);
			
		} catch (EntradaException e) {
			// NAO DEVE CAPTURAR EXCESSAO
			Assert.fail();
		}
	}
	
	@Test
	public void testaAdicionaRemoveJogo() {

		// VERIFICA SE JOGOS FORAM ADICIONADOS
		Assert.assertEquals(3, catalogoJogos.getListaDeJogosComprados().size());
		
		// TESTA METODO REMOVE JOGO NO CATALOGO DE JOGOS
		catalogoJogos.removeJogo(jogo2);
		
		// VERIFICA SE JOGOS FORAM ADICIONADOS
		Assert.assertEquals(2, catalogoJogos.getListaDeJogosComprados().size());
		
	}
	
	@Test
	public void testaJogoCom() {
		// VERIFICA JOGO COM MAIOR SCORE
		Assert.assertEquals(jogo2, catalogoJogos.jogoComMaiorScore());
		
		// VERIFICA JOGO COM MAIS JOGADAS
		Assert.assertEquals(jogo3, catalogoJogos.jogoComMaisJogadas());
		
		// VERIFICA JOGO MAIS ZERADO
		Assert.assertEquals(jogo3, catalogoJogos.jogoMaisZerado());
	}
	
	@Test
	public void pesquisaJogoNoCatalogo() {
		// PROCURA JOGO NO CATALOGO
		Assert.assertTrue(catalogoJogos.pesquisaJogo("Super Mario"));
		Assert.assertFalse(catalogoJogos.pesquisaJogo("Mega Man"));
		
	}
	
	@Test
	public void testaJogoComMesmaJogabilidade() {
		List<Jogo> listaDeJogosOffline = new ArrayList<Jogo>();
		listaDeJogosOffline.add(jogo1);
		listaDeJogosOffline.add(jogo3);
		
		List<Jogo> listaDeJogosMultiplayer = new ArrayList<Jogo>();
		listaDeJogosMultiplayer.add(jogo2);
		listaDeJogosMultiplayer.add(jogo3);
		
		// VERIFICA JOGOS COM A MESMA JOGABILIDADE
		Assert.assertEquals(listaDeJogosOffline, catalogoJogos.jogosComJogabilidadeComum(Jogabilidade.OFFLINE));
		Assert.assertEquals(listaDeJogosMultiplayer, catalogoJogos.jogosComJogabilidadeComum(Jogabilidade.MULTIPLAYER));
	}

	@Test
	public void testaOrdenacaoDeJogos() {
		
		//TESTA ORDENACAO POR VICIO, DESEMPENHO, EXPERIENCIA, DEFAUL
		catalogoJogos.ordenaCatalogoJogos(TiposOrdenacao.VICIO);
		Assert.assertEquals(jogo2, catalogoJogos.getListaDeJogosComprados().get(0));
		Assert.assertEquals(jogo1, catalogoJogos.getListaDeJogosComprados().get(1));
		Assert.assertEquals(jogo3, catalogoJogos.getListaDeJogosComprados().get(2));

		catalogoJogos.ordenaCatalogoJogos(TiposOrdenacao.DESEMPENHO);
		Assert.assertEquals(jogo3, catalogoJogos.getListaDeJogosComprados().get(0));
		Assert.assertEquals(jogo1, catalogoJogos.getListaDeJogosComprados().get(1));
		Assert.assertEquals(jogo2, catalogoJogos.getListaDeJogosComprados().get(2));
		
		catalogoJogos.ordenaCatalogoJogos(TiposOrdenacao.EXPERIENCIA);
		Assert.assertEquals(jogo2, catalogoJogos.getListaDeJogosComprados().get(0));
		Assert.assertEquals(jogo3, catalogoJogos.getListaDeJogosComprados().get(1));
		Assert.assertEquals(jogo1, catalogoJogos.getListaDeJogosComprados().get(2));
		
		catalogoJogos.ordenaCatalogoJogos(TiposOrdenacao.DEFAULT);
		Assert.assertEquals(jogo3, catalogoJogos.getListaDeJogosComprados().get(0));
		Assert.assertEquals(jogo1, catalogoJogos.getListaDeJogosComprados().get(1));
		Assert.assertEquals(jogo2, catalogoJogos.getListaDeJogosComprados().get(2));

		
	}
}

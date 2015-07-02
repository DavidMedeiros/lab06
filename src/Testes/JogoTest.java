/* 114211306 - David de Medeiros Souza: LAB 6- Turma 3 */

package Testes;

import java.util.HashSet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Exceptions.EntradaException;
import Jogo.Jogabilidade;
import Jogo.Jogo;
import Jogo.JogoFactory;

public class JogoTest {
	
	private Jogo jogo1;
	private Jogo jogo2;
	private Jogo jogo3;
	
	private HashSet<Jogabilidade> jogabilidades1;
	private HashSet<Jogabilidade> jogabilidades2;
	private HashSet<Jogabilidade> jogabilidades3;
	
	private JogoFactory factory;

	@Before
	public void setUp() {
		factory = new JogoFactory();
		
		// CRIA JOGOS DE FORMA CORRETA
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
			
		} catch (EntradaException e) {
			// NAO DEVE CAPTURAR EXCESSAO
			Assert.fail();
		}
	}
	
	@Test
	public void testaJogosCriados() {
		// TESTA CONSTRUTOR DO JOGO 1
		Assert.assertEquals("Super Mario", jogo1.getNome());
		Assert.assertEquals(50, jogo1.getPreco(), 0);
		Assert.assertEquals("Super Mario - Plataforma", jogo1.toString());
		Assert.assertEquals(jogabilidades1, jogo1.getJogabilidades());
		Assert.assertEquals(0, jogo1.getMaiorScore());
		Assert.assertEquals(0, jogo1.getVezesZeradas());
		Assert.assertEquals(0, jogo1.getVezesJogadas());
		
		// TESTA CONSTRUTOR DO JOGO 2
		Assert.assertEquals("The Streets", jogo2.getNome());
		Assert.assertEquals(100, jogo2.getPreco(), 0);
		Assert.assertEquals("The Streets - Luta", jogo2.toString());
		Assert.assertEquals(jogabilidades2, jogo2.getJogabilidades());
		Assert.assertEquals(0, jogo2.getMaiorScore());
		Assert.assertEquals(0, jogo2.getVezesZeradas());
		Assert.assertEquals(0, jogo2.getVezesJogadas());
		
		// TESTA CONSTRUTOR DO JOGO 3
		Assert.assertEquals("Magicka", jogo3.getNome());
		Assert.assertEquals(25, jogo3.getPreco(), 0);
		Assert.assertEquals("Magicka - RPG", jogo3.toString());
		Assert.assertEquals(jogabilidades3, jogo3.getJogabilidades());
		Assert.assertEquals(0, jogo3.getMaiorScore());
		Assert.assertEquals(0, jogo3.getVezesZeradas());
		Assert.assertEquals(0, jogo3.getVezesJogadas());
	}

	@Test
	public void testaMetodoJoga() {
		try {
			// TESTA METODO JOGA DO JOGO 1 (PLATAFORMA)
			// Jogo Plataforma retorna quantidade vezes zeradas * 20
			
			Assert.assertEquals(0, jogo1.joga(1000, false)); 
			Assert.assertEquals(1000, jogo1.getMaiorScore());
			Assert.assertEquals(0, jogo1.getVezesZeradas());
			Assert.assertEquals(1, jogo1.getVezesJogadas());
	
			Assert.assertEquals(20, jogo1.joga(100, true));
			Assert.assertEquals(1000, jogo1.getMaiorScore());
			Assert.assertEquals(1, jogo1.getVezesZeradas());
			Assert.assertEquals(2, jogo1.getVezesJogadas());
			
			Assert.assertEquals(40, jogo1.joga(1100, true)); 
			Assert.assertEquals(1100, jogo1.getMaiorScore());
			Assert.assertEquals(2, jogo1.getVezesZeradas());
			Assert.assertEquals(3, jogo1.getVezesJogadas());
			
			
			// TESTA METODO JOGA DO JOGO 2 (LUTA)
			// Jogo Luta retorna 1 x2p para cada 1000 no score max
			
			Assert.assertEquals(1, jogo2.joga(1090, false)); 
			Assert.assertEquals(1090, jogo2.getMaiorScore());
			Assert.assertEquals(0, jogo2.getVezesZeradas());
			Assert.assertEquals(1, jogo2.getVezesJogadas());

			Assert.assertEquals(1, jogo2.joga(100, true)); 
			Assert.assertEquals(1090, jogo2.getMaiorScore());
			Assert.assertEquals(1, jogo2.getVezesZeradas());
			Assert.assertEquals(2, jogo2.getVezesJogadas());
			
			Assert.assertEquals(5, jogo2.joga(5293, true)); 
			Assert.assertEquals(5293, jogo2.getMaiorScore());
			Assert.assertEquals(2, jogo2.getVezesZeradas());
			Assert.assertEquals(3, jogo2.getVezesJogadas());
			
			// TESTA METODO JOGA DO JOGO 3 (RPG)
			// Jogo Rpg retorna 10 x2p para cada vez jogada
			
			Assert.assertEquals(10, jogo3.joga(199, true)); 
			Assert.assertEquals(199, jogo3.getMaiorScore());
			Assert.assertEquals(1, jogo3.getVezesZeradas());
			Assert.assertEquals(1, jogo3.getVezesJogadas());
			
			Assert.assertEquals(20, jogo3.joga(299, true));
			Assert.assertEquals(299, jogo3.getMaiorScore());
			Assert.assertEquals(2, jogo3.getVezesZeradas());
			Assert.assertEquals(2, jogo3.getVezesJogadas());
			
			Assert.assertEquals(30, jogo3.joga(1000, true));
			Assert.assertEquals(1000, jogo3.getMaiorScore());
			Assert.assertEquals(3, jogo3.getVezesZeradas());
			Assert.assertEquals(3, jogo3.getVezesJogadas());
			
			// TESTA EXCESSOES DOS METODOS JOGA
			
			// SCORE ABAIXO DE 0
			try{
				Assert.assertEquals(1, jogo1.joga(-100, true));
				Assert.fail(); // NAO DEVE CHEGAR NESTA LINHA, UMA EXCESSAO DEVERIA SER LANCADA
			} catch (EntradaException e) {
				Assert.assertEquals("Dado invalido.", e.getMessage());
			}
			
			// SCORE ACIMA DE 100.000 PARA JOGOS DE LUTA
			try{
				Assert.assertEquals(1, jogo2.joga(1000000, true));
				Assert.fail(); // NAO DEVE CHEGAR NESTA LINHA, UMA EXCESSAO DEVERIA SER LANCADA
			} catch (EntradaException e) {
				Assert.assertEquals("Dado invalido.", e.getMessage());
			}			
			
		} catch (EntradaException e) {
			// NAO DEVE CAPTURAR EXCESSAO
			Assert.fail();
		}
	}
	
	@Test 
	public void testaCriarJogosDeManeiraInvalida() {

		// CRIA JOGOS DE FORMA INCORRETA
		
		try {
			Jogo jogo4 = factory.criaJogo("", 50, "Plataforma", jogabilidades1);
			Assert.fail(); // NAO DEVE CHEGAR NESTA LINHA, UMA EXCESSAO DEVERIA SER LANCADA
		} catch (EntradaException e) {
			Assert.assertEquals("A string eh invalida.", e.getMessage());
		}
		
		try {
			Jogo jogo5 = factory.criaJogo("Bubble", 500, "", jogabilidades2);
			Assert.fail(); // NAO DEVE CHEGAR NESTA LINHA, UMA EXCESSAO DEVERIA SER LANCADA
		} catch (EntradaException e) {
			Assert.assertEquals("A string eh invalida.", e.getMessage());
		}
		
		try {
			Jogo jogo6 = factory.criaJogo("Bubble 2", -50, "Luta", jogabilidades2);
			Assert.fail(); // NAO DEVE CHEGAR NESTA LINHA, UMA EXCESSAO DEVERIA SER LANCADA
		} catch (EntradaException e) {
			Assert.assertEquals("Dado invalido.", e.getMessage());
		}
	}
}
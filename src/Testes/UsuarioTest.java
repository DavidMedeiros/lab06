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
import Usuario.Noob;
import Usuario.Usuario;
import Usuario.Veterano;

public class UsuarioTest {

	private Usuario usuario1;
	private Usuario usuario2;
	
	private Jogo jogo1;
	private Jogo jogo2;
	
	private HashSet<Jogabilidade> jogabilidades;
	private JogoFactory factory;

	@Before
	public void setUp() {
		factory = new JogoFactory();
		
		// CRIA USUARIOS E JOGOS DE FORMA CORRETA 
		try {
			usuario1 = new Usuario("David", "david.souza");
			usuario2 = new Usuario("Joana", "joana.marrie");

			jogabilidades = new HashSet<>();
			jogabilidades.add(Jogabilidade.COMPETITIVO);
			jogabilidades.add(Jogabilidade.OFFLINE);
			
			jogo1 = factory.criaJogo("Super Mario Plus", 1000, "Plataforma", jogabilidades);
			jogo2 = factory.criaJogo("The Streets", 50, "Luta", jogabilidades);

		} catch (EntradaException e) {
			// NAO DEVE CAPTURAR EXCESSAO
			Assert.fail();
		}
	}
	
	@Test
	public void testaUsuariosCriados() {
		// TESTA CONSTRUTOR DO USUARIO 1
		Assert.assertEquals("David", usuario1.getNome());
		Assert.assertEquals("david.souza", usuario1.getLogin());
		Assert.assertEquals(0, usuario1.getDinheiro(), 0);
		Assert.assertEquals(0, usuario1.getPrecoTotalArrecadado(), 0);
		Assert.assertEquals(0, usuario1.getX2p());
		
		// TESTA CONSTRUTOR DO USUARIO 2
		Assert.assertEquals("Joana", usuario2.getNome());
		Assert.assertEquals("joana.marrie", usuario2.getLogin());
		Assert.assertEquals(0, usuario2.getDinheiro(), 0);
		Assert.assertEquals(0, usuario2.getPrecoTotalArrecadado(), 0);
		Assert.assertEquals(0, usuario2.getX2p());	
	}
	
	@Test
	public void testaGanhaPerdePartida() {
		// TESTA GANHA PARTIDA
		try {
			usuario1.adicionaDinheiro(2000);

			// VERIFICA PRECO JOGO COM DESCONTO PARA USUARIO NOOB
			Assert.assertEquals(900, usuario1.getJogador().calculaPrecoDesconto(1000), 0);
			
			usuario1.comprarJogo(jogo1);
			usuario1.ganhouPartida("Super Mario Plus", 900, true);
			
			Assert.assertEquals(10020, usuario1.getX2p());
			Assert.assertTrue(usuario1.getJogador() instanceof Veterano); // VERIFICA UPGRADE

			// VERIFICA PRECO JOGO COM DESCONTO PARA USUARIO VETERANO
			Assert.assertEquals(800, usuario1.getJogador().calculaPrecoDesconto(1000), 0);

		} catch (Exception e) {
			// NAO DEVE CAPTURAR EXCESSAO
			Assert.fail();
		}
		
		//TESTA PERDE PARTIDA
		try {
			usuario2.adicionaDinheiro(2000);
			usuario2.comprarJogo(jogo2);
			usuario2.ganhouPartida("The Streets", 10, false);
			
			Assert.assertEquals(530, usuario2.getX2p());
			Assert.assertTrue(usuario2.getJogador() instanceof Noob);
			
		} catch (Exception e) {
			// NAO DEVE CAPTURAR EXCESSAO
			Assert.fail();
		}
	}

}

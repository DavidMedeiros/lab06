/* 114211306 - David de Medeiros Souza: LAB 6 - Turma 3 */

package Testes;

import java.util.HashSet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Exceptions.EntradaException;
import Jogo.Jogabilidade;
import Mananger.Loja;
import Usuario.Usuario;

public class LojaTest {
	private Usuario usuario1;
	private Usuario usuario2;
	private Usuario usuario3;

	private HashSet<Jogabilidade> jogabilidades1;

	private Loja loja;

	@Before
	public void setUp() {
		// CRIA USUARIOS, JOGABILIDADES E INSTANCIA DE LOJA
		try {
			loja = new Loja();

			jogabilidades1 = new HashSet<>();
			jogabilidades1.add(Jogabilidade.MULTIPLAYER);
			jogabilidades1.add(Jogabilidade.OFFLINE);

			usuario1 = loja.criaUsuario("David", "david.souza");
			usuario2 = loja.criaUsuario("Neto", "francisco.neto");
			usuario3 = loja.criaUsuario("Joane", "joane.marrie");

		} catch (EntradaException e) {
			// NAO DEVE CAPTURAR EXCESSAO
			Assert.fail();
		}
	}

	@Test
	public void verificaSeJogosForamCriados() {
		Assert.assertEquals(3, loja.getListaDeUsuarios().size());
	}

	@Test
	public void testaPesquisaUsuarios() {
		Assert.assertTrue(loja.pesquisaUsuario("David"));
		Assert.assertFalse(loja.pesquisaUsuario("Melissa"));
	}

	@Test
	public void testaOrdenaUsuarios() {
		// VERIFICA METODO DE ORDENACAO DOS USUARIOS POR X2P (MAIOR PARA MENOR)
		usuario1.setX2p(10);
		usuario2.setX2p(30);
		usuario3.setX2p(20);

		loja.ordenaUsuarios();
		
		Assert.assertEquals(usuario2, loja.getListaDeUsuarios().get(0));
		Assert.assertEquals(usuario3, loja.getListaDeUsuarios().get(1));
		Assert.assertEquals(usuario1, loja.getListaDeUsuarios().get(2));
	}
}
/* 114211306 - David de Medeiros Souza: LAB 6- Turma 3 */

package Mananger;

import java.util.HashSet;
import java.util.List;

import Exceptions.EntradaException;
import Jogo.Jogabilidade;
import Jogo.Jogo;
import Jogo.JogoFactory;
import Usuario.Usuario;

public class Controller {
	
	private JogoFactory factory;
	private double totalPrecoJogo;
	private Loja loja;
	
	public Controller() {
		this.factory = new JogoFactory();
		this.loja = new Loja();
		this.totalPrecoJogo = 0;
	}
	
	/**
	 * Metodo utilizado para criar um jogo do tipo que eh especificado no
	 * parametro. Toda a criacao do jogo ocorre no factory.
	 * 
	 * @param nome
	 *            Nome do jogo.
	 * @param preco
	 *            Preco do jogo.
	 * @param tipo
	 *            Tipo do jogo.
	 * @param jogabilidade
	 *            Lista de jogabilidades.
	 * @return retorna um jogo caso o mesmo tenha sido criado com sucesso. 
	 * @throws EntradaException 
	 */
	
	public Jogo criaJogo(String nome, double preco, String tipo, HashSet<Jogabilidade> jogabilidade) throws EntradaException {
			return factory.criaJogo(nome, preco, tipo, jogabilidade);
	}
	
	/**
	 * Metodo utilizado para criar um usuario. Um fowarding eh utilizado para tal criacao.
	 * @throws EntradaException 
	 */
	
	public void criaUsuario(String nome, String login) throws EntradaException {
		loja.criaUsuario(nome, login);
	}
	
	/**
	 * Metodo utilizado para vender um jogo para determinado usuario.
	 * 
	 * @param usuario
	 *            Nome do usuario ao qual sera vendido o jogo.
	 * @param jogo
	 *            Jogo que sera vendido ao usuario.
	 */

	public void venderJogo(Usuario usuario, Jogo jogo) {
		usuario.setPrecoTotalArrecadado(usuario.comprarJogo(jogo));
	}
	
	/**
	 * Metodo utilizado para adicionar dinheiro ao usuario.
	 * 
	 * @param usuario
	 *            Usuario que tera o dinheiro adicionado.
	 * @param valor
	 *            Valor que sera adicionado ao dinheiro do usuario.
	 * @throws EntradaException 
	 */

	public void adicionaDinheiro(Usuario usuario, double valor) throws EntradaException {
			usuario.adicionaDinheiro(valor);
	}
	
	/**
	 * Metodo utilizado para imprimir as informacoes do P2CG
	 */
	
	public void imprimeInformacoes(){
		System.out.println("=== Central P2-CG ===");
		System.out.println("");
		
		for (Usuario usuario : loja.getListaDeUsuarios()) {
			System.out.println(usuario.getLogin());
			System.out.println(usuario.getNome());
			System.out.println("Jogador " + usuario.toString() + ": " + usuario.getX2p() + " x2p");
			System.out.println("Lista de Jogos:");
			
			for (Jogo jogo : usuario.getListaDeJogosComprados()) {
				System.out.println("+ " + jogo.toString());
				System.out.println("==> Jogou " + jogo.getVezesJogadas() + " vez(es)");
				System.out.println("==> Zerou " + jogo.getVezesZeradas() + " vez(es)");
				System.out.println("==> Maior score: " + jogo.getMaiorScore());
				System.out.println("");
				totalPrecoJogo += jogo.getPreco();
			}
			
			System.out.println("Total de preco dos jogos: R$ " + totalPrecoJogo);
			System.out.println("--------------------------------------------");
			System.out.println("Total arrecadado com vendas de jogos: R$" + usuario.getPrecoTotalArrecadado());
			System.out.println("");
			
			totalPrecoJogo = 0;
		}
	}
	
	/**
	 * Metodo utilizado para imprimir os top5 usuarios que possuem mais x2p.
	 */
	
	public void imprimeUsuariosTop5() {
		loja.ordenaUsuarios();
		int i = 0;
		
		for (Usuario usuario : loja.getListaDeUsuarios()) {
			if (i == 5) { 
				return;
			} else {
				System.out.println(usuario.getNome());
			}
			i++;
		}
	}
	
	/**
	 * Metodo utilizado para ordenar os usuarios da lista de usuarios.
	 */
	
	public void ordenaUsuarios(){
		loja.ordenaUsuarios();
	}
	
	/**
	 * Metodo utilizado para retornar a lista de usuarios.
	 * 
	 * @return List<Usuario>
	 */
	
	public List<Usuario> getListaDeUsuarios() {
		return loja.getListaDeUsuarios();
	}
}

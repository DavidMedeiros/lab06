/* 114211306 - David de Medeiros Souza: LAB 6 - Turma 3 */

package Usuario;

import java.util.List;

import Exceptions.DadoInvalidoException;
import Exceptions.EntradaException;
import Exceptions.StringInvalidaException;
import Jogo.CatalogoJogos;
import Jogo.Jogo;

public class Usuario implements Comparable<Usuario> {
	
	private String nome;
	private String login;
	private double precoTotalArrecadado;
	private Jogador jogador;
	
	protected CatalogoJogos catalogoJogos;
	protected int x2p;
	protected double dinheiro;
	protected double precoComDesconto;
	
	/**
	 * Construtor da classe Usuario.
	 * 
	 * @param nome
	 *            Nome do usuario.
	 * @param login
	 *            Login do usuario.
	 */

	public Usuario(String nome, String login) throws EntradaException {
		
		if (nome == null || nome.equals("")){
			throw new StringInvalidaException();
		}
		
		if (login == null || login.equals("")){
			throw new StringInvalidaException();
		}
		
		this.nome = nome;
		this.login = login;
		this.x2p = 0;
		this.dinheiro = 0;	
		this.precoTotalArrecadado = 0;
		this.catalogoJogos = new CatalogoJogos();
		this.jogador = new Noob();
	}
	
	/**
	 * Metodo utilizado para indicar se um usuario ganhou a partida. O x2p é
	 * alterado de acordo com a forma assumida pelo jogador.
	 * 
	 * @param nomeJogo
	 *            Nome do jogo.
	 * @param score
	 *            Score do jogo.
	 * @param zerou
	 *            boolean indicando se zerou o jogo.
	 * @throws DadoInvalidoException
	 */
	
	public void ganhouPartida(String nomeJogo, int score, boolean zerou) throws DadoInvalidoException {
		for (Jogo jogo : getListaDeJogosComprados()) {
			if (jogo.getNome().equals(nomeJogo)) {
				this.x2p += this.jogador.ganhouPartida(jogo, score, zerou);
			}
		}

		if (getX2p() >= 1000) {
			transformaEmVeterano();
		} else {
			transformaEmNoob();
		}
	}

	/**
	 * Metodo utilizado para indicar se um usuario perdeu a partida. O x2p é
	 * alterado de acordo com a forma assumida pelo jogador.
	 * 
	 * @param nomeJogo
	 *            Nome do jogo.
	 * @param score
	 *            Score do jogo.
	 * @param zerou
	 *            boolean indicando se zerou o jogo.
	 * @throws DadoInvalidoException
	 */
	
	public void perdeuPartida(String nomeJogo, int score, boolean zerou) throws DadoInvalidoException {
		for (Jogo jogo : getListaDeJogosComprados()) {
			if (jogo.getNome().equals(nomeJogo)) {
				this.x2p += this.jogador.perdeuPartida(jogo, score, zerou);
			}
		}

		if (getX2p() >= 1000) {
			transformaEmVeterano();
		} else {
			transformaEmNoob();
		}
	}
	
	/**
	 * Metodo utilizado para alterar a instancia de jogador para veterano.
	 */
	
	public void transformaEmVeterano() {
		this.jogador = new Veterano();
	}
	
	/**
	 * Metodo utilizado para alterar a instancia de jogador para noob.
	 */
	
	public void transformaEmNoob() {
		this.jogador = new Noob();
	}


	/**
	 * Metodo responsavel por comprar um jogo
	 * 
	 * @param jogo
	 *            Jogo que sera comprado.
	 * @return Retorna o preco do desconto que sera dado.
	 */

	public double comprarJogo(Jogo jogo) {
		this.precoComDesconto = jogador.calculaPrecoDesconto(jogo.getPreco());
		this.x2p += (int) (jogo.getPreco() * 10);  
		
		if (this.dinheiro >= this.precoComDesconto) {
			catalogoJogos.adicionaJogo(jogo);
			this.dinheiro -= this.precoComDesconto;
		} 
		
		if (getX2p() >= 1000) {
			transformaEmVeterano();

		} else {
			transformaEmNoob();
		}
		
		return precoComDesconto;
	}
	
	/**
	 * Metodo responsavel por adicionar um valor em dinheiro para o usuario.
	 * 
	 * @param valor
	 *            Valor do dinheiro que será adicionado.
	 */
	
	public void adicionaDinheiro(double valor) throws EntradaException {
		if (valor < 0) {
			throw new DadoInvalidoException();
		}
		
		this.dinheiro += valor;
	}
	
	/**
	 * Metodo para retorno do nome de usuario.
	 * 
	 * @return String - Nome do usuario. 
	 */
	
	public String getNome() {
		return nome;
	}
	
	/**
	 * Metodo para retorno do login de usuario.
	 * 
	 * @return String - Login do usuario.
	 */
	
	public String getLogin() {
		return login;
	}
	
	/**
	 * Metodo para retorno do dinheiro de usuario.
	 * 
	 * @return double - Dinheiro do usuario.
	 */	

	public double getDinheiro() {
		return dinheiro;
	}
	
	/**
	 * Metodo para retorno do x2p de usuario.
	 * 
	 * @return int - x2p do usuario.
	 */
	
	public int getX2p() {
		return x2p;
	}
	
	/**
	 * Metodo para retorno da lista de jogos comprados pelo usuario.
	 * 
	 * @return List<Jogo> - Jogos comprados pelo usuario.
	 */
	
	public List<Jogo> getListaDeJogosComprados() {
		return catalogoJogos.getListaDeJogosComprados();
	}
	
	/**
	 * Metodo para retorno do total arrecadado pelo usuario.
	 * 
	 * @return double - Total arrecadado pelo usuario.
	 */
	
	public double getPrecoTotalArrecadado() {
		return precoTotalArrecadado;
	}

	/**
	 * Metodo para atribuir o total arrecadado pelo usuario.
	 */
	
	public void setPrecoTotalArrecadado(double precoArrecadado) {
		this.precoTotalArrecadado += precoArrecadado;
	}

	/**
	 * Metodo para atribuir a lista de jogos comprados de usuario.
	 */
	
	public void setListaDeJogosComprados(List<Jogo> listaDeJogosComprados) {

		catalogoJogos.setListaDeJogosComprados(listaDeJogosComprados);
	}

	/**
	 * Metodo para atribuir a quantidade de x2p do usuario.
	 */
	
	public void setX2p(int x2p) {
		this.x2p = x2p;
	}
	
	/**
	 * Metodo para atribuir o dinheiro do usuario.
	 */
	
	public void setDinheiro(double dinheiro) {
		this.dinheiro = dinheiro;
	}

	/**
	 * Metodo para retorno do catalogo de jogos.
	 * 
	 * @return Catalogo de jogos.
	 */
	
	public CatalogoJogos getCatalogoJogos() {
		return catalogoJogos;
	}
	
	/**
	 * Metodo para a comparacao de um usuario, através da sua quantidade de x2p.
	 * A quantidade é comparada da maior para o menor.
	 */
	
	@Override
	public int compareTo(Usuario outroUsuario) {
		if (outroUsuario.getX2p() < getX2p()){
			return -1;
		}
		if (outroUsuario.getX2p() > getX2p()){
			return 1;
		}
		return 0;
	}

	/**
	 * Metodo para retorno do jogador.
	 * 
	 * @return Jogador.
	 */
	
	public Jogador getJogador() {
		return jogador;
	}
}
/* 114211306 - David de Medeiros Souza: LAB 6- Turma 3 */

// TODO JAVADOC

package Mananger;

import java.util.HashSet;
import java.util.List;

import Exceptions.EntradaException;
import Jogo.Jogabilidade;
import Jogo.Jogo;
import Usuario.Usuario;

public class Façade {
	
	private Controller controller;
	
	public Façade() {
		this.controller = new Controller();
	}
	
	public Jogo criaJogo(String nome, double preco, String tipo, HashSet<Jogabilidade> jogabilidade) {
		try {
			return controller.criaJogo(nome, preco, tipo, jogabilidade);
		} catch (EntradaException e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
	public boolean criaUsuario(String nome, String login) {
		try {
			controller.criaUsuario(nome, login);
			return true;
		} catch (EntradaException e) {
			System.out.println(e.getMessage());
		}
		
		return false;
	}
	
	public void venderJogo(Usuario usuario, Jogo jogo) {
		controller.venderJogo(usuario, jogo);
	}
	
	public boolean adicionaDinheiro(Usuario usuario, double valor) {
		try {
			controller.adicionaDinheiro(usuario, valor);
			return true;
		} catch (EntradaException e) {
			System.out.println(e.getMessage());
		}
		
		return false;
	}
	
	public void imprimeInformacoes() {
		controller.imprimeInformacoes();
	}
	
	public void imprimeUsuariosTop5() {
		controller.imprimeUsuariosTop5();
	}
	
	public List<Usuario> getListaDeUsuarios() {
		return controller.getListaDeUsuarios();
	}
	
	public void ordenaUsuarios(){
		controller.ordenaUsuarios();
	}
}

import java.util.ArrayList;

public class Jogador {
	
	private String nome;
	ArrayList<Carta> mao = new ArrayList<>();
	Jogo jogo;
	
	public Jogador(String nome) {
		this.nome = nome;
	}
	
	public String toString() {
		return nome;
	}
	
	// Métodos
	public void analisarVira() {
		System.out.println(jogo.arrayVira.get(0).getSimbolo());
		System.out.println(jogo.arrayVira.get(0).getCor());
	}
	
	public void analisarMaos() {
		// Ver quantas cartas cada jogador tem nas mãos
	}
	
	public void comprarCarta() {
		
	}
	
	public void receberCarta(Carta recebida) {
		
	}
	
	public void passarVez() {
		
	}
	
	public void gritarUno() {
		
	}
	
	
	
	
	// Getters
	public String getNome() {
		return nome;
	}

	public ArrayList<Carta> getMao() {
		return mao;
	}
	
}

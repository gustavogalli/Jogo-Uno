import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Jogo {
	
	Scanner scanner = new Scanner(System.in);
	public ArrayList<Jogador> arrayJogadores = new ArrayList<>();
	public ArrayList<Carta> arrayDeck = new ArrayList<>();
	public ArrayList<Carta> arrayVira = new ArrayList<>();

	
	
	public void welcome() {
		System.out.println("Olá! Qual é seu nome?");
		String nome = scanner.next();
		this.adicionarJogador(nome);
		
		System.out.println("Quantos adversários você quer enfrentar, " + nome + "?");
		int qtdeAdversarios = scanner.nextInt();
		this.adicionarBot(qtdeAdversarios);
	
	}
	
	void imprimeJogadores() {
		System.out.println(arrayJogadores);
	}
	
	void adicionarJogador(String nome) {
		arrayJogadores.add(new Jogador(nome));
	}
	
	void adicionarBot(int qtdeBots) {
		for(int i = 0; i < qtdeBots; i++) {
			this.adicionarJogador("Bot" + (i + 1));
		}
	}
	
	public void iniciarJogo() {
		montarDeck();
		embaralhar();
		distribuirCartas();
		imprimirVira();
		imprimirMao();
		
	}
	
	public void montarDeck() {
		// Adicionar números
		String[] numeros = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		String[] cores = {"vermelho", "azul", "amarelo", "verde"};

		for(String numero: numeros) {
			for(String cor: cores) {
				arrayDeck.add(new Carta(numero, cor));
				if (numero != "0") {
					arrayDeck.add(new Carta(numero, cor));
				}
			}
		}
		
		// Adiciona especiais
		String[] especiais = {"+2", "Pular", "Inverter"};
		
		for(String especial: especiais) {
			for(String cor: cores) {
				arrayDeck.add(new Carta(especial, cor));
				arrayDeck.add(new Carta(especial, cor));
			}
		}
		
		// Adiciona coringas
		String[] coringas = {"mudaCor", "+4"};
		for(String coringa: coringas) {
			for(int i = 0; i < cores.length; i++) {
				arrayDeck.add(new Carta(coringa, "preto"));
			}
		}
	}
	
	public void embaralhar() {
		Collections.shuffle(arrayDeck);
	}
	
	public void distribuirCartas() {
		for(int i = 0; i < 7; i++) {
			for(Jogador jogador: arrayJogadores) {
				jogador.mao.add(arrayDeck.get(0));
				arrayDeck.remove(0);
			}
		}
		arrayVira.add(arrayDeck.get(0));
		System.out.println("----- HORA DO JOGO -----");
	}
	
	public void imprimirMao() {
		System.out.println("\n[SUA MÃO]\n");
		for(int i = 0; i < arrayJogadores.get(0).mao.size(); i++) {
			System.out.println("[" + i + "] " + arrayJogadores.get(0).mao.get(i));
		}
	}
	
	public void imprimirVira() {
		System.out.println("[VIRA] " + arrayVira.get(0));
	}
	
	public void inverterSentido() {
		
	}
	
	
	

}

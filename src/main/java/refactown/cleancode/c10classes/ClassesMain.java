package refactown.cleancode.c10classes;

import refactown.cleancode.c10classes.model.*;

public class ClassesMain {

	public static void main(String[] args) {
		Jogador bill = new Jogador("Bill (Primeiro)");
		Jogador bob = new Jogador("Bob (Segundo)");
		// Selecao da implementacao da interface Jogada
		Jogada jogada = new JogadaSimples(bill, bob);
		MelhorDeTres melhorDeTres = new MelhorDeTres(jogada, 5);

		// Objeto, encapsula função jogar()
		melhorDeTres.jogar();
		// Print
		if (melhorDeTres.temVencedor()) {
			// Não traz a regra de calculo do vencedor para o main, acessa o .getVencedor()
			System.out.println("Vencedor: " + melhorDeTres.getVencedor().getNome());
		} else {
			System.out.println("Empate");
		}
		System.out.println("Resultados:" + melhorDeTres.getResultados());
	}
}

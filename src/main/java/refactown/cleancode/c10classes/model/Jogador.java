package refactown.cleancode.c10classes.model;

import refactown.cleancode.c10classes.enums.Mao;

public class Jogador {
	private final String nome;
	public Jogador(String nome) {super(); this.nome = nome;}
	public Mao jogar() { // escolher uma mão (pedra, papel, tesoura)
		return Mao.aleatoria();
	}
	public String getNome() {
		return nome;
	}
	@Override
	public String toString() {
		return "Jogador [nome=" + nome + "]";
	}
}

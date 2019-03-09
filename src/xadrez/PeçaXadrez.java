package xadrez;

import tabuleiro.Peça;
import tabuleiro.Tabuleiro;

public abstract class PeçaXadrez extends Peça {
	
	private Cores cor;

	public PeçaXadrez(Tabuleiro tabuleiro, Cores cor) {
		super(tabuleiro);
		this.cor = cor;
	}

	public Cores getCor() {
		return cor;
	}
}

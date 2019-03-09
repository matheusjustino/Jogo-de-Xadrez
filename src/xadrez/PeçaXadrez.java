package xadrez;

import tabuleiro.Pe�a;
import tabuleiro.Tabuleiro;

public abstract class Pe�aXadrez extends Pe�a {
	
	private Cores cor;

	public Pe�aXadrez(Tabuleiro tabuleiro, Cores cor) {
		super(tabuleiro);
		this.cor = cor;
	}

	public Cores getCor() {
		return cor;
	}
}

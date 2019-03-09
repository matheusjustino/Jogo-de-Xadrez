package xadrez;

import tabuleiro.Pe�a;
import tabuleiro.Posicao;
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
	
	protected boolean existePe�aOponenteNoDestino(Posicao posicao) {
		Pe�aXadrez p = (Pe�aXadrez) getTabuleiro().pe�a(posicao);
		return p != null && p.getCor() != this.cor;
	}
}

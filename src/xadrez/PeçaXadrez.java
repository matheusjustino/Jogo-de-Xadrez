package xadrez;

import tabuleiro.Peça;
import tabuleiro.Posicao;
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
	
	protected boolean existePeçaOponenteNoDestino(Posicao posicao) {
		PeçaXadrez p = (PeçaXadrez) getTabuleiro().peça(posicao);
		return p != null && p.getCor() != this.cor;
	}
}

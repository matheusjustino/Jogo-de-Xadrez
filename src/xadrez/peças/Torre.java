package xadrez.peças;

import tabuleiro.Tabuleiro;
import xadrez.Cores;
import xadrez.PeçaXadrez;

public class Torre extends PeçaXadrez {

	public Torre(Tabuleiro tabuleiro, Cores cor) {
		super(tabuleiro, cor);
	}

	@Override
	public String toString() {
		return "T";
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] matriz = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		return matriz;
	}
}

package xadrez;

import tabuleiro.Tabuleiro;
import xadrez.pe�as.Rei;
import xadrez.pe�as.Torre;

public class PartidaXadrez {

	private Tabuleiro tabuleiro;

	public PartidaXadrez() {
		this.tabuleiro = new Tabuleiro(8, 8);
		iniciando();
	}

	public Pe�aXadrez[][] getPe�as() {
		Pe�aXadrez[][] matriz = new Pe�aXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];

		for (int i = 0; i < tabuleiro.getLinhas(); i++) {
			for (int j = 0; j < tabuleiro.getColunas(); j++) {
				matriz[i][j] = (Pe�aXadrez) tabuleiro.pe�a(i, j);
			}
		}
		return matriz;
	}

	private void novaPe�a(char coluna, int linha, Pe�aXadrez pe�a) {
		tabuleiro.localPe�a(pe�a, new PosicaoXadrez(coluna, linha).paraPosicao());
	}

	private void iniciando() {
		novaPe�a('c', 1, new Torre(tabuleiro, Cores.WHITE));
		novaPe�a('c', 2, new Torre(tabuleiro, Cores.WHITE));
		novaPe�a('d', 2, new Torre(tabuleiro, Cores.WHITE));
		novaPe�a('e', 2, new Torre(tabuleiro, Cores.WHITE));
		novaPe�a('e', 1, new Torre(tabuleiro, Cores.WHITE));
		novaPe�a('d', 1, new Rei(tabuleiro, Cores.WHITE));

		novaPe�a('c', 7, new Torre(tabuleiro, Cores.BLACK));
		novaPe�a('c', 8, new Torre(tabuleiro, Cores.BLACK));
		novaPe�a('d', 7, new Torre(tabuleiro, Cores.BLACK));
		novaPe�a('e', 7, new Torre(tabuleiro, Cores.BLACK));
		novaPe�a('e', 8, new Torre(tabuleiro, Cores.BLACK));
		novaPe�a('d', 8, new Rei(tabuleiro, Cores.BLACK));
	}
}

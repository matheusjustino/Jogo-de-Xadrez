package xadrez;

import tabuleiro.Tabuleiro;
import xadrez.peças.Rei;
import xadrez.peças.Torre;

public class PartidaXadrez {
	
	private Tabuleiro tabuleiro;
	
	public PartidaXadrez() {
		this.tabuleiro = new Tabuleiro(8, 8);
		iniciando();
	}
	
	public PeçaXadrez[][] getPeças() {
		PeçaXadrez[][] matriz = new PeçaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		
		for (int i = 0; i < tabuleiro.getLinhas(); i++) {
			for (int j = 0; j < tabuleiro.getColunas(); j++) {
				matriz[i][j] = (PeçaXadrez) tabuleiro.peça(i, j);
			}
		}
		return matriz;
	}
	
	private void novaPeça(char coluna, int linha, PeçaXadrez peça) {
		tabuleiro.localPeça(peça, new PosicaoXadrez(coluna, linha).paraPosicao());
	}
	
	private void iniciando() {
		novaPeça('b', 6, new Torre(tabuleiro, Cores.WHITE));
		novaPeça('a', 3, new Rei(tabuleiro, Cores.BLACK));
		novaPeça('d', 2, new Torre(tabuleiro, Cores.WHITE));
	}
}

package xadrez;

import tabuleiro.Posicao;
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
	
	private void iniciando() {
		tabuleiro.localPeça(new Torre(tabuleiro, Cores.WHITE), new Posicao(2, 1));
		tabuleiro.localPeça(new Rei(tabuleiro, Cores.BLACK), new Posicao(0, 4));

	}
}

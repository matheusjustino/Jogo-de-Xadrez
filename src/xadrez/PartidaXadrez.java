package xadrez;

import tabuleiro.Posicao;
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
	
	private void iniciando() {
		tabuleiro.localPe�a(new Torre(tabuleiro, Cores.WHITE), new Posicao(2, 1));
		tabuleiro.localPe�a(new Rei(tabuleiro, Cores.BLACK), new Posicao(0, 4));

	}
}

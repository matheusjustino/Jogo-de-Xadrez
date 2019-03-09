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
		novaPe�a('b', 6, new Torre(tabuleiro, Cores.WHITE));
		novaPe�a('a', 3, new Rei(tabuleiro, Cores.BLACK));
		novaPe�a('d', 2, new Torre(tabuleiro, Cores.WHITE));
	}
}

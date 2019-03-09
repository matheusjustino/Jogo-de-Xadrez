package tabuleiro;

public abstract class Peça {
	
	protected Posicao posicao;
	private Tabuleiro tabuleiro;
	
	public Peça(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		this.posicao = null;
	}

	protected Tabuleiro getTabuleiro() {
		return tabuleiro;
	}
	
	public abstract boolean[][] movimentosPossiveis();
	
	public boolean possivelMovimento(Posicao posicao) {
		return movimentosPossiveis()[posicao.getLinha()][posicao.getColuna()];
	}
	
	public boolean existeAlgumMovimentoPossivel() {
		boolean[][] matriz = movimentosPossiveis();
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				if (matriz[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
}

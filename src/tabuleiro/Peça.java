package tabuleiro;

public class Pe�a {
	
	protected Posicao posicao;
	private Tabuleiro tabuleiro;
	
	public Pe�a(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		this.posicao = null;
	}

	protected Tabuleiro getTabuleiro() {
		return tabuleiro;
	}
}

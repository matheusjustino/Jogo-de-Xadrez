package tabuleiro;

public class Tabuleiro {
	
	private int linhas;
	private int colunas;
	private Pe�a[][] pe�as;
	
	public Tabuleiro(int linhas, int colunas) {
		this.linhas = linhas;
		this.colunas = colunas;
		this.pe�as = new Pe�a[linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}

	public void setLinhas(int linhas) {
		this.linhas = linhas;
	}

	public int getColunas() {
		return colunas;
	}

	public void setColunas(int colunas) {
		this.colunas = colunas;
	}
	
	public Pe�a pe�a(int linha, int coluna) {
		return this.pe�as[linha][coluna];
	}
	
	public Pe�a pe�a(Posicao posicao) {
		return this.pe�as[posicao.getLinha()][posicao.getColuna()];
	}
	
	public void localPe�a(Pe�a pe�a, Posicao posicao) {
		this.pe�as[posicao.getLinha()][posicao.getColuna()] = pe�a;
		pe�a.posicao = posicao;
	}
}

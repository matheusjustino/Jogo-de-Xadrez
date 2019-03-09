package tabuleiro;

public class Tabuleiro {
	
	private int linhas;
	private int colunas;
	private Pe�a[][] pe�as;
	
	public Tabuleiro(int linhas, int colunas) {
		if (linhas < 1 || colunas < 1) {
			throw new TabuleiroException("Erro na cria��o do tabuleiro: � necess�rio ao menos 1 linha e 1 coluna");
		}
		this.linhas = linhas;
		this.colunas = colunas;
		this.pe�as = new Pe�a[linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}
	
	public Pe�a pe�a(int linha, int coluna) {
		if (!existePosicao(linha, coluna)) {
			throw new TabuleiroException("N�o existe esta posi��o no tabuleiro");
		}
		return this.pe�as[linha][coluna];
	}
	
	public Pe�a pe�a(Posicao posicao) {
		if (!existePosicao(posicao)) {
			throw new TabuleiroException("N�o existe esta posi��o no tabuleiro");
		}
		return this.pe�as[posicao.getLinha()][posicao.getColuna()];
	}
	
	public void localPe�a(Pe�a pe�a, Posicao posicao) {
		if (existePe�a(posicao)) {
			throw new TabuleiroException("J� existe pe�a nesta posicao " + posicao);
		}
		this.pe�as[posicao.getLinha()][posicao.getColuna()] = pe�a;
		pe�a.posicao = posicao;
	}
	
	public Pe�a removePe�a(Posicao posicao) {
		if (!existePosicao(posicao)) {
			throw new TabuleiroException("N�o existe esta posi��o no tabuleiro");
		}
		if (pe�a(posicao) == null) {
			return null;
		}
		Pe�a aux = pe�a(posicao);
		aux.posicao = null;
		this.pe�as[posicao.getLinha()][posicao.getColuna()] = null;
		return aux;
	}
	
	private boolean existePosicao(int linha, int coluna) {
		// linha >= 0 && linha < tabuleiro.length(quant de linhas) coluna >= 0 && coluna < tabuleiro.length(quant de colunas)
		return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
	}
	
	public boolean existePosicao(Posicao posicao) {
		return existePosicao(posicao.getLinha(), posicao.getColuna());
	}
	
	public boolean existePe�a(Posicao posicao) {
		if (!existePosicao(posicao)) {
			throw new TabuleiroException("N�o existe esta posi��o no tabuleiro");
		}
		return pe�a(posicao) != null;
	}
}

package tabuleiro;

public class Tabuleiro {
	
	private int linhas;
	private int colunas;
	private Peça[][] peças;
	
	public Tabuleiro(int linhas, int colunas) {
		if (linhas < 1 || colunas < 1) {
			throw new TabuleiroException("Erro na criação do tabuleiro: É necessário ao menos 1 linha e 1 coluna");
		}
		this.linhas = linhas;
		this.colunas = colunas;
		this.peças = new Peça[linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}
	
	public Peça peça(int linha, int coluna) {
		if (!existePosicao(linha, coluna)) {
			throw new TabuleiroException("Não existe esta posição no tabuleiro");
		}
		return this.peças[linha][coluna];
	}
	
	public Peça peça(Posicao posicao) {
		if (!existePosicao(posicao)) {
			throw new TabuleiroException("Não existe esta posição no tabuleiro");
		}
		return this.peças[posicao.getLinha()][posicao.getColuna()];
	}
	
	public void localPeça(Peça peça, Posicao posicao) {
		if (existePeça(posicao)) {
			throw new TabuleiroException("Já existe peça nesta posicao " + posicao);
		}
		this.peças[posicao.getLinha()][posicao.getColuna()] = peça;
		peça.posicao = posicao;
	}
	
	public Peça removePeça(Posicao posicao) {
		if (!existePosicao(posicao)) {
			throw new TabuleiroException("Não existe esta posição no tabuleiro");
		}
		if (peça(posicao) == null) {
			return null;
		}
		Peça aux = peça(posicao);
		aux.posicao = null;
		this.peças[posicao.getLinha()][posicao.getColuna()] = null;
		return aux;
	}
	
	private boolean existePosicao(int linha, int coluna) {
		// linha >= 0 && linha < tabuleiro.length(quant de linhas) coluna >= 0 && coluna < tabuleiro.length(quant de colunas)
		return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
	}
	
	public boolean existePosicao(Posicao posicao) {
		return existePosicao(posicao.getLinha(), posicao.getColuna());
	}
	
	public boolean existePeça(Posicao posicao) {
		if (!existePosicao(posicao)) {
			throw new TabuleiroException("Não existe esta posição no tabuleiro");
		}
		return peça(posicao) != null;
	}
}

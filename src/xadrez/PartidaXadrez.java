package xadrez;

import java.awt.Color;

import tabuleiro.Pe�a;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.pe�as.Rei;
import xadrez.pe�as.Torre;

public class PartidaXadrez {
	
	private int turno;
	private Cores jogadorAtual;
	private Tabuleiro tabuleiro;

	public PartidaXadrez() {
		this.tabuleiro = new Tabuleiro(8, 8);
		this.turno = 1;
		this.jogadorAtual = Cores.WHITE;
		iniciando();
	}
	
	public int getTurno() {
		return this.turno;
	}
	
	public Cores getJogadorAtual() {
		return this.jogadorAtual;
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
	
	public boolean[][] possiveisMovimentos(PosicaoXadrez posicaoOrgem) {
		Posicao posicao = posicaoOrgem.paraPosicao();
		validarPosicaoOrigem(posicao);
		return tabuleiro.pe�a(posicao).movimentosPossiveis();
	}
	
	public Pe�aXadrez moverPe�a(PosicaoXadrez posicaoOrigem, PosicaoXadrez posicaoDestino) {
		Posicao origem = posicaoOrigem.paraPosicao();
		Posicao destino = posicaoDestino.paraPosicao();
		validarPosicaoOrigem(origem);
		validarPosicaoDestino(origem, destino);
		Pe�a pe�aCapturada = fazerMovimento(origem, destino);
		proximoTurno();
		return (Pe�aXadrez) pe�aCapturada;
	}
	
	private Pe�a fazerMovimento(Posicao origem, Posicao destino) {
		Pe�a p = tabuleiro.removePe�a(origem);
		Pe�a pe�aCapturada = tabuleiro.removePe�a(destino);
		tabuleiro.localPe�a(p, destino);
		return pe�aCapturada;
	}
	
	private void validarPosicaoDestino(Posicao origem, Posicao destino) {
		if (!tabuleiro.pe�a(origem).possivelMovimento(destino)) {
			throw new XadrezException("A pe�a escolhida n�o pode se mover para a posi��o de destino");
		}
	}
	
	private void validarPosicaoOrigem(Posicao posicao) {
		if (!tabuleiro.existePe�a(posicao)) {
			throw new XadrezException("N�o existe pe�a na posi��o de origem");
		}
		if (this.jogadorAtual != ((Pe�aXadrez) tabuleiro.pe�a(posicao)).getCor()) {
			throw new XadrezException("A pe�a escolhida n�o � sua");
		}
		if (!tabuleiro.pe�a(posicao).existeAlgumMovimentoPossivel()) {
			throw new XadrezException("N�o h� movimentos poss�veis para esta pe�a");
		}
	}
	
	private void proximoTurno() {
		this.turno++;
		this.jogadorAtual = (this.jogadorAtual == Cores.WHITE) ? Cores.BLACK : Cores.WHITE;
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

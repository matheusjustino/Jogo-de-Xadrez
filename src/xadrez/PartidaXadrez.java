package xadrez;

import tabuleiro.Peça;
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
	
	public PeçaXadrez moverPeça(PosicaoXadrez posicaoOrigem, PosicaoXadrez posicaoDestino) {
		Posicao origem = posicaoOrigem.paraPosicao();
		Posicao destino = posicaoDestino.paraPosicao();
		validarPosicaoOrigem(origem);
		validarPosicaoDestino(origem, destino);
		Peça peçaCapturada = fazerMovimento(origem, destino);
		return (PeçaXadrez) peçaCapturada;
	}
	
	private Peça fazerMovimento(Posicao origem, Posicao destino) {
		Peça p = tabuleiro.removePeça(origem);
		Peça peçaCapturada = tabuleiro.removePeça(destino);
		tabuleiro.localPeça(p, destino);
		return peçaCapturada;
	}
	
	private void validarPosicaoDestino(Posicao origem, Posicao destino) {
		if (!tabuleiro.peça(origem).possivelMovimento(destino)) {
			throw new XadrezException("A peça escolhida não pode se mover para a posição de destino");
		}
	}
	
	private void validarPosicaoOrigem(Posicao posicao) {
		if (!tabuleiro.existePeça(posicao)) {
			throw new XadrezException("Não existe peça na posição de origem");
		}
		if (!tabuleiro.peça(posicao).existeAlgumMovimentoPossivel()) {
			throw new XadrezException("Não há movimentos possíveis para esta peça");
		}
	}
	
	private void novaPeça(char coluna, int linha, PeçaXadrez peça) {
		tabuleiro.localPeça(peça, new PosicaoXadrez(coluna, linha).paraPosicao());
	}

	private void iniciando() {
		novaPeça('c', 1, new Torre(tabuleiro, Cores.WHITE));
		novaPeça('c', 2, new Torre(tabuleiro, Cores.WHITE));
		novaPeça('d', 2, new Torre(tabuleiro, Cores.WHITE));
		novaPeça('e', 2, new Torre(tabuleiro, Cores.WHITE));
		novaPeça('e', 1, new Torre(tabuleiro, Cores.WHITE));
		novaPeça('d', 1, new Rei(tabuleiro, Cores.WHITE));

		novaPeça('c', 7, new Torre(tabuleiro, Cores.BLACK));
		novaPeça('c', 8, new Torre(tabuleiro, Cores.BLACK));
		novaPeça('d', 7, new Torre(tabuleiro, Cores.BLACK));
		novaPeça('e', 7, new Torre(tabuleiro, Cores.BLACK));
		novaPeça('e', 8, new Torre(tabuleiro, Cores.BLACK));
		novaPeça('d', 8, new Rei(tabuleiro, Cores.BLACK));
	}
}

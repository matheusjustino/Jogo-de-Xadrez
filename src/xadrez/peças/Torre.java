package xadrez.pe�as;

import tabuleiro.Tabuleiro;
import xadrez.Cores;
import xadrez.Pe�aXadrez;

public class Torre extends Pe�aXadrez {

	public Torre(Tabuleiro tabuleiro, Cores cor) {
		super(tabuleiro, cor);
	}
	
	@Override
	public String toString() {
		return "T";
	}
}

package xadrez.peças;

import tabuleiro.Tabuleiro;
import xadrez.Cores;
import xadrez.PeçaXadrez;

public class Rei extends PeçaXadrez {

	public Rei(Tabuleiro tabuleiro, Cores cor) {
		super(tabuleiro, cor);
	}
	
	@Override
	public String toString() {
		return "K";
	}
}

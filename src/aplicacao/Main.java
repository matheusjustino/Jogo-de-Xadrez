package aplicacao;

import java.util.Scanner;

import xadrez.PartidaXadrez;
import xadrez.PeçaXadrez;
import xadrez.PosicaoXadrez;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		PartidaXadrez partidaXadrez = new PartidaXadrez();
		while (true) {
			UI.printTabuleiro(partidaXadrez.getPeças());
			System.out.println();
			System.out.print("Origem: ");
			PosicaoXadrez origem = UI.lerPosicaoXadrez(sc);
			
			System.out.println();
			System.out.print("Destino: ");
			PosicaoXadrez desino = UI.lerPosicaoXadrez(sc);
			
			PeçaXadrez peçaCapturada = partidaXadrez.moverPeça(origem, desino);
		}
	}

}

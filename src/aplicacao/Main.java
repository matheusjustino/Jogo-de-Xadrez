package aplicacao;

import java.util.InputMismatchException;
import java.util.Scanner;

import xadrez.PartidaXadrez;
import xadrez.Pe�aXadrez;
import xadrez.PosicaoXadrez;
import xadrez.XadrezException;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		PartidaXadrez partidaXadrez = new PartidaXadrez();
		
		while (true) {
			try {
				UI.limparTela();
				UI.printTabuleiro(partidaXadrez.getPe�as());
				System.out.println();
				System.out.print("Origem: ");
				PosicaoXadrez origem = UI.lerPosicaoXadrez(sc);
				
				System.out.println();
				System.out.print("Destino: ");
				PosicaoXadrez desino = UI.lerPosicaoXadrez(sc);
				
				Pe�aXadrez pe�aCapturada = partidaXadrez.moverPe�a(origem, desino);
			}
			catch (XadrezException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
	}

}

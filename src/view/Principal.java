package view;

import java.util.concurrent.Semaphore;

import controller.Piloto;
import controller.ThreadCorrida;

public class Principal {
	public static void main(String[] args) {
		int carro = 1;
		Semaphore semaforoPista = new Semaphore(5);
		Semaphore [] semaforoEquipe = new Semaphore[7];
		
		Piloto piloto[] = new Piloto[14];
		for (int i = 0; i<piloto.length; i++) {
			piloto[i] = new Piloto();
		}
		
		for (int i = 0; i<7; i++) {
			semaforoEquipe[i] = new Semaphore(1);
			Thread carro1 = new ThreadCorrida(carro, i, semaforoPista, semaforoEquipe, piloto);
			carro++;
			Thread carro2 = new ThreadCorrida(carro, i, semaforoPista, semaforoEquipe, piloto);
			carro++;
			carro1.start();
			carro2.start();
		}
	}

}

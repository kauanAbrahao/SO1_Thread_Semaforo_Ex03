package controller;

import java.util.Arrays;
import java.util.concurrent.Semaphore;

public class ThreadCorrida extends Thread	 {
	private int equipe;
	private String nomeEquipe;
	private Semaphore semaforoPista;
	private Semaphore semaforoEquipes[];
	private double tempo;
	private int carro;
	private Piloto piloto[];
	private static int count;
	Semaphore semaforoPs = new Semaphore(1);
	private double maior;
	
	public ThreadCorrida(int carro, int equipe, Semaphore semaforoPista, Semaphore semaforoEquipes[], Piloto piloto[]) {
		this.equipe = equipe;
		this.semaforoPista = semaforoPista;
		this.semaforoEquipes = semaforoEquipes;
		this.carro = carro;
		this.piloto = piloto;
	
	}
	
	public void run() {
		switch(equipe) {
		case 0: nomeEquipe = "Ferrari";
		break;
		
		case 1: nomeEquipe = "AlphaTauri";
		break;
		
		case 2: nomeEquipe = "Mercedes";
		break;
		
		case 3: nomeEquipe = "Renault";
		break;
		
		case 4: nomeEquipe = "Williams";
		break;
		
		case 5: nomeEquipe = "Haas";
		break;
		
		case 6: nomeEquipe = "McLaren";
		break;
		}
		
		try {
			semaforoEquipes[equipe].acquire();
			semaforoPista.acquire();
			corridaPista();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforoPista.release();
			semaforoEquipes[equipe].release();
		}
		
		try {
			semaforoPs.acquire();
			mostraGrid();
		}catch (InterruptedException e){
			e.printStackTrace();
		} finally {
			semaforoPs.release();
		}
		
		
	}
	
	private void corridaPista() {
		
		for (int i = 0; i<3; i++) {
			tempo = (Math.random() * 8)+6;
			try{
				sleep((long) (tempo + 2000));
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			if (tempo > maior) {
				this.maior = tempo;
			}
			System.out.println("O piloto " + carro + " da equipe " + nomeEquipe + " deu a sua " + (i+1) +"° volta em " + tempo + " minutos!" );
		}
		piloto[carro-1].setCarro(carro);
		piloto[carro-1].setEquipe(nomeEquipe);
		piloto[carro-1].setTempo(maior);
		
	}
				
	

	private void mostraGrid() {
		count++;
		if (count == 14) {
			System.out.println("TODOS OS PILOTOS TERMINARAM!!!!!");
			
			Arrays.sort(piloto);
				
		
		System.out.println("\n" + "GRID DE LARGADA: ");
		for (int i = 0; i<14; i++) {
			System.out.println((i+1) + "° lugar: Piloto: " + piloto[13-i].getCarro() + " | Equipe: " + piloto[13-i].getEquipe() + " | Tempo: " +
			piloto[13-i].getTempo() + "minutos");
		}
		}
	}
	
	
}


	
	



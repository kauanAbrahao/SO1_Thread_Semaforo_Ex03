package controller;

public class Piloto implements Comparable<Piloto> {
	private String equipe;
	private int carro;
	private double tempo;
	
	public String getEquipe() {
		return equipe;
	}
	public void setEquipe(String equipe) {
		this.equipe = equipe;
	}
	public int getCarro() {
		return carro;
	}
	public void setCarro(int carro) {
		this.carro = carro;
	}
	public double getTempo() {
		return tempo;
	}
	public void setTempo(double tempo2) {
		this.tempo = tempo2;
	}
	
	public int compareTo(Piloto comparaPiloto) {
		double comparaTempo = comparaPiloto.getTempo();
//		 return (int) (this.tempo - comparaTempo);
		if (comparaTempo < this.tempo) {
			return -1;
		}
		else {
			if (comparaTempo > this.tempo) {
				return 1;
			}
			else {
				return 0;
			}
		}
		
		
	}
	

}

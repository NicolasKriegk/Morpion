package model;

public class Coup {
	
	private Joueur joueur;
	private int coord1;
	private int coord2;
	
	public Coup() {
		
	}
	
	public int getCoord2() {
		return coord2;
	}
	public void setCoord2(int coord2) {
		this.coord2 = coord2;
	}
	public int getCoord1() {
		return coord1;
	}
	public void setCoord1(int coord1) {
		this.coord1 = coord1;
	}
	public Joueur getJoueur() {
		return joueur;
	}
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}
	
	

}

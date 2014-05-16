package model;

public class Coup {
	
	private Joueur joueur;
	private int coordx;
	private int coordy;
	
	public Coup() {		
	}
	
	public int getCoordy() {
		return coordy;
	}
	public void setCoordy(int coord2) {
		this.coordy = coord2;
	}
	public int getCoordx() {
		return coordx;
	}
	public void setCoordx(int coord1) {
		this.coordx = coord1;
	}
	public Joueur getJoueur() {
		return joueur;
	}
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}
		
}

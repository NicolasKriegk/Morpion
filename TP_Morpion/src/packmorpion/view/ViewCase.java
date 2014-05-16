package packmorpion.view;

public class ViewCase {
	//coordonnees de la case
	private int coordCoinHG;
	private int coordCentre;
	//dimensions de la case
	private int largeur;
	private int hauteur;
	//numerotation de la case pour passage au modele  
	private int[][] numero;
	
	public int getCoordCoinHG() {
		return coordCoinHG;
	}
	public void setCoordCoinHG(int coordCoinHG) {
		this.coordCoinHG = coordCoinHG;
	}
	public int getCoordCentre() {
		return coordCentre;
	}
	public void setCoordCentre(int coordCentre) {
		this.coordCentre = coordCentre;
	}
	public int getLargeur() {
		return largeur;
	}
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}
	public int getHauteur() {
		return hauteur;
	}
	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}
	public int[][] getNumero() {
		return numero;
	}
	public void setNumero(int[][] numero) {
		this.numero = numero;
	}
}

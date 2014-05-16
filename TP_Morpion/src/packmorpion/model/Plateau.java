package packmorpion.model;

public class Plateau {
	
	private int ligne;
	private int colonne;
	private int nbre_aligne;
	
	public Plateau(int ligne,int colonne,int nbr_aligne) {
		
		this.ligne = ligne;
		this.colonne = colonne;
		this.nbre_aligne = nbr_aligne;
		
	}

	public int getColonne() {
		return colonne;
	}

	public void setColonne(int colonne) {
		this.colonne = colonne;
	}

	public int getLigne() {
		return ligne;
	}

	public void setLigne(int ligne) {
		this.ligne = ligne;
	}

	public int getNbre_aligne() {
		return nbre_aligne;
	}

	public void setNbre_aligne(int nbre_aligne) {
		this.nbre_aligne = nbre_aligne;
	}	

}

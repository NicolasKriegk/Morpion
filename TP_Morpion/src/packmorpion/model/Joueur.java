package packmorpion.model;

public class Joueur {
	
	// symbole du joueur X ou O
	private String symbole;
	private String nom;
	
	public Joueur(String symb) {	
		this.setSymbole(symb);		
	}

	public String getSymbole() {
		return symbole;
	}

	public void setSymbole(String symbole) {
		this.symbole = symbole;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}

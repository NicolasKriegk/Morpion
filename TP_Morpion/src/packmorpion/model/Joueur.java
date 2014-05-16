package packmorpion.model;

public class Joueur {
	
	// symbole du joueur X ou O
	private String symbole;
	
	public Joueur(String symb) {	
		this.setSymbole(symb);		
	}

	public String getSymbole() {
		return symbole;
	}

	public void setSymbole(String symbole) {
		this.symbole = symbole;
	}

}

package packmorpion.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * 
 * @author imie
 */

public class ModelMorp extends Observable {

	private List<Joueur> joueurs = new ArrayList<Joueur>(); // attributs
															// symboles ???
	private Plateau plateau = null; // attributs dimension
	private List<Coup> coups = new ArrayList<Coup>();; // attributs joueurs
	//private List<Coup> coupsA = new ArrayList<Coup>();
	//private List<Coup> coupsB = new ArrayList<Coup>();

	// -----------------------------------------------------------
	// méthodes modele

	public void partie() {

		// mettre dans un init partie
		// enregistrement joueurs
		Joueur joueurA = new Joueur("A");
		Joueur joueurB = new Joueur("B");
		Joueur joueur_courrant = joueurA;

		joueurs.add(joueurA);
		joueurs.add(joueurB);
		// setJoueur();
		// setPlateau();

		String resultat = "encours";

		setPlateau(3, 3, 3);
		int min = 1;
		int max = 3;
		int essai = 1;

		//
		while ((resultat == "encours") && reste_coup_grille()) {
			// for (int i = 1; i <= 9; i++) {
			System.out.println("Tour =============================== Essai"+essai);
			System.out.println("Joueur : "+joueur_courrant.getSymbole());
			// Joueur joue
			int nbreAlx = min + (int) (Math.random() * ((max - min) + 1));
			int nbreAly = min + (int) (Math.random() * ((max - min) + 1));
			// lecture de la config (plateau...)
			Coup coup_joue = new Coup();
			coup_joue.setCoordx(nbreAlx);
			coup_joue.setCoordy(nbreAly);
			coup_joue.setJoueur(joueur_courrant);

			// attente que le joueur clique
			System.out.println("Joue " + nbreAlx + " / " + nbreAly);

			// test possible ou deja joue et ajoute
			if (valid_coup_joue(coup_joue)) {
				coups.add(coup_joue);
				resultat = resultat_coup(coup_joue);
				System.out.println("on change de joueur");
				joueur_courrant = change_joueur(joueur_courrant);
			} else {
				System.out.println("Non valide, pas ajouté");
				System.out.println("meme joueur");
			}

			essai++;

			aff_plateau(coups);
		}
		
		System.out.println(resultat);
		System.out.println("reste coup :"+reste_coup_grille());

	}

	// procédure d'ajout d'un nouveau coup à la liste de coup
	// teste si existe et ajoute
	// 1ere procedure
	public Boolean valid_coup_joue(Coup coup_joue) {
		// System.out.println("----------- add_joue_coup");
		// le joueur qui a joué est connu par coup_joue
		Boolean exist = coup_existe_liste(coup_joue);
		//System.out.println("Cond 1 : coup existe ds liste complete ? " + exist);
		Boolean possible = coup_possible_grille(coup_joue);
		//System.out.println("Cond 2 : coup possible grille ? " + possible);
		// if (possible && !exist) {
		// coups.add(coup_joue);
		System.out.println("Coup Valide "+possible+exist);
		System.out.println("(taille ok et non joué) dc +1 : "+ coups.size());
		// }

		return (possible && !exist);
	}

	// verification si le coup est existe : vrai si existe / faux sinon
	// juste coordonnées
	// ne donne pas si joué par le bon joueur
	public Boolean coup_existe_liste(Coup coup_joue) {
		Boolean valid = false;
		for (Coup cur_coup : coups) {

			// on regarde la 1ere coordonnée des coups deja joués
			if (cur_coup.getCoordx() == coup_joue.getCoordx()) {
				// si identique
				// on regarde la 2eme coordonnée
				if (cur_coup.getCoordy() == coup_joue.getCoordy()) {
					// si identique le coup est impossible
					valid = true;
					System.out
							.println("Coup existe dans liste complete !");
				}
			}
		}
		return valid;
	}

	// liste de coup d'un joueur + coup joue
	public Boolean coup_possible_grille(Coup coup_joue) {
		Boolean valid = false;
		// 1ere coordonnée des coups deja joués
		if (coup_joue.getCoordx() <= plateau.getLigne()) {
			//System.out.println("ligne possible");
			if (coup_joue.getCoordy() <= plateau.getColonne()) {	
				valid = true;
			}
		}
		return valid;
	}

	public Boolean reste_coup_grille() {
		int nbre_coup = plateau.getColonne() * plateau.getLigne();
		Boolean reste_coup = (nbre_coup > coups.size());
		System.out.println("Coups / Places : " + nbre_coup + " > "
				+ coups.size());
		return reste_coup;
	}

	// création de la liste des coups d'un joueur
	public List<Coup> liste_coups_joueur(Coup coup_joue) {

		List<Coup> coups_joueur = new ArrayList<Coup>();
		// Coup cur_coup = null;
		for (Coup cur_coup : coups) {
			// on regarde le joueur
			if (cur_coup.getJoueur() == coup_joue.getJoueur()) {
				// si identique on l'insere dans la nouvelle liste
				coups_joueur.add(cur_coup);
			}
		}
		return coups_joueur;
	}

	// liste de coup d'un joueur + coup joue
	public Boolean coup_existe_liste_joueur(Coup coup_joue, List<Coup> coups) {
		Boolean valid = false;

		// Coup cur_coup = null;
		for (Coup cur_coup : coups) {
			// on regarde la 1ere coordonnée des coups deja joués
			if (cur_coup.getCoordx() == coup_joue.getCoordx()) {
				// si identique
				// on regarde la 2eme coordonnée des coups deja joués
				if (cur_coup.getCoordy() == coup_joue.getCoordy()) {
					// si identique le coup est impossible
					valid = true;
					// System.out.println("Coup deja ds liste du joueur");
				}
			}
		}
		return valid;
	}

	public void setPlateau(int ligne, int colonne, int nbr_aligne) {
		plateau = new Plateau(ligne, colonne, nbr_aligne);
	}

	public Plateau getPlateau() {
		return plateau;
	}

	public String[][] TableauRes() {

		return null;// tab_res;
	}

	// procédure qui renvoit le résult sous forme de String
	// enum ??
	public String resultat_coup(Coup coup_joue) {
		System.out.println("------------Fonction Resultat");
		int alasuitedir = 1;

		String result = "encours";

		// initialisation coup courrant avec lequel on va comparer
		Coup coup_cur = new Coup();
		// on initialise la liste du joueur courrant
		List<Coup> liste_coupsJoueur = liste_coups_joueur(coup_joue);
		System.out.println("Liste coup joueur : "+liste_coupsJoueur.size());

		// Dir1 initialisation coup courrant : horiz +1
		coup_cur.setCoordy(coup_joue.getCoordy()); // meme ligne,y fixe
		coup_cur.setCoordx(coup_joue.getCoordx() + 1);
		// coup courrant existe dans la liste des coups du joueur ?
		System.out.println("Test direction 1");
		// coup_existe_liste_joueur vrai si existe, faux sinon
		if (coup_existe_liste_joueur(coup_cur, liste_coupsJoueur)) {
			System.out.println("+1 dir1 "+alasuitedir);
			alasuitedir = alasuitedir + 1;
			// dir1 : horiz +2
			coup_cur.setCoordx(coup_joue.getCoordx() + 2);
			if (coup_existe_liste_joueur(coup_cur, liste_coupsJoueur)) {
				alasuitedir = alasuitedir + 1;
				System.out.println("+2 dir1 "+alasuitedir);
			}
		}

		// Dir1 : horiz -1
		// si pas trouvé 3 a la suite, dans l'autre sens
		if (alasuitedir < 3) {
			System.out.println("autre sens "+alasuitedir);
			coup_cur.setCoordx(coup_joue.getCoordx() - 1);
			if (coup_existe_liste_joueur(coup_cur, liste_coupsJoueur)) {
				alasuitedir = alasuitedir + 1;
				System.out.println("-1 dir1 "+alasuitedir);
				// dir1 : horiz -2
				if (alasuitedir < 3) {
					coup_cur.setCoordx(coup_joue.getCoordx() - 2);
					if (coup_existe_liste_joueur(coup_cur, liste_coupsJoueur)) {
						alasuitedir = alasuitedir + 1;
						System.out.println("-2 dir1 "+alasuitedir);
					}
				}
			}
		}

		// Dir2 : diag1 - SO - NE
		if (alasuitedir < 3) {
			System.out.println("Test direction 2");
			alasuitedir = 1;
			coup_cur.setCoordy(coup_joue.getCoordy() + 1); // N
			coup_cur.setCoordx(coup_joue.getCoordx() + 1); // E
			if (coup_existe_liste_joueur(coup_cur, liste_coupsJoueur)) {
				alasuitedir = alasuitedir + 1;
				System.out.println("dir2 +1"+alasuitedir);
				// dir1 : horiz +2
				coup_cur.setCoordy(coup_joue.getCoordy() + 2); // N
				coup_cur.setCoordx(coup_joue.getCoordx() + 2); // E
				if (coup_existe_liste_joueur(coup_cur, liste_coupsJoueur)) {
					alasuitedir = alasuitedir + 1;
					System.out.println("dir2 +2"+alasuitedir);
				}
			}
		}

		// Dir2 : diag1 - SO - NE autre sens
		if (alasuitedir < 3) {
			coup_cur.setCoordy(coup_joue.getCoordy() - 1); // S
			coup_cur.setCoordx(coup_joue.getCoordx() - 1); // O
			
			if (coup_existe_liste_joueur(coup_cur, liste_coupsJoueur)) {
				alasuitedir = alasuitedir + 1;
				System.out.println("dir2 -1"+alasuitedir);
				// dir1 : horiz -2
				if (alasuitedir < 3) {
					coup_cur.setCoordy(coup_joue.getCoordy() - 2); // S
					coup_cur.setCoordx(coup_joue.getCoordx() - 2); // O
					if (coup_existe_liste_joueur(coup_cur, liste_coupsJoueur)) {
						alasuitedir = alasuitedir + 1;
						System.out.println("dir2 -2"+alasuitedir);
					}
				}
			}
		}

		// Dir3 : diag2 - NO - SE
		if (alasuitedir < 3) {
			System.out.println("Test direction 3");
			alasuitedir = 1;
			coup_cur.setCoordy(coup_joue.getCoordy() + 1); // N
			coup_cur.setCoordx(coup_joue.getCoordx() - 1); // O
			if (coup_existe_liste_joueur(coup_cur, liste_coupsJoueur)) {
				alasuitedir = alasuitedir + 1;
				// dir1 : horiz -2
				if (alasuitedir < 3) {
					coup_cur.setCoordy(coup_joue.getCoordy() + 2); // N
					coup_cur.setCoordx(coup_joue.getCoordx() - 2); // O
					if (coup_existe_liste_joueur(coup_cur, liste_coupsJoueur)) {
						alasuitedir = alasuitedir + 1;
					}
				}
			}
		}

		// Dir3 : diag2 - NO - SE autre sens
		if (alasuitedir < 3) {
			coup_cur.setCoordy(coup_joue.getCoordy() - 1); // S
			coup_cur.setCoordx(coup_joue.getCoordx() + 1); // E
			if (coup_existe_liste_joueur(coup_cur, liste_coupsJoueur)) {
				alasuitedir = alasuitedir + 1;
				// dir1 : horiz -2
				if (alasuitedir < 3) {
					coup_cur.setCoordy(coup_joue.getCoordy() - 2); // S
					coup_cur.setCoordx(coup_joue.getCoordx() + 2); // E
					if (coup_existe_liste_joueur(coup_cur, liste_coupsJoueur)) {
						alasuitedir = alasuitedir + 1;
					}
				}
			}
		}

		// // dir4 : vert
		if (alasuitedir < 3) {
			System.out.println("Test direction 4");
			alasuitedir = 1;
			coup_cur.setCoordy(coup_joue.getCoordy() + 1); // N
			coup_cur.setCoordx(coup_joue.getCoordx());
			if (coup_existe_liste_joueur(coup_cur, liste_coupsJoueur)) {
				alasuitedir = alasuitedir + 1;
				// dir1 : horiz -2
				if (alasuitedir < 3) {
					coup_cur.setCoordy(coup_joue.getCoordy() + 2); // N
					if (coup_existe_liste_joueur(coup_cur, liste_coupsJoueur)) {
						alasuitedir = alasuitedir + 1;
					}
				}
			}
		}

		// // dir4 : vert autre sens
		if (alasuitedir < 3) {
			alasuitedir = 1;
			coup_cur.setCoordy(coup_joue.getCoordy() - 1); // S
			coup_cur.setCoordx(coup_joue.getCoordx());
			if (coup_existe_liste_joueur(coup_cur, liste_coupsJoueur)) {
				alasuitedir = alasuitedir + 1;
				// dir1 : horiz -2
				if (alasuitedir < 3) {
					coup_cur.setCoordy(coup_joue.getCoordy() - 2); // S
					if (coup_existe_liste_joueur(coup_cur, liste_coupsJoueur)) {
						alasuitedir = alasuitedir + 1;
					}
				}
			}
		}

		if (alasuitedir >= 3) {
			result = "gagne "+coup_joue.getJoueur().getSymbole();
		} else {
			System.out.println("Continue");
		}

		return result;

	}

	public List<Coup> getListeCoups() {
		return coups;
	}

	public void setListeCoups(List<Coup> coups) {
		this.coups = coups;
	}

	public Joueur change_joueur(Joueur joueur) {
		System.out.println("changement joueur");
		System.out.println("joueur entree:"+joueur.getSymbole());
		if (joueur == joueurs.get(0)) {
			System.out.println("joueur1 donc joueur2");
			joueur = joueurs.get(1);
		} else {
			System.out.println("joueur2 donc joueur1");
			joueur = joueurs.get(0);
		}
		System.out.println("joueur sortie:"+joueur.getSymbole());
		return joueur;

	}
	
	public void aff_plateau(List<Coup> coups) {
		
		String[][] tab = new String[plateau.getLigne()][plateau.getColonne()];
		String newLine = System.getProperty("line.separator");
				
		for (int i = 0; i < plateau.getLigne() ; i++) {
			for (int j = 0; j < plateau.getLigne() ; j++) {
				tab[i][j] = "*";
			}
		}
		
		for (Coup cur_coup : coups) {
			
			int ligne = cur_coup.getCoordx();
			int colonne = cur_coup.getCoordy();
			String sym = cur_coup.getJoueur().getSymbole();

			tab[ligne-1][colonne-1] = sym ;
			
		}
		
		for (int i = 0; i < plateau.getLigne() ; i++) {
			for (int j = 0; j < plateau.getLigne() ; j++) {
				System.out.print(" "+tab[i][j]+" ");
			}
			System.out.println(newLine);
		}

	}

}

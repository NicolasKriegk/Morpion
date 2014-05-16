package packmorpion.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * 
 * @author imie
 */

public class ModelMorp extends Observable {

	private List<Joueur> joueurs; // attributs symboles ???
	private Plateau plateau; // attributs dimension
	private List<Coup> coups; // attributs joueurs

	// -----------------------------------------------------------
	// méthodes modele

	public void partie(List<Joueur> joueurs, Plateau plateau) {

		String resultat = "encours";

		while (resultat == "encours") {
			// tour

			// Joueur1 joue

			// test

			// Joueur2 joue

			// test

		}

	}

	// procédure d'ajout d'un nouveau coup à la liste de coup
	public List<Coup> joue_coup(List<Coup> coups, Coup coup_joue) {

		// le joueur qui a joué est connu par newcoup
		Boolean valid = coup_exist(coups, coup_joue);

		if (valid) {
			coups.add(coup_joue);
			// String res = resultat(coups,newcoup, plateau); ?? ici ou pas
		}
		return coups;
	}

	// procédure qui renvoit le résult sous forme de String
	// enum ??
	public String resultat(List<Coup> coups, Coup newcoup, Plateau grille) {

		int alasuitedir = 1;

		String result = null;

		// initialisation coup courrant avec lequel on va comparer
		Coup coup_cur = new Coup();
		// on initialise la liste du joueur courrant
		List<Coup> liste_coupsJoueur = coup_joueur(coups, newcoup);

		// initialisation coup courrant dir1 : horiz +1
		coup_cur.setCoordy(newcoup.getCoordy()); // meme ligne,y fixe
		coup_cur.setCoordx(newcoup.getCoordx() + 1);
		// coup courrant existe dans la liste des coups du joueur ?
		if (coup_exist(liste_coupsJoueur, coup_cur)) {
			alasuitedir = alasuitedir + 1;
			// dir1 : horiz +2
			coup_cur.setCoordx(newcoup.getCoordx() + 2);
			if (coup_exist(liste_coupsJoueur, coup_cur)) {
				alasuitedir = alasuitedir + 1;
			}
		}

		// dir1 : horiz -1
		// si pas trouvé 3 a la suite, dans l'autre sens
		if (alasuitedir < 3) {
			coup_cur.setCoordx(newcoup.getCoordx() - 1);
			if (coup_exist(liste_coupsJoueur, coup_cur)) {
				alasuitedir = alasuitedir + 1;
				// dir1 : horiz -2
				if (alasuitedir < 3) {
					coup_cur.setCoordx(newcoup.getCoordx() - 2);
					if (coup_exist(liste_coupsJoueur, coup_cur)) {
						alasuitedir = alasuitedir + 1;
					}
				}
			}
		}

		// // dir2 : diag1 - SO - NE
		// initialisation coup courrant dir1 : horiz +1
		coup_cur.setCoordy(newcoup.getCoordy() + 1); // N
		coup_cur.setCoordx(newcoup.getCoordx() + 1); // E
		if (coup_exist(liste_coupsJoueur, coup_cur)) {
			alasuitedir = alasuitedir + 1;
			// dir1 : horiz +2
			coup_cur.setCoordy(newcoup.getCoordy() + 2); // N
			coup_cur.setCoordx(newcoup.getCoordx() + 2); // E
			if (coup_exist(liste_coupsJoueur, coup_cur)) {
				alasuitedir = alasuitedir + 1;
			}
		}

		// si pas trouvé 3 a la suite, dans l'autre sens
		if (alasuitedir < 3) {
			alasuitedir = 1;
			coup_cur.setCoordy(newcoup.getCoordy() -1 ); // S
			coup_cur.setCoordx(newcoup.getCoordx() -1 ); // O
			if (coup_exist(liste_coupsJoueur, coup_cur)) {
				alasuitedir = alasuitedir + 1;
				// dir1 : horiz -2
				if (alasuitedir < 3) {
					coup_cur.setCoordy(newcoup.getCoordy() -2 ); // S
					coup_cur.setCoordx(newcoup.getCoordx() -2 ); // O
					if (coup_exist(liste_coupsJoueur, coup_cur)) {
						alasuitedir = alasuitedir + 1;
					}
				}
			}
		}
		
		// // dir3 : diag2 - NO - SE
		if (alasuitedir < 3) {
			alasuitedir = 1;
			coup_cur.setCoordy(newcoup.getCoordy() + 1 ); // N
			coup_cur.setCoordx(newcoup.getCoordx() - 1 ); // O
			if (coup_exist(liste_coupsJoueur, coup_cur)) {
				alasuitedir = alasuitedir + 1;
				// dir1 : horiz -2
				if (alasuitedir < 3) {
					coup_cur.setCoordy(newcoup.getCoordy() + 2 ); // N
					coup_cur.setCoordx(newcoup.getCoordx() - 2 ); // O
					if (coup_exist(liste_coupsJoueur, coup_cur)) {
						alasuitedir = alasuitedir + 1;
					}
				}
			}
		}
		// // dir4 : vert
		if (alasuitedir < 3) {
			alasuitedir = 1;
			coup_cur.setCoordy(newcoup.getCoordy() + 1 ); // N
			coup_cur.setCoordx(newcoup.getCoordx());
			if (coup_exist(liste_coupsJoueur, coup_cur)) {
				alasuitedir = alasuitedir + 1;
				// dir1 : horiz -2
				if (alasuitedir < 3) {
					coup_cur.setCoordy(newcoup.getCoordy() + 2 ); // N
					if (coup_exist(liste_coupsJoueur, coup_cur)) {
						alasuitedir = alasuitedir + 1;
					}
				}
			}
		}

		return result;

	}

	// création de la liste des coups d'un joueur
	public List<Coup> coup_joueur(List<Coup> coups, Coup coup_joue) {

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

	// verification si le coup est existe : vrai si existe / faux sinon
	// ne donne pas si joué par l bon joueur
	public Boolean coup_exist(List<Coup> coups, Coup newcoup) {
		Boolean valid = false;

		// Coup cur_coup = null;
		for (Coup cur_coup : coups) {
			// on regarde la 1ere coordonnée des coups deja joués
			if (cur_coup.getCoordx() == newcoup.getCoordx()) {
				// si identique
				// on regarde la 2eme coordonnée des coups deja joués
				if (cur_coup.getCoordy() == newcoup.getCoordy()) {
					// si identique le coup est impossible
					valid = true;
				}
			}
		}
		return valid;
	}

}

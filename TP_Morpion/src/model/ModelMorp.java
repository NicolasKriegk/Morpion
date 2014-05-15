package model;

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

	// procédure d'ajout d'un nouveau coup à la liste de coup
	public List<Coup> joue_coup(List<Coup> coups, Coup newcoup) {

		// le joueur qui a joué est connu par newcoup
		Boolean valid = coup_exist(coups, newcoup);

		if (valid) {
			coups.add(newcoup);
			// String res = resultat(coups,newcoup, plateau); ?? ici ou pas
		}

		return coups;

	}

	public String resultat(List<Coup> coups, Coup newcoup, Plateau grille) {

		int alasuitedir1 = 1;
		int alasuitedir2 = 1;
		int alasuitedir3 = 1;
		int alasuitedir4 = 1;
		String result = null;

		// initialisation coup courrant avec lequel on va comparer
		Coup coup_cur = new Coup();
		// on initialise le joueur courrant
		Joueur joueur_cur = newcoup.getJoueur();

		// dir1 : horiz
		// +dim1
		coup_cur.setCoord2(newcoup.getCoord2()); // meme ligne,y fixe
		// verifier si on sort de la grille vers la droite
		if (newcoup.getCoord1() + 1 <= grille.getDim1()) {
			// si on sort pas on initialise le coup courrant
			coup_cur.setCoord1(newcoup.getCoord1() + 1);
			// coup courrant existe ?
			if (coup_exist(coups, coup_cur)) {
				// et est joué par le bon joueur
				if (coup_cur.getJoueur() == joueur_cur) {
					alasuitedir1 = alasuitedir1 + 1;
					// si grille +2 existe
					if (newcoup.getCoord1() + 2 <= grille.getDim1()) {
						coup_cur.setCoord1(newcoup.getCoord1() + 2);
						if (coup_exist(coups, coup_cur)) {
							// et est joué par le bon joueur
							if (coup_cur.getJoueur() == joueur_cur) {
								alasuitedir1 = alasuitedir1 + 1;
							}
						}
					}
				}
			}
		}
		// si pas trouvé 3 a la suite, dans l'autre sens
		if (alasuitedir1 < 3) {
			// verifier si on sort de la grille vers la gauche
			if (newcoup.getCoord1() - 1 >= 0) {
				// si on sort pas on initialise le coup courrant
				coup_cur.setCoord1(newcoup.getCoord1() - 1);
				if (coup_exist(coups, coup_cur)) {
					// et est joué par le bon joueur
					// et est joué par le bon joueur
					if (coup_cur.getJoueur() == joueur_cur) {
						alasuitedir1 = alasuitedir1 + 1;
						if (alasuitedir1 < 3) {
							if (newcoup.getCoord1() - 2 >= 0)
								;
							if (coup_exist(coups, coup_cur)) {
								// et est joué par le bon joueur
								if (coup_cur.getJoueur() == joueur_cur) {
									alasuitedir1 = alasuitedir1 + 1;
								}
							}
						}
					}
				}
			}
		}

		// -dim1

		// on teste la direction seulement si pas deja gagné
		if (alasuitedir2 < 3) {
			// on change de direction donc on remet alasuite à 1
			alasuitedir2 = 1;
			// dir2 : diag1 - NE - SO
		}
		// on teste la direction seulement si pas deja gagné
		if (alasuitedir3 < 3) {
			// on change de direction donc on remet alasuite à 1
			// dir3 : diag2 - SE - NO
		}
		// on teste la direction seulement si pas deja gagné
		if (alasuitedir2 < 3) {
			// on change de direction donc on remet alasuite à 1
		}
		// dir4 : vert

		return result;

	}

	// verification si le coup est existe : faux si existe / vrai sinon
	public Boolean coup_exist(List<Coup> coups, Coup newcoup) {
		Boolean valid = false;

		// Coup cur_coup = null;
		for (Coup cur_coup : coups) {

			// on regarde la 1ere coordonnée des coups deja joués
			if (cur_coup.getCoord1() == newcoup.getCoord1()) {
				// si identique
				// on regarde la 2eme coordonnée des coups deja joués
				if (cur_coup.getCoord2() == newcoup.getCoord2()) {
					// si identique le coup est impossible
					valid = true;
				}

			}
		}
		return valid;
	}

}

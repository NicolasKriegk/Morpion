package model;

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
			//tour
			
			//Joueur1 joue
			
			//test
			
			//Joueur2 joue
			
			//test
			

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
		// on initialise le joueur courrant
		Joueur joueur_cur = newcoup.getJoueur();
		List<Coup> liste_coupsJoueur = coup_joueur(coups,newcoup);
				
		// dir1 : horiz
		// +dim1
		coup_cur.setCoordy(newcoup.getCoordy()); // meme ligne,y fixe
		// verifier si on sort de la grille vers la droite
		//if (newcoup.getCoordx() + 1 <= grille.getDim1()) {
		// pas besoin si on verifie que le coups appartient a la liste des coups du joueur
		// si on sort pas on initialise le coup courrant
		coup_cur.setCoordx(newcoup.getCoordx() + 1);
			// coup courrant existe dans la liste des coups du joueur ? 
			if (coup_exist(liste_coupsJoueur, coup_cur)) {
				// et est joué par le bon joueur car on regarde ceux de la list du joueur
				//if (coup_cur.getJoueur() == joueur_cur) {
					alasuitedir = alasuitedir + 1;
					// si grille +2 existe
					//if (newcoup.getCoordx() + 2 <= grille.getDim1()) {
						coup_cur.setCoordx(newcoup.getCoordx() + 2);
						if (coup_exist(liste_coupsJoueur, coup_cur)) {
							// et est joué par le bon joueur
							//if (coup_cur.getJoueur() == joueur_cur) {
								alasuitedir = alasuitedir + 1;
							//}
						}
					//}
				//}
			}
		//}
		// si pas trouvé 3 a la suite, dans l'autre sens
		if (alasuitedir < 3) {
			// verifier si on sort de la grille vers la gauche
			if (newcoup.getCoordx() - 1 >= 0) {
				// si on sort pas on initialise le coup courrant
				coup_cur.setCoordx(newcoup.getCoordx() - 1);
				if (coup_exist(coups, coup_cur)) {
					// et est joué par le bon joueur
					// et est joué par le bon joueur
					if (coup_cur.getJoueur() == joueur_cur) {
						alasuitedir = alasuitedir + 1;
						if (alasuitedir < 3) {
							if (newcoup.getCoordx() - 2 >= 0)
								;
							if (coup_exist(coups, coup_cur)) {
								// et est joué par le bon joueur
								if (coup_cur.getJoueur() == joueur_cur) {
									alasuitedir = alasuitedir + 1;
								}
							}
						}
					}
				}
			}
		}

		// -dim1

//		// on teste la direction seulement si pas deja gagné
//		if (alasuitedir2 < 3) {
//			// on change de direction donc on remet alasuite à 1
//			alasuitedir2 = 1;
//			// dir2 : diag1 - NE - SO
//		}
//		// on teste la direction seulement si pas deja gagné
//		if (alasuitedir3 < 3) {
//			// on change de direction donc on remet alasuite à 1
//			// dir3 : diag2 - SE - NO
//		}
//		// on teste la direction seulement si pas deja gagné
//		if (alasuitedir2 < 3) {
//			// on change de direction donc on remet alasuite à 1
//		}
//		// dir4 : vert

		return result;

	}
	
	// création de la liste des coups d'un joueur
	public List<Coup>  coup_joueur(List<Coup> coups,Coup coup_joue) {

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
	// ne donne pas si joué par l bon  joueur
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

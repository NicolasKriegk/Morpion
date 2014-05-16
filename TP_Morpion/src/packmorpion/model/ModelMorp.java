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

	public void partie() {

		// mettre dans un init partie
		// enregistrement joueurs
		Joueur joueurA = new Joueur("A");
		joueurs.add(joueurA);
		//setJoueur();
		//setPlateau();
		
		String resultat = "encours";
		// lecture de la config (plateau...)
		Coup coup_joue = new Coup();

		while (resultat == "encours") {
			// tour
			

			// Joueur joue
			// attente que le joueur clique
			

			// test possible ou deja joue et ajoute
			joue_coup(coup_joue);
			// notif

			// resultat
			// notif
			
			// change joueur
		}

	}
	
	public void setPlateau(int ligne, int colonne, int nbr_aligne) {
		plateau.setLigne(ligne);
		plateau.setColonne(colonne);
		plateau.setNbre_aligne(nbr_aligne);
	}
	
	public Plateau getPlateau() {
		return plateau;
	}

	// procédure d'ajout d'un nouveau coup à la liste de coup
	// teste si existe
	public List<Coup> joue_coup(Coup coup_joue) {

		// le joueur qui a joué est connu par newcoup
		Boolean valid = coup_existe(coup_joue);
		Boolean possible = coupJoueur_valide(coup_joue);
		if (possible && valid) {
			coups.add(coup_joue);
			// String res = resultat(coups,newcoup, plateau); ?? ici ou pas
		}
		return coups;
	}

	// procédure qui renvoit le résult sous forme de String
	// enum ??
	public String resultat(Coup coup_joue) {

		int alasuitedir = 1;

		String result = "encours";

		// initialisation coup courrant avec lequel on va comparer
		Coup coup_cur = new Coup();
		// on initialise la liste du joueur courrant
		List<Coup> liste_coupsJoueur = coup_joueur(coup_joue);

		// Dir1 initialisation coup courrant : horiz +1
		coup_cur.setCoordy(coup_joue.getCoordy()); // meme ligne,y fixe
		coup_cur.setCoordx(coup_joue.getCoordx() + 1);
		// coup courrant existe dans la liste des coups du joueur ?
		if (coupJoueur_existe(coup_cur, liste_coupsJoueur)) {
			alasuitedir = alasuitedir + 1;
			// dir1 : horiz +2
			coup_cur.setCoordx(coup_joue.getCoordx() + 2);
			if (coupJoueur_existe(coup_cur, liste_coupsJoueur)) {
				alasuitedir = alasuitedir + 1;
			}
		}

		// Dir1 : horiz -1
		// si pas trouvé 3 a la suite, dans l'autre sens
		if (alasuitedir < 3) {
			coup_cur.setCoordx(coup_joue.getCoordx() - 1);
			if (coupJoueur_existe(coup_cur, liste_coupsJoueur)) {
				alasuitedir = alasuitedir + 1;
				// dir1 : horiz -2
				if (alasuitedir < 3) {
					coup_cur.setCoordx(coup_joue.getCoordx() - 2);
					if (coupJoueur_existe(coup_cur, liste_coupsJoueur)) {
						alasuitedir = alasuitedir + 1;
					}
				}
			}
		}

		// Dir2 : diag1 - SO - NE
		if (alasuitedir < 3) {
			alasuitedir = 1;
			coup_cur.setCoordy(coup_joue.getCoordy() + 1); // N
			coup_cur.setCoordx(coup_joue.getCoordx() + 1); // E
			if (coupJoueur_existe(coup_cur, liste_coupsJoueur)) {
				alasuitedir = alasuitedir + 1;
				// dir1 : horiz +2
				coup_cur.setCoordy(coup_joue.getCoordy() + 2); // N
				coup_cur.setCoordx(coup_joue.getCoordx() + 2); // E
				if (coupJoueur_existe(coup_cur, liste_coupsJoueur)) {
					alasuitedir = alasuitedir + 1;
				}
			}
		}

		// Dir2 : diag1 - SO - NE autre sens
		if (alasuitedir < 3) {
			coup_cur.setCoordy(coup_joue.getCoordy() - 1); // S
			coup_cur.setCoordx(coup_joue.getCoordx() - 1); // O
			if (coupJoueur_existe(coup_cur, liste_coupsJoueur)) {
				alasuitedir = alasuitedir + 1;
				// dir1 : horiz -2
				if (alasuitedir < 3) {
					coup_cur.setCoordy(coup_joue.getCoordy() - 2); // S
					coup_cur.setCoordx(coup_joue.getCoordx() - 2); // O
					if (coupJoueur_existe(coup_cur, liste_coupsJoueur)) {
						alasuitedir = alasuitedir + 1;
					}
				}
			}
		}

		// Dir3 : diag2 - NO - SE
		if (alasuitedir < 3) {
			alasuitedir = 1;
			coup_cur.setCoordy(coup_joue.getCoordy() + 1); // N
			coup_cur.setCoordx(coup_joue.getCoordx() - 1); // O
			if (coupJoueur_existe(coup_cur, liste_coupsJoueur)) {
				alasuitedir = alasuitedir + 1;
				// dir1 : horiz -2
				if (alasuitedir < 3) {
					coup_cur.setCoordy(coup_joue.getCoordy() + 2); // N
					coup_cur.setCoordx(coup_joue.getCoordx() - 2); // O
					if (coupJoueur_existe(coup_cur, liste_coupsJoueur)) {
						alasuitedir = alasuitedir + 1;
					}
				}
			}
		}

		// Dir3 : diag2 - NO - SE autre sens
		if (alasuitedir < 3) {
			coup_cur.setCoordy(coup_joue.getCoordy() - 1); // S
			coup_cur.setCoordx(coup_joue.getCoordx() + 1); // E
			if (coupJoueur_existe(coup_cur, liste_coupsJoueur)) {
				alasuitedir = alasuitedir + 1;
				// dir1 : horiz -2
				if (alasuitedir < 3) {
					coup_cur.setCoordy(coup_joue.getCoordy() - 2); // S
					coup_cur.setCoordx(coup_joue.getCoordx() + 2); // E
					if (coupJoueur_existe(coup_cur, liste_coupsJoueur)) {
						alasuitedir = alasuitedir + 1;
					}
				}
			}
		}

		// // dir4 : vert
		if (alasuitedir < 3) {
			alasuitedir = 1;
			coup_cur.setCoordy(coup_joue.getCoordy() + 1); // N
			coup_cur.setCoordx(coup_joue.getCoordx());
			if (coupJoueur_existe(coup_cur, liste_coupsJoueur)) {
				alasuitedir = alasuitedir + 1;
				// dir1 : horiz -2
				if (alasuitedir < 3) {
					coup_cur.setCoordy(coup_joue.getCoordy() + 2); // N
					if (coupJoueur_existe(coup_cur, liste_coupsJoueur)) {
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
			if (coupJoueur_existe(coup_cur, liste_coupsJoueur)) {
				alasuitedir = alasuitedir + 1;
				// dir1 : horiz -2
				if (alasuitedir < 3) {
					coup_cur.setCoordy(coup_joue.getCoordy() - 2); // S
					if (coupJoueur_existe(coup_cur, liste_coupsJoueur)) {
						alasuitedir = alasuitedir + 1;
					}
				}
			}
		}
		
		if (alasuitedir >= 3) {
			result = "gagne";
		}

		return result;

	}

	// création de la liste des coups d'un joueur
	public List<Coup> coup_joueur(Coup coup_joue) {

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
	// juste coordonnées
	// ne donne pas si joué par le bon joueur
	// liste de coup globale
	public Boolean coup_existe(Coup coup_joue) {
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
				}
			}
		}
		return valid;
	}

	// liste de coup d'un joueur + coup joue
	public Boolean coupJoueur_existe(Coup coup_joue, List<Coup> coups) {
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
				}
			}
		}
		return valid;
	}

	// liste de coup d'un joueur + coup joue
	public Boolean coupJoueur_valide(Coup coup_joue) {
		Boolean valid = false;


			// on regarde la 1ere coordonnée des coups deja joués
			if (coup_joue.getCoordx() <= plateau.getLigne()) {
				// si identique
				// on regarde la 2eme coordonnée des coups deja joués
				if (coup_joue.getCoordy() == plateau.getColonne()) {
					// si identique le coup est impossible
					valid = true;
				}
			}
		return valid;
	}

}

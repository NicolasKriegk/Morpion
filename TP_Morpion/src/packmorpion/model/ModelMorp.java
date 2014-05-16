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

	// -----------------------------------------------------------
	// méthodes modele

	public void partie() {

		System.out.println("partie");
		// mettre dans un init partie
		// enregistrement joueurs
		Joueur joueurA = new Joueur("A");

		joueurs.add(joueurA);
		// setJoueur();
		// setPlateau();

		String resultat = "encours";

		System.out.println("init partie");
		setPlateau(3, 3, 3);
		int min = 1;
		int max = 3;

		
			//(resultat == "encours") && 
			while (reste_coup_grille()) {
				//for (int i = 1; i <= 5; i++) {
			// tour

				// Joueur joue
				int nbreAlx = min + (int) (Math.random() * ((max - min) + 1));
				int nbreAly = min + (int) (Math.random() * ((max - min) + 1));
				// lecture de la config (plateau...)
				Coup coup_joue = new Coup();
				coup_joue.setCoordx(nbreAlx);
				coup_joue.setCoordx(nbreAly);
				coup_joue.setJoueur(joueurA);

				// attente que le joueur clique
				System.out.println("x : " + nbreAlx + " - y : "+ nbreAly);
				
				// test possible ou deja joue et ajoute
				add_coup_joue(coup_joue);
				// notif
				// resultat
				
				// resultat = resultat(coup_joue);
				// notif
				 System.out.println("Le resultat est " + resultat);
				 System.out.println("on peut encore jouer :" + reste_coup_grille());
				// resultat = "temp";
				// change joueur
				//System.out.println("=================================== fin tour :" + i);
				}
			
		//}

	}
	
	
	// procédure d'ajout d'un nouveau coup à la liste de coup
	// teste si existe  et ajoute
	// 1ere procedure
	public List<Coup> add_coup_joue(Coup coup_joue) {
		System.out.println("----------- add_joue_coup");
		// le joueur qui a joué est connu par coup_joue
		Boolean exist = coup_existe_liste(coup_joue);
		System.out.println("Cond 1 : coup existe ds liste complete ? " + exist);
		Boolean possible = coup_possible_grille(coup_joue);
		System.out.println("Cond 2 : coup possible grille ? " + possible);
		if (possible && !exist) {
			//System.out.println("Coup valide et pas joué");
			coups.add(coup_joue);
			
			System.out.println("Donc Ajout : "+coups.size());
			// String res = resultat(coups,newcoup, plateau); ?? ici ou pas
		}
		
		return coups;
	}
	
	// verification si le coup est existe : vrai si existe / faux sinon
	// juste coordonnées
	// ne donne pas si joué par le bon joueur
	// liste de coup globale
	public Boolean coup_existe_liste(Coup coup_joue) {
		Boolean valid = false;
		System.out.println("----------------- coup_existe_liste (cond 1)");
		// Coup cur_coup = null;
		for (Coup cur_coup : coups) {
			
			// on regarde la 1ere coordonnée des coups deja joués
			System.out.println("cur_coup : "+cur_coup.getCoordx()+"/"+cur_coup.getCoordx());
			System.out.println("coup_joue : "+coup_joue.getCoordx()+"/"+coup_joue.getCoordx());
			if (cur_coup.getCoordx() == coup_joue.getCoordx()) {	
				// si identique
				// on regarde la 2eme coordonnée des coups deja joués
				if (cur_coup.getCoordy() == coup_joue.getCoordy()) {
					// si identique le coup est impossible
					valid = true;
					System.out
							.println("Le coup existe dans la liste complete des coups !");
					System.out.println("ajout sera impossible !");
				}
			}
		}
		return valid;
	}
	

	// liste de coup d'un joueur + coup joue
	public Boolean coup_possible_grille(Coup coup_joue) {
		Boolean valid = false;
		System.out.println("--------coup_possible_grille (cond2)");
		// on regarde la 1ere coordonnée des coups deja joués
		if (coup_joue.getCoordx() <= plateau.getLigne()) {
			System.out.println("ligne possible");
			// si identique
			// on regarde la 2eme coordonnée des coups deja joués
			if (coup_joue.getCoordy() <= plateau.getColonne()) {
				System.out.println("colonne possible");
				// si identique le coup est impossible
				valid = true;
				System.out.println("Le coup est possible (taille grille)");
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

	// création de la liste des coups d'un joueur
	public List<Coup> liste_coups_joueur(Coup coup_joue) {

		System.out.println("----------------coups_joueur");
		List<Coup> coups_joueur = new ArrayList<Coup>();
		// Coup cur_coup = null;
		for (Coup cur_coup : coups) {
			// on regarde le joueur
			if (cur_coup.getJoueur() == coup_joue.getJoueur()) {
				// si identique on l'insere dans la nouvelle liste
				coups_joueur.add(cur_coup);
				
				//System.out.println("coup_joue : "+coup_joue.getCoordx()+"/"+coup_joue.getCoordx());
				
				System.out.println("Ajout le coup à la liste du joueur ");
			}
		}
		return coups_joueur;
	}

	public Boolean reste_coup_grille() {
		int nbre_coup = plateau.getColonne() * plateau.getLigne();
		Boolean reste_coup = (nbre_coup > coups.size());
		System.out.println("il reste des coups possible : " + nbre_coup + ">"
				+ coups.size());
		return reste_coup;
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
					System.out
							.println("Le coup existe deja ds liste du joueur");
				}
			}
		}
		return valid;
	}

	
	public String[][] TableauRes() {

		return null;// tab_res;		
	}
	
	
	// procédure qui renvoit le résult sous forme de String
	// enum ??
	public String resultat(Coup coup_joue) {
		System.out.println("------------Fonction Resultat");
		int alasuitedir = 1;

		String result = "encours";

		// initialisation coup courrant avec lequel on va comparer
		Coup coup_cur = new Coup();
		// on initialise la liste du joueur courrant
		List<Coup> liste_coupsJoueur = liste_coups_joueur(coup_joue);

		// Dir1 initialisation coup courrant : horiz +1
		coup_cur.setCoordy(coup_joue.getCoordy()); // meme ligne,y fixe
		coup_cur.setCoordx(coup_joue.getCoordx() + 1);
		// coup courrant existe dans la liste des coups du joueur ?
		if (!coup_existe_liste_joueur(coup_cur, liste_coupsJoueur)) {
			System.out.println("Test direction 1");
			alasuitedir = alasuitedir + 1;
			// dir1 : horiz +2
			coup_cur.setCoordx(coup_joue.getCoordx() + 2);
			if (coup_existe_liste_joueur(coup_cur, liste_coupsJoueur)) {
				alasuitedir = alasuitedir + 1;
			}
		}

		// Dir1 : horiz -1
		// si pas trouvé 3 a la suite, dans l'autre sens
		if (alasuitedir < 3) {

			coup_cur.setCoordx(coup_joue.getCoordx() - 1);
			if (coup_existe_liste_joueur(coup_cur, liste_coupsJoueur)) {
				alasuitedir = alasuitedir + 1;
				// dir1 : horiz -2
				if (alasuitedir < 3) {
					coup_cur.setCoordx(coup_joue.getCoordx() - 2);
					if (coup_existe_liste_joueur(coup_cur, liste_coupsJoueur)) {
						alasuitedir = alasuitedir + 1;
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
				// dir1 : horiz +2
				coup_cur.setCoordy(coup_joue.getCoordy() + 2); // N
				coup_cur.setCoordx(coup_joue.getCoordx() + 2); // E
				if (coup_existe_liste_joueur(coup_cur, liste_coupsJoueur)) {
					alasuitedir = alasuitedir + 1;
				}
			}
		}

		// Dir2 : diag1 - SO - NE autre sens
		if (alasuitedir < 3) {
			coup_cur.setCoordy(coup_joue.getCoordy() - 1); // S
			coup_cur.setCoordx(coup_joue.getCoordx() - 1); // O
			if (coup_existe_liste_joueur(coup_cur, liste_coupsJoueur)) {
				alasuitedir = alasuitedir + 1;
				// dir1 : horiz -2
				if (alasuitedir < 3) {
					coup_cur.setCoordy(coup_joue.getCoordy() - 2); // S
					coup_cur.setCoordx(coup_joue.getCoordx() - 2); // O
					if (coup_existe_liste_joueur(coup_cur, liste_coupsJoueur)) {
						alasuitedir = alasuitedir + 1;
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
			result = "gagne";
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

}

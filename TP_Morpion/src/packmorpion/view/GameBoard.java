package packmorpion.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import packmorpion.model.Coup;
import packmorpion.model.Joueur;
import packmorpion.model.ModelMorp;
import packmorpion.model.Plateau;

public class GameBoard extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int yMax;
	private int xMax;
	private int lignes;
	private int colonnes;
	private int xDimCase;
	private int yDimCase;

	private ModelMorp m;
	// private Model m;
	private Plateau plateau;
	private Joueur premierJoueur;

	// private Set<ViewCase> listeCases;

	// public GameBoard(Model m, int largeur, int hauteur) {
	public GameBoard(int lignes, int colonnes, int largeur, int hauteur) {
		this.yMax = hauteur - 1;
		this.xMax = largeur - 1;
		// this.m = m;
		this.lignes = lignes;
		this.colonnes = colonnes;
		this.setPreferredSize(new Dimension(largeur, hauteur));
		//ajout zone cliquable
		addMouseListener(ml);
		
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // paint parent's background

		// dessin du cadre
		g.drawLine(0, 0, xMax, 0);
		g.drawLine(xMax, 0, xMax, yMax);
		g.drawLine(xMax, yMax, 0, yMax);
		g.drawLine(0, yMax, 0, 0);

		// DEBUT dessin de la grille -----------------------------------------
		int xDebut;
		int xFin;
		int yDebut;
		int yFin;

		// calcul taille case
		xDimCase = xMax / colonnes;
		yDimCase = yMax / lignes;

		// dessin de toutes les colonnes
		for (int i = 1; i <= (colonnes - 1); i++) {
			// calcul des coordonnees de chaque colonne
			xDebut = (i * xDimCase);
			xFin = xDebut;
			yDebut = 0;
			yFin = yMax;
			// System.out.println("colonne " + i);
			// System.out.println("x1=" + xDebut + " y1=" + yDebut);
			// System.out.println("x2=" + xFin + " y2=" + yFin);
			// dessin de la colonne
			g.drawLine(xDebut, yDebut, xFin, yFin);
		}

		// dessin de toutes les lignes
		for (int i = 1; i <= (lignes - 1); i++) {
			// calcul des coordonnees de chaque ligne
			xDebut = 0;
			xFin = xMax;
			yDebut = (i * yDimCase);
			yFin = yDebut;
			// System.out.println("ligne " + i);
			// System.out.println("x1=" + xDebut + " y1=" + yDebut);
			// System.out.println("x2=" + xFin + " y2=" + yFin);
			// dessin de la ligne
			g.drawLine(xDebut, yDebut, xFin, yFin);
		}

		// FIN dessin de la grille -----------------------------------------

		// TODELETE test
//		List<Coup> coups = new ArrayList<Coup>();
//		Joueur joueur1 = new Joueur("A");
//		Joueur joueur2 = new Joueur("B");
//		Coup coup1 = new Coup();
//		coup1.setJoueur(joueur1);
//		coup1.setCoordx(1);
//		coup1.setCoordy(2);
//		coups.add(coup1);
//		Coup coup2 = new Coup();
//		coup2.setJoueur(joueur2);
//		coup2.setCoordx(1);
//		coup2.setCoordy(1);
//		coups.add(coup2);
//		Coup coup3 = new Coup();
//		coup3.setJoueur(joueur1);
//		coup3.setCoordx(4);
//		coup3.setCoordy(4);
//		coups.add(coup3);
//		Coup coup4 = new Coup();
//		coup4.setJoueur(joueur2);
//		coup4.setCoordx(3);
//		coup4.setCoordy(3);
//		coups.add(coup4);

//		System.out.println("Dim x =" + String.valueOf(xDimCase));
//		System.out.println("Dim y =" + String.valueOf(yDimCase));

		// DEBUT dessin X / O -----------------------------
		premierJoueur = null;
		int xHautGauche = 0;
		int yHautGauche = 0;
		 for (Coup coup : m.getListCoup()) {
//		for (Coup coup : coups) {
//			System.out.println("coup x=" + String.valueOf(coup.getCoordx()));
//			System.out.println("coup y=" + String.valueOf(coup.getCoordy()));
			// affectation premier joueur pour differencier symbole apres
			if (premierJoueur == null) {
				premierJoueur = coup.getJoueur();
			}

			// recuperation case jouee et calcul coordonnees debut dessin
			// symbole
			// coordonnees debut dessin: (num case sur x - 1) * (taille x) + [(taille x) / 4]
			xHautGauche = ((coup.getCoordx()-1) * xDimCase) + (xDimCase / 4);
			yHautGauche = ((coup.getCoordy()-1) * yDimCase) + (yDimCase / 4);
			int tailleDessin = Math.min(xDimCase / 2, yDimCase / 2);
//			System.out.println("taille =" + String.valueOf(tailleDessin));
//			System.out.println("HG x=" + String.valueOf(xHautGauche));
//			System.out.println("HG y=" + String.valueOf(yHautGauche));

			// choix X ou O
			int symbole = coup.getJoueur() == premierJoueur ? 1 : 2;
			switch (symbole) {
			case 1:
				// dessin O
				g.drawOval(xHautGauche, yHautGauche, tailleDessin, tailleDessin);
				break;
			case 2:
				// dessin X diagonale HG -> BD
				g.drawLine(xHautGauche, yHautGauche,
						xHautGauche + tailleDessin, yHautGauche + tailleDessin);

				// dessin X diagonale BG -> HD
				g.drawLine(xHautGauche, yHautGauche + tailleDessin, xHautGauche
						+ tailleDessin, yHautGauche);
				break;
			default:
				break;
			}

		}

		// FIN dessin X / O -----------------------------

	}

    private MouseListener ml = new MouseAdapter() {
        public void mousePressed(MouseEvent e) {
            Point p = e.getPoint();
            
            
            //            String s = "not over image";
//            if(left.contains(p))
//                s = "left";
//            if(right.contains(p))
//                s = "right";
//            System.out.println("s = " + s);
        }
    };
 
}

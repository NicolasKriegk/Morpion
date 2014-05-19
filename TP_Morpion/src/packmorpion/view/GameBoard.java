package packmorpion.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import packmorpion.model.Coup;
import packmorpion.model.Joueur;
import packmorpion.model.ModelMorp;

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
	private Joueur premierJoueur;

	// public GameBoard(Model m, int largeur, int hauteur) {
	public GameBoard(ModelMorp model, int largeur, int hauteur) {
		// le -1 vient du fait que le positionnement commence à 0 (max = taille
		// - 1)
		this.yMax = hauteur - 1;
		this.xMax = largeur - 1;
		 this.m = model;
		this.lignes = m.getPlateau().getLigne();
		this.colonnes = m.getPlateau().getColonne();
		this.setPreferredSize(new Dimension(largeur, hauteur));

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

			// dessin de la ligne
			g.drawLine(xDebut, yDebut, xFin, yFin);
		}

		// FIN dessin de la grille -----------------------------------------

		// DEBUT dessin X / O -----------------------------
		premierJoueur = null;
		if (m.getListeCoups().size() > 0) {
			int xHautGauche = 0;
			int yHautGauche = 0;
			for (Coup coup : m.getListeCoups()) {
//				 for (Coup coup : coups) {
				// affectation premier joueur pour differencier symbole apres
				if (premierJoueur == null) {
					premierJoueur = coup.getJoueur();
				}

				// recuperation case jouee et calcul coordonnees debut dessin
				// symbole
				// coordonnees debut dessin: (num case sur x - 1) * (taille x) +
				// [(taille x) / 4]
				xHautGauche = ((coup.getCoordx() - 1) * xDimCase)
						+ (xDimCase / 4);
				yHautGauche = ((coup.getCoordy() - 1) * yDimCase)
						+ (yDimCase / 4);
				int tailleDessin = Math.min(xDimCase / 2, yDimCase / 2);

				// choix X ou O
				int symbole = coup.getJoueur() == premierJoueur ? 1 : 2;
				switch (symbole) {
				case 1:
					// dessin O
					g.drawOval(xHautGauche, yHautGauche, tailleDessin,
							tailleDessin);
					break;
				case 2:
					// dessin X diagonale HG -> BD
					g.drawLine(xHautGauche, yHautGauche, xHautGauche
							+ tailleDessin, yHautGauche + tailleDessin);

					// dessin X diagonale BG -> HD
					g.drawLine(xHautGauche, yHautGauche + tailleDessin,
							xHautGauche + tailleDessin, yHautGauche);
					break;
				default:
					break;
				}

			}
			// FIN dessin X / O -----------------------------


		}

	}

	public Coup getCoup(Point p) {
		Coup coup = new Coup();
		// les coordonnees du coup: coord du clic en x (ou y) divisé par nombre
		// colonnes (ou lignes) pour connaitre coordonnees case
		// +1 en offset pour commencer en ligne/colonne 1 et non 0
		coup.setCoordx((p.x / xDimCase) + 1);
		coup.setCoordy((p.y / yDimCase) + 1);

		return coup;
	}
}

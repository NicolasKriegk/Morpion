package packmorpion.view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GameBoard extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int hauteur;
	private int largeur;
	private int lignes;
	private int colonnes;

	public GameBoard(int lignes, int colonnes, int largeur, int hauteur) {
		this.hauteur = hauteur - 1;
		this.largeur = largeur - 1;
		this.lignes = lignes;
		this.colonnes = colonnes;
		this.setPreferredSize(new Dimension(largeur, hauteur));
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // paint parent's background

		// dessin du cadre
		g.drawLine(0, 0, largeur, 0);
		g.drawLine(largeur, 0, largeur, hauteur);
		g.drawLine(largeur, hauteur, 0, hauteur);
		g.drawLine(0, hauteur, 0, 0);

		// DEBUT dessin de la grille -----------------------------------------
		int xDebut;
		int xFin;
		int yDebut;
		int yFin;
		// dessin de toutes les colonnes
		for (int i = 1; i <= (colonnes - 1); i++) {
			// calcul des coordonnees de chaque colonne
			xDebut = (i * largeur / colonnes);
			xFin = xDebut;
			yDebut = 0;
			yFin = hauteur;
//			System.out.println("colonne " + i);
//			System.out.println("x1=" + xDebut + " y1=" + yDebut);
//			System.out.println("x2=" + xFin + " y2=" + yFin);
			// dessin de la colonne
			g.drawLine(xDebut, yDebut, xFin, yFin);
		}

		// dessin de toutes les lignes
		for (int i = 1; i <= (lignes - 1); i++) {
			// calcul des coordonnees de chaque ligne
			xDebut = 0;
			xFin = largeur;
			yDebut = (i * hauteur / lignes);
			yFin = yDebut;
//			System.out.println("ligne " + i);
//			System.out.println("x1=" + xDebut + " y1=" + yDebut);
//			System.out.println("x2=" + xFin + " y2=" + yFin);
			// dessin de la ligne
			g.drawLine(xDebut, yDebut, xFin, yFin);
		}

		// FIN dessin de la grille -----------------------------------------

	
	
	}



}

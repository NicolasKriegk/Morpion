package packmorpion.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import packmorpion.model.Model;

public class GameBoard extends Observable implements Observer {
    private Model m;
//    private JLabel secondLabel;
//    private JLabel minuteLabel;
//    private JLabel hourLabel;
//    private NumberFormat nFormat = new DecimalFormat("00");
    //entete
    private JPanel header;
    private JLabel headerNom;
    //plateau de jeu
    private JPanel board;
    private PlateauJeu boardPicture;
    //historique
    private JPanel histo;


    public GameBoard(Model m) {
        this.m = m;
        createGUI();
    }

    @Override
    public void update(Observable o, Object o1) {
//        NumberFormat nFormat = new DecimalFormat("00");

//        if (secondLabel != null) {
//            secondLabel.setText(nFormat.format(m.getSecond()));
//        }
//        if (minuteLabel != null) {
//            minuteLabel.setText(nFormat.format(m.getMinute()));
//        }
//        if (hourLabel != null) {
//            hourLabel.setText(nFormat.format(m.getHour()));
//        }
    }

    private void createGUI() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame jFrame = new JFrame();
                jFrame.setPreferredSize(new Dimension(800, 800));
                jFrame.setLocation(400,200);
                jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);

                // placement des elements principaux----------------------------------------------------------------
                jFrame.setLayout(new GridBagLayout());
                GridBagConstraints constraints = new GridBagConstraints();
                //entete
                constraints.gridy = 0;
                constraints.gridx = 0;
                constraints.gridwidth = 10;
                constraints.weightx = 1;
//                constraints.gridheight = 2;
                header = new JPanel();
                header.setBackground(Color.RED);
                headerNom = new JLabel();
//                header.setFont(new Font("Arial", Font.PLAIN, 40));
//                header.setText("Entete");
                header.add(headerNom);
                jFrame.add(header, constraints);

                //plateau de jeu
                constraints.gridy = 1;
                constraints.gridx = 0;
              constraints.gridheight = 4;
                constraints.gridwidth = 7;
                board = new JPanel();
                board.setBackground(Color.BLUE);
                //creation du plateau
                boardPicture = new PlateauJeu(5, 5, 200, 200);
                board.add(boardPicture);
//                boardPicture.repaint();
                jFrame.add(board, constraints);
//                jFrame.add(boardPicture, constraints);
//                jFrame.add(boardPicture);

                //historique
                constraints.gridx = 8;
                constraints.gridwidth = 3;
                histo = new JPanel();
                histo.setBackground(Color.GREEN);
                jFrame.add(histo, constraints);

//                //Inc Button
//                constraints.gridy = 0;
//                constraints.gridheight = 1;
//
//                JButton buttonIncSecond = new JButton("+");
//                buttonIncSecond.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent ae) {
//                        setChanged();
//                        notifyObservers(NotifList.INC_SEC);
//                    }
//                });
//                constraints.gridx = 5;
//                jFrame.add(buttonIncSecond, constraints);
//
//                JButton buttonIncMinute = new JButton("+");
//                buttonIncMinute.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent ae) {
//                        setChanged();
//                        notifyObservers(NotifList.INC_MIN);
//                    }
//                });
//                constraints.gridx = 3;
//                jFrame.add(buttonIncMinute, constraints);
//
//                JButton buttonIncHour = new JButton("+");
//                buttonIncHour.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent ae) {
//                        setChanged();
//                        notifyObservers(NotifList.INC_HOUR);
//                    }
//                });
//                constraints.gridx = 1;
//                jFrame.add(buttonIncHour, constraints);
//
//                //Dec Button
//                constraints.gridy = 3;
//
//                JButton buttonDecSecond = new JButton("-");
//                buttonDecSecond.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent ae) {
//                        setChanged();
//                        notifyObservers(NotifList.DEC_SEC);
//                    }
//                });
//                constraints.gridx = 5;
//                jFrame.add(buttonDecSecond, constraints);
//
//                JButton buttonDecMinute = new JButton("-");
//                buttonDecMinute.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent ae) {
//                        setChanged();
//                        notifyObservers(NotifList.DEC_MIN);
//                    }
//                });
//                constraints.gridx = 3;
//                jFrame.add(buttonDecMinute, constraints);
//
//                JButton buttonDecHour = new JButton("-");
//                buttonDecHour.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent ae) {
//                        setChanged();
//                        notifyObservers(NotifList.DEC_HOUR);
//                    }
//                });
//                constraints.gridx = 1;
//                jFrame.add(buttonDecHour, constraints);
//
//
//
//                //synch -raz
//                constraints.gridx = 6;
//                JButton buttonSync = new JButton("synch");
//                buttonSync.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent ae) {
//                        setChanged();
//                        notifyObservers(NotifList.SYNC);
//                    }
//                });
//                constraints.gridy = 1;
//                jFrame.add(buttonSync, constraints);
//
//                JButton buttonRaz = new JButton("raz");
//                buttonRaz.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent ae) {
//                        setChanged();
//                        notifyObservers(NotifList.RAZ);
//                    }
//                });
//                constraints.gridy = 2;
//                jFrame.add(buttonRaz, constraints);
//
//                //start - stop
//                constraints.gridx = 0;
//                JButton buttonStart = new JButton("start");
//                buttonStart.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent ae) {
//                        setChanged();
//                        notifyObservers(NotifList.START);
//                    }
//                });
//                constraints.gridy = 1;
//                jFrame.add(buttonStart, constraints);
//
//                JButton buttonStop = new JButton("stop");
//                buttonStop.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent ae) {
//                        setChanged();
//                        notifyObservers(NotifList.STOP);
//                    }
//                });
//                constraints.gridy = 2;
//                jFrame.add(buttonStop, constraints);

                jFrame.pack();
                jFrame.setVisible(true);
            }
        });


    }

    private class PlateauJeu extends JPanel {
        private int hauteur;
        private int largeur;
        private int lignes;
        private int colonnes;
    	
    	@Override
        public void paintComponent(Graphics g) {
           super.paintComponent(g);     // paint parent's background
           
           //dessin du cadre
           g.drawLine(0, 0, largeur, 0);
           g.drawLine(largeur, 0, largeur, hauteur);
           g.drawLine(largeur, hauteur, 0, hauteur);
           g.drawLine(0, hauteur, 0, 0);
           
           //dessin des colonnes de la grille
           int xDebut;
           int xFin;
           int yDebut;
           int yFin;
           //dessin de toutes les colonnes
           for(int i = 1;i<=(colonnes-1);i++){
        	   //calcul des coordonnees de chaque colonne
        	   xDebut = (i*largeur/colonnes);
        	   xFin = xDebut;
        	   yDebut = 0;
        	   yFin = hauteur;
        	   System.out.println("colonne "+ i);
        	   System.out.println("x1="+ xDebut + " y1="+ yDebut);
        	   System.out.println("x2="+ xFin + " y2="+ yFin);
        	   //dessin de la colonne
        	   g.drawLine(xDebut, yDebut, xFin, yFin);
           }

           //dessin de toutes les lignes
           for(int i = 1;i<=(lignes-1);i++){
        	   //calcul des coordonnees de chaque ligne
        	   xDebut = 0;
        	   xFin = largeur;
        	   yDebut = (i*hauteur/lignes);
        	   yFin = yDebut;
        	   System.out.println("ligne "+ i);
        	   System.out.println("x1="+ xDebut + " y1="+ yDebut);
        	   System.out.println("x2="+ xFin + " y2="+ yFin);
        	   //dessin de la ligne
        	   g.drawLine(xDebut, yDebut, xFin, yFin);
           }
           
           
        }
        public PlateauJeu(int lignes, int colonnes, int hauteur, int largeur){
//        	this.hauteur = 100;
//        	this.largeur = 100;
        	this.hauteur = hauteur-1;
        	this.largeur = largeur-1;
        	this.lignes = lignes;
        	this.colonnes = colonnes;
        	this.setPreferredSize(new Dimension(largeur,hauteur));
        }
    
    }
}

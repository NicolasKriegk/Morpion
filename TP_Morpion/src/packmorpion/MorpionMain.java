package packmorpion;

import java.util.ArrayList;
import java.util.List;

import packmorpion.controller.Controller;
import packmorpion.model.Coup;
import packmorpion.model.Joueur;
import packmorpion.model.ModelMorp;
import packmorpion.view.MainBoard;

public class MorpionMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        ModelMorp m = new ModelMorp();

        //TODELETE test
		 List<Coup> coups = new ArrayList<Coup>();
		 Joueur joueur1 = new Joueur("A");
		 Joueur joueur2 = new Joueur("B");
		 Coup coup1 = new Coup();
		 coup1.setJoueur(joueur1);
		 coup1.setCoordx(1);
		 coup1.setCoordy(2);
		 coups.add(coup1);
		 Coup coup2 = new Coup();
		 coup2.setJoueur(joueur2);
		 coup2.setCoordx(1);
		 coup2.setCoordy(1);
		 coups.add(coup2);
		 Coup coup3 = new Coup();
		 coup3.setJoueur(joueur1);
		 coup3.setCoordx(4);
		 coup3.setCoordy(4);
		 coups.add(coup3);
		 Coup coup4 = new Coup();
		 coup4.setJoueur(joueur2);
		 coup4.setCoordx(3);
		 coup4.setCoordy(3);
		 coups.add(coup4);
		 m.setListeCoups(coups);
		 //def plateau
		 m.setPlateau(5, 2, 2);
		 
        
        MainBoard v = new MainBoard(m);
        Controller c = new Controller(m, v);
        m.addObserver(v);
        v.addObserver(c);
	}

}

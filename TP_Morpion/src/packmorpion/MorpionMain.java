package packmorpion;

import packmorpion.model.Model;
import packmorpion.view.GameBoard;

public class MorpionMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        Model m = new Model();
        GameBoard v = new GameBoard(m);
//        Controller c = new Controller(m, v);
//        m.addObserver(v);
//        v.addObserver(c);
	}

}

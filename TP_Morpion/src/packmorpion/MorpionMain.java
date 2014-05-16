package packmorpion;

import packmorpion.model.Model;
import packmorpion.view.MainBoard;

public class MorpionMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        Model m = new Model();
        MainBoard v = new MainBoard(m);
//        Controller c = new Controller(m, v);
//        m.addObserver(v);
//        v.addObserver(c);
	}

}

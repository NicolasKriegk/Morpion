package packmorpion;

import packmorpion.model.ModelMorp;
import packmorpion.view.MainBoard;

public class MorpionMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        ModelMorp m = new ModelMorp();
        MainBoard v = new MainBoard(m);
//        Controller c = new Controller(m, v);
//        m.addObserver(v);
//        v.addObserver(c);
	}

}

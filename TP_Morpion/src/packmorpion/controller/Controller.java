package packmorpion.controller;

import java.util.Observable;
import java.util.Observer;

import packmorpion.model.ModelMorp;
import packmorpion.view.MainBoard;

public class Controller implements Observer {
	private ModelMorp m;
	private MainBoard mb;
	
	public Controller(ModelMorp m, MainBoard mb){
		this.m = m;
		this.mb = mb;
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

	
	
}

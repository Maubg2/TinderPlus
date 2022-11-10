package co.edu.unbosque.controller;

import co.edu.unbosque.view.MainView;

public class Controller {
	private MainView MV;
	
	public Controller() {
		MV = new MainView();
		MV.setSize(700,600);
		MV.setLocationRelativeTo(null);
		MV.setVisible(true);
	}
}

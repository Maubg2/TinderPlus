package co.edu.unbosque.view;

import javax.swing.JFrame;

public class MainView extends JFrame{
	
	private MainPanel MP;
	
	public MainView() {
		setLayout(null);
		MP = new MainPanel();
		add(MP);
	}
}
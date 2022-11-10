package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.JFrame;

public class MainView extends JFrame{
	
	private MainPanel MP;
	
	public MainView() {
		funcionar();
		getContentPane().setLayout(null);
	//	getContentPane().setBackground(Color.decode("#002B5B"));
		setTitle("TinderPlus");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
	
	public void funcionar() {
		MP = new MainPanel();
		MP.setBounds(0, 0, 800, 600);
		getContentPane().add(MP);
	}

	public MainPanel getMP() {
		return MP;
	}

	public void setMP(MainPanel mP) {
		MP = mP;
	}
	
}

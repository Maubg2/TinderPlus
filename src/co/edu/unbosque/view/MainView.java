package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainView extends JFrame{
	
	private MainPanel MP;
	
	public MainView() {
		
		//Wallpaper
		ImageIcon imageIcon = new ImageIcon("media/DefinitiveWallpaper.png"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(850, 800,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back
		setContentPane(new JLabel(imageIcon));
		
		
		funcionar();
		
		//General settings
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
		MP.setBounds(90, 80, 600, 400);
		getContentPane().add(MP);
		
		
	}

	public MainPanel getMP() {
		return MP;
	}

	public void setMP(MainPanel mP) {
		MP = mP;
	}
	
}

package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FirstView extends JFrame{
	
	private JButton likeButton;
	private JButton dislikeButton;
	private JButton backButton;
	
	public FirstView() {
		funcionar();
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.BLACK);
		setTitle("TinderPlus");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(false);
	}
	
	public void funcionar() {
		likeButton = new JButton("Like");
		likeButton.setBounds(20, 12, 12, 12);
		add(likeButton);
		
		dislikeButton = new JButton("Dislike");
		dislikeButton.setBounds(21, 42, 12, 21);
		add(dislikeButton);
		
		backButton = new JButton("Volver");
		backButton.setBounds(34, 94, 74, 34);
		add(backButton);
	}

	public JButton getLikeButton() {
		return likeButton;
	}

	public void setLikeButton(JButton likeButton) {
		this.likeButton = likeButton;
	}

	public JButton getDislikeButton() {
		return dislikeButton;
	}

	public void setDislikeButton(JButton dislikeButton) {
		this.dislikeButton = dislikeButton;
	}

	public JButton getBackButton() {
		return backButton;
	}

	public void setBackButton(JButton backButton) {
		this.backButton = backButton;
	}

}

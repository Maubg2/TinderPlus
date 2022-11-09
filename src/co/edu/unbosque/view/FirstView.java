package co.edu.unbosque.view;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FirstView extends JFrame{
	
	private JButton nn;
	
	public FirstView() {
		funcionar();
	}
	
	public void funcionar() {
		nn = new JButton("Hola");
		nn.setBounds(12, 12, 12, 12);
		add(nn);
	}

	public JButton getNn() {
		return nn;
	}

}

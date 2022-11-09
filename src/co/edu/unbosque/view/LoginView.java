package co.edu.unbosque.view;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class LoginView extends JFrame{
	
	private JLabel title;
	private DataPanelLoginView PData;
	
	public LoginView() {
		
		title = new JLabel("Iniciar sesión");
		title.setBounds(50, 20, 100, 200);
		title.setVisible(true);
		add(title);
		
		PData = new DataPanelLoginView();
		PData.setBounds(200, 200, 400, 400);
		PData.setVisible(true);
		add(PData);
	}

}

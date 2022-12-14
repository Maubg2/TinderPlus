package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * <h2>MainView</h2>
 * Clase que contiene, instancia y les da coordenadas a todos las vistas (JPanels)
 * 
 * @author J&M Sistemas
 */
public class MainView extends JFrame{
	
	private MainPanel MP;
	private LoginView LV;
	
	//Register
	private RegisterView RV;
	private MenRegisterPanel MRV;
	private WomenRegisterPanel WRP;
	
	//Login
	private MainUserView MUV;
	private MainAdminView MAV;
	
	//Settings
	final int xPanel = 90;
	final int yPanel = 80;
	final int widthPanel = 600;
	final int heightPanel = 400;
	/**
	 * Contructor de la clase  e instanciacion de la imagen de fondo
	 */
	public MainView() {
		
		//Wallpaper
		ImageIcon imageIcon = new ImageIcon("media/DefinitiveWallpaper.png"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(850, 800,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back
		setContentPane(new JLabel(imageIcon));
		//setUndecorated(true);
		
		//Frame icon
		ImageIcon frameIcon = new ImageIcon("media/pngegg.png");
		this.setIconImage(frameIcon.getImage());
		
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
	/**
	 * Instanciacion y coordenadas de todos los paneles
	 */
	public void funcionar() {
		
		MP = new MainPanel();
		MP.setBounds(xPanel, yPanel, 600, 400);
		getContentPane().add(MP);
		
		LV = new LoginView();
		LV.setBounds(xPanel, yPanel, 600, 400);
		getContentPane().add(LV);
		
		RV = new RegisterView();
		RV.setBounds(xPanel, yPanel, 600, 400);
		getContentPane().add(RV);
		
		MRV  = new MenRegisterPanel();
		MRV.setBounds(xPanel,yPanel, widthPanel, heightPanel);
		getContentPane().add(MRV);
		
		WRP = new WomenRegisterPanel();
		WRP.setBounds(xPanel,yPanel, widthPanel, heightPanel);
		getContentPane().add(WRP);
		
		MUV = new MainUserView();
		MUV.setBounds(xPanel,yPanel, widthPanel, heightPanel);
		getContentPane().add(MUV);
		
		MAV = new MainAdminView();
		MAV.setBounds(xPanel,yPanel, widthPanel, heightPanel);
		getContentPane().add(MAV);
	}

	public MenRegisterPanel getMRV() {
		return MRV;
	}

	public void setMRV(MenRegisterPanel mRV) {
		MRV = mRV;
	}

	public MainPanel getMP() {
		return MP;
	}

	public void setMP(MainPanel mP) {
		MP = mP;
	}

	public LoginView getLV() {
		return LV;
	}

	public void setLV(LoginView lV) {
		LV = lV;
	}

	public RegisterView getRV() {
		return RV;
	}

	public void setRV(RegisterView rV) {
		RV = rV;
	}

	public WomenRegisterPanel getWRP() {
		return WRP;
	}

	public void setWRP(WomenRegisterPanel wRP) {
		WRP = wRP;
	}

	public MainUserView getMUV() {
		return MUV;
	}

	public void setMUV(MainUserView mUV) {
		MUV = mUV;
	}

	public MainAdminView getMAV() {
		return MAV;
	}

	public void setMAV(MainAdminView mAV) {
		MAV = mAV;
	}
	
}

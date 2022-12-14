package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

/**
 * <h2>MainUserView</h2>
 * Clase que contiene los elementos graficos de la vista principal del usuario
 * 
 * @author J&M Sistemas
 */
public class MainUserView extends JPanel{
	
	private JLabel titleUserView;
	private JButton likeButtonUser;
	private JButton dislikeButtonUser;
	private JButton backButtonUser;
	
	
	private JLabel tinderTitle; 
	private ImageIcon image;
	
	private JLabel mainPrueba;
	private ImageIcon mainImage;
	
	//Información para el usuario
	private JLabel nameUserLabel;
	private JLabel usernameUserLabel;
	private JLabel ageUserLabel;
	private JLabel heightUserLabel;
	private JLabel salaryUserLabel;
	private JLabel divorceUserLabel;
	
	//Variables para los datos
	private JLabel nameUserData;
	private String nameValue;
	private JLabel usernameUserData;
	private String usernameValue;
	private JLabel ageUserData;
	private String ageValue;
	private JLabel heightUserData;
	private String heightValue;
	private JLabel salaryUserData;
	private String salaryValue;
	private JLabel divorceUserData;
	private String divorceValue;
	
	//Cambio de imágenes
	private String randomImage;

	/**
	 * Contructor de la clase
	 */
	public MainUserView() {
		
		setLayout(null);
		funcionar();
		setVisible(false);
		setBackground(Color.decode("#FFA1CF"));
		
	}
	/**
	 * Metodo para instanciar y darle coordenadas a los componentes
	 */
	public void funcionar() {
		
	/*	titleUserView = new JLabel("Tinder");
		titleUserView.setBounds(250, 10, 150, 50);
		titleUserView.setFont(new Font("Times New Roman", Font.BOLD, 25));
		add(titleUserView);*/
		
		likeButtonUser = new JButton("Like");
		likeButtonUser.setBounds(70, 300, 80, 30);
		likeButtonUser.setBackground(Color.decode("#EA047E"));
		likeButtonUser.setBorder(new EtchedBorder(100));
		likeButtonUser.setForeground(Color.WHITE);
		likeButtonUser.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(likeButtonUser);
		
		dislikeButtonUser = new JButton("Dislike");
		dislikeButtonUser.setBounds(450, 300, 80, 30);
		dislikeButtonUser.setBackground(Color.decode("#EA047E"));
		dislikeButtonUser.setBorder(new EtchedBorder(100));
		dislikeButtonUser.setForeground(Color.WHITE);
		dislikeButtonUser.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(dislikeButtonUser);
		
		backButtonUser = new JButton("Salir");
		backButtonUser.setBounds(260, 350, 80, 30);
		backButtonUser.setBackground(Color.decode("#EA047E"));
		backButtonUser.setBorder(new EtchedBorder(100));
		backButtonUser.setForeground(Color.WHITE);
		backButtonUser.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(backButtonUser);
		
		image = new ImageIcon("media/Tinder.png");
		tinderTitle = new JLabel();
		tinderTitle.setIcon(new ImageIcon(image.getImage().getScaledInstance(120, 70, Image.SCALE_SMOOTH)));
		tinderTitle.setBounds(240, 2, 120, 70);
		add(tinderTitle);
		
		mainPrueba = new JLabel();
		/*
		mainImage = new ImageIcon(randomImage);
		mainPrueba = new JLabel();
		mainPrueba.setIcon(new ImageIcon(mainImage.getImage().getScaledInstance(150, 130, Image.SCALE_SMOOTH)));
		mainPrueba.setBounds(224, 60, 150, 130);
		add(mainPrueba);
		*/
		
		nameUserLabel = new JLabel("Nombre: ");
		nameUserLabel.setBounds(220, 190, 200, 30);
		add(nameUserLabel);
		
		usernameUserLabel = new JLabel("Usuario: ");
		usernameUserLabel.setBounds(220, 210, 200, 30);
		add(usernameUserLabel);
		
		ageUserLabel = new JLabel("Edad: ");
		ageUserLabel.setBounds(220, 230, 200, 30);
		add(ageUserLabel);
		
		heightUserLabel = new JLabel("Altura: ");
		heightUserLabel.setBounds(220, 250, 200, 30);
		add(heightUserLabel);
		
		salaryUserLabel = new JLabel("Salario: ");
		salaryUserLabel.setBounds(220, 270, 200, 30);
		add(salaryUserLabel);
		
		divorceUserLabel = new JLabel("Divorcio: ");
		divorceUserLabel.setBounds(220, 290, 200, 30);
		add(divorceUserLabel);
		
		nameUserData = new JLabel(nameValue);
		nameUserData.setBounds(290, 190, 220, 30);
		add(nameUserData);
		
		usernameUserData = new JLabel(usernameValue);
		usernameUserData.setBounds(290, 210, 200, 30);
		add(usernameUserData);
		
		ageUserData = new JLabel(ageValue);
		ageUserData.setBounds(290, 230, 200, 30);
		add(ageUserData);
		
		heightUserData = new JLabel(heightValue);
		heightUserData.setBounds(290, 250, 200, 30);
		add(heightUserData);
		
		salaryUserData = new JLabel(salaryValue);
		salaryUserData.setBounds(290, 270, 200, 30);
		add(salaryUserData);
		
		divorceUserData = new JLabel(divorceValue);
		divorceUserData.setBounds(290, 290, 200, 30);
		add(divorceUserData);
		
	}
	/**
	 * Metodo para poner una imagen random en la vista principal
	 */
	public void updateImage() {
		mainImage = new ImageIcon(randomImage);
		
		mainPrueba.setIcon(new ImageIcon(mainImage.getImage().getScaledInstance(150, 130, Image.SCALE_SMOOTH)));
		mainPrueba.setBounds(224, 60, 150, 130);
		add(mainPrueba);
	}
	/**
	 * Metodo para poner en los JLabels los datos de un usuario
	 */
	public void updateUserData() {
		nameUserData.setText(nameValue);
		usernameUserData.setText(usernameValue);
		ageUserData.setText(ageValue);
		heightUserData.setText(heightValue);
		salaryUserData.setText(salaryValue);
		divorceUserData.setText(divorceValue);
	}
	
	public JLabel getTitleUserView() {
		return titleUserView;
	}

	public void setTitleUserView(JLabel titleUserView) {
		this.titleUserView = titleUserView;
	}

	public JButton getLikeButtonUser() {
		return likeButtonUser;
	}

	public void setLikeButtonUser(JButton likeButtonUser) {
		this.likeButtonUser = likeButtonUser;
	}

	public JButton getDislikeButtonUser() {
		return dislikeButtonUser;
	}

	public void setDislikeButtonUser(JButton dislikeButtonUser) {
		this.dislikeButtonUser = dislikeButtonUser;
	}

	public JButton getBackButtonUser() {
		return backButtonUser;
	}

	public void setBackButtonUser(JButton backButtonUser) {
		this.backButtonUser = backButtonUser;
	}

	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}

	public JLabel getNameUserData() {
		return nameUserData;
	}

	public void setNameUserData(JLabel nameUserData) {
		this.nameUserData = nameUserData;
	}

	public JLabel getUsernameUserData() {
		return usernameUserData;
	}

	public void setUsernameUserData(JLabel usernameUserData) {
		this.usernameUserData = usernameUserData;
	}

	public JLabel getAgeUserData() {
		return ageUserData;
	}

	public void setAgeUserData(JLabel ageUserData) {
		this.ageUserData = ageUserData;
	}

	public JLabel getHeightUserData() {
		return heightUserData;
	}

	public void setHeightUserData(JLabel heightUserData) {
		this.heightUserData = heightUserData;
	}

	public JLabel getSalaryUserData() {
		return salaryUserData;
	}

	public void setSalaryUserData(JLabel salaryUserData) {
		this.salaryUserData = salaryUserData;
	}

	public JLabel getDivorceUserData() {
		return divorceUserData;
	}

	public void setDivorceUserData(JLabel divorceUserData) {
		this.divorceUserData = divorceUserData;
	}

	public String getRandomImage() {
		return randomImage;
	}

	public void setRandomImage(String randomImage) {
		this.randomImage = randomImage;
	}

	//Data section
	
	public String getNameValue() {
		return nameValue;
	}

	public void setNameValue(String nameValue) {
		this.nameValue = nameValue;
	}

	public String getUsernameValue() {
		return usernameValue;
	}

	public void setUsernameValue(String usernameValue) {
		this.usernameValue = usernameValue;
	}

	public String getAgeValue() {
		return ageValue;
	}

	public void setAgeValue(String ageValue) {
		this.ageValue = ageValue;
	}

	public String getHeightValue() {
		return heightValue;
	}

	public void setHeightValue(String heightValue) {
		this.heightValue = heightValue;
	}

	public String getSalaryValue() {
		return salaryValue;
	}

	public void setSalaryValue(String salaryValue) {
		this.salaryValue = salaryValue;
	}

	public String getDivorceValue() {
		return divorceValue;
	}

	public void setDivorceValue(String divorceValue) {
		this.divorceValue = divorceValue;
	}
	
	
	
	

}

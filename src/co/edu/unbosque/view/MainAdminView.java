package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

public class MainAdminView extends JPanel{
	
	private JLabel titleAdminView;
	
	private JButton addAdminView;
	private JButton modifyAdminView;
	private JButton deleteAdminView;
	private JButton searchAdminView;
	
	private JComboBox keywordSortAdmin;
	private String listKeywordSort[] = {"Likes", "Apellido", "Nombre", "Edad", "Usuario"};
	private JLabel keywordSortLabel;
	
	private JComboBox orderListAdmin;
	private String listOrder[] = {"Ascendente", "Descendente"};
	private JLabel orderLabel;
	
	private JButton refreshListAdmin;
	
	private JButton backButtonAdmin;
	
	private JTextArea mainTextAreaAdmin;
	private JScrollPane mainScrollAdmin;
	
	public MainAdminView() {
		
		setLayout(null);
		funcionar();
		setVisible(false);
		setBackground(Color.decode("#FFA1CF"));
		
	}
	
	public void funcionar() {
		
		titleAdminView = new JLabel("Administrador");
		titleAdminView.setBounds(230, 2, 150, 70);
		titleAdminView.setForeground(Color.BLACK);
		titleAdminView.setFont(new Font("Times New Roman", Font.BOLD, 25));
		add(titleAdminView);
		
		addAdminView = new JButton("Añadir");
		addAdminView.setBounds(30, 120, 90, 25);
		addAdminView.setBackground(Color.decode("#EA047E"));
		addAdminView.setBorder(new EtchedBorder(100));
		addAdminView.setForeground(Color.WHITE);
		addAdminView.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(addAdminView);
		
		modifyAdminView = new JButton("Modificar");
		modifyAdminView.setBounds(30, 170, 90, 25);
		modifyAdminView.setBackground(Color.decode("#EA047E"));
		modifyAdminView.setBorder(new EtchedBorder(100));
		modifyAdminView.setForeground(Color.WHITE);
		modifyAdminView.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(modifyAdminView);
		
		deleteAdminView = new JButton("Eliminar");
		deleteAdminView.setBounds(30, 220, 90, 25);
		deleteAdminView.setBackground(Color.decode("#EA047E"));
		deleteAdminView.setBorder(new EtchedBorder(100));
		deleteAdminView.setForeground(Color.WHITE);
		deleteAdminView.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(deleteAdminView);
		
		searchAdminView = new JButton("Buscar");
		searchAdminView.setBounds(30, 270, 90, 25);
		searchAdminView.setBackground(Color.decode("#EA047E"));
		searchAdminView.setBorder(new EtchedBorder(100));
		searchAdminView.setForeground(Color.WHITE);
		searchAdminView.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(searchAdminView);
		
		keywordSortAdmin = new JComboBox(listKeywordSort);
		keywordSortAdmin.setBounds(350, 100, 100, 25);
		add(keywordSortAdmin);
		
		keywordSortLabel = new JLabel("Ordenar:");
		keywordSortLabel.setBounds(350, 70, 100, 25);
		add(keywordSortLabel);
		
		orderListAdmin = new JComboBox(listOrder);
		orderListAdmin.setBounds(230, 100, 100, 25);
		add(orderListAdmin);
		
		orderLabel = new JLabel("Ordenar de forma:");
		orderLabel.setBounds(230, 70, 130, 25);
		add(orderLabel);
		
		refreshListAdmin = new JButton("Refrescar");
		refreshListAdmin.setBounds(470, 100, 80, 25);
		refreshListAdmin.setBackground(Color.decode("#EA047E"));
		refreshListAdmin.setBorder(new EtchedBorder(100));
		refreshListAdmin.setForeground(Color.WHITE);
		refreshListAdmin.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(refreshListAdmin);
		
		backButtonAdmin = new JButton("Volver");
		backButtonAdmin.setBounds(30, 340, 90, 25);
		backButtonAdmin.setBackground(Color.decode("#EA047E"));
		backButtonAdmin.setBorder(new EtchedBorder(100));
		backButtonAdmin.setForeground(Color.WHITE);
		backButtonAdmin.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(backButtonAdmin);
		
		mainTextAreaAdmin = new JTextArea();
		mainTextAreaAdmin.setBounds(200, 130, 350, 250);
		mainTextAreaAdmin.setLineWrap(true);
		//	add(mainTextAreaAdmin);
		
		mainScrollAdmin = new JScrollPane(mainTextAreaAdmin);
		mainScrollAdmin.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		mainScrollAdmin.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		mainScrollAdmin.setBounds(200, 130, 350, 250);
		add(mainScrollAdmin);
	}

	public JButton getAddAdminView() {
		return addAdminView;
	}

	public void setAddAdminView(JButton addAdminView) {
		this.addAdminView = addAdminView;
	}

	public JButton getModifyAdminView() {
		return modifyAdminView;
	}

	public void setModifyAdminView(JButton modifyAdminView) {
		this.modifyAdminView = modifyAdminView;
	}

	public JButton getDeleteAdminView() {
		return deleteAdminView;
	}

	public void setDeleteAdminView(JButton deleteAdminView) {
		this.deleteAdminView = deleteAdminView;
	}

	public JButton getSearchAdminView() {
		return searchAdminView;
	}

	public void setSearchAdminView(JButton searchAdminView) {
		this.searchAdminView = searchAdminView;
	}

	public JComboBox getKeywordSortAdmin() {
		return keywordSortAdmin;
	}

	public void setKeywordSortAdmin(JComboBox keywordSortAdmin) {
		this.keywordSortAdmin = keywordSortAdmin;
	}

	public String[] getListKeywordSort() {
		return listKeywordSort;
	}

	public void setListKeywordSort(String[] listKeywordSort) {
		this.listKeywordSort = listKeywordSort;
	}

	public JComboBox getOrderListAdmin() {
		return orderListAdmin;
	}

	public void setOrderListAdmin(JComboBox orderListAdmin) {
		this.orderListAdmin = orderListAdmin;
	}

	public String[] getListOrder() {
		return listOrder;
	}

	public void setListOrder(String[] listOrder) {
		this.listOrder = listOrder;
	}

	public JButton getRefreshListAdmin() {
		return refreshListAdmin;
	}

	public void setRefreshListAdmin(JButton refreshListAdmin) {
		this.refreshListAdmin = refreshListAdmin;
	}

	public JButton getBackButtonAdmin() {
		return backButtonAdmin;
	}

	public void setBackButtonAdmin(JButton backButtonAdmin) {
		this.backButtonAdmin = backButtonAdmin;
	}

	public JTextArea getMainTextAreaAdmin() {
		return mainTextAreaAdmin;
	}

	public void setMainTextAreaAdmin(JTextArea mainTextAreaAdmin) {
		this.mainTextAreaAdmin = mainTextAreaAdmin;
	}

}

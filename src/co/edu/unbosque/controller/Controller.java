package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import co.edu.unbosque.view.MainView;

public class Controller implements ActionListener{
	
	private MainView mainView;
	
	public Controller() {
		
		mainView = new MainView();
		mainView.getFirstView().setVisible(true);
		setListeners();
		
	}
	
	public void setListeners() {
		mainView.getFirstView().getLikeButton().addActionListener(this);
		mainView.getFirstView().getLikeButton().setActionCommand("like");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "like":
			mainView.getFirstView().setVisible(false);
			mainView.getLoginView().setVisible(true);
			break;
		}
	}
}

package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import co.edu.unbosque.view.MainView;

public class Controller implements ActionListener{
	
	private MainView mainView;
	
	public Controller() {
		
		mainView = new MainView();
		mainView.getFV().setVisible(true);
		setListeners();
		
	}
	
	public void setListeners() {
		mainView.getFV().getNn().addActionListener(this);
		mainView.getFV().getNn().setActionCommand("si");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		
		}
	}
}

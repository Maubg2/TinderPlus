package co.edu.unbosque.view;

public class MainView{
	
	private FirstView FV;
	private LoginView LV;
	
	public MainView() {
		
		funcionar();
		
	}
	
	public void funcionar() {
		FV = new FirstView();
		FV.setSize(500, 500);
		FV.setVisible(false);
		
		LV = new LoginView();
		FV.setSize(700, 500);
		FV.setVisible(false);
	}

	public FirstView getFV() {
		return FV;
	}

	public LoginView getLV() {
		return LV;
	}
	
}

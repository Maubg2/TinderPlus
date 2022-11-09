package co.edu.unbosque.view;

public class MainView{
	
	private FirstView firstView;
	private LoginView loginView;
	
	public MainView() {
		
		funcionar();
		
	}
	
	public void funcionar() {
		firstView = new FirstView();
	/*	firstView.setSize(500, 500);
		firstView.setVisible(false);*/
		
		loginView = new LoginView();
		loginView.setSize(700, 500);
		loginView.setVisible(false);
	}

	public FirstView getFirstView() {
		return firstView;
	}

	public void setFirstView(FirstView firstView) {
		this.firstView = firstView;
	}

	public LoginView getLoginView() {
		return loginView;
	}

	public void setLoginView(LoginView loginView) {
		this.loginView = loginView;
	}

}

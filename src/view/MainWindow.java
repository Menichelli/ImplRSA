package view;

import javax.swing.JFrame;

public class MainWindow extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private static MainWindow instance;
	
	private MainWindow() {
		super();
		this.setTitle("Implementation de RSA");
		
		
		
		this.setSize(300, 300);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	};
	
	public static MainWindow getInstance() {
		instance = (instance==null)?new MainWindow():instance;
		return instance;
	}
	
}

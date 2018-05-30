package views;

import java.awt.CardLayout;

import javax.swing.JFrame;

import controller.Control;

public class MainWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	private MenuPanel menuPanel;
	private CardLayout cardLayout;
	private TutorialPanel gamePanel;
	
	public MainWindow(Control control) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setTitle("LastManStanding");

		cardLayout = new CardLayout();
		setLayout(cardLayout);
		
		menuPanel = new MenuPanel(control);
		gamePanel = new TutorialPanel();
		add(menuPanel,"MainMenu");
		add(gamePanel,"NewGame");
		setVisible(true);
	}
	
	public void newGame() {
		cardLayout.show(this.getContentPane(), "NewGame");
	}
	
}

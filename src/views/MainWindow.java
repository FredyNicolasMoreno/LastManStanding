package views;

import java.awt.CardLayout;
import java.awt.Rectangle;

import javax.swing.JFrame;

import controller.Control;

public class MainWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	private MenuPanel menuPanel;
	private CardLayout cardLayout;
	private TutorialPanel gamePanel;
	
	public MainWindow(Rectangle player, Control control) {
		this.addKeyListener(control);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setTitle("LastManStanding");

		menuPanel = new MenuPanel(control);

		add(menuPanel);
		
		setVisible(true);
	}
	
//	public void newGame() {
//		cardLayout.show(this.getContentPane(), "NewGame");
//	}
	
	public void repaintWIndow(Rectangle player) {
		gamePanel.repaintAll(player);
		repaint();
	}
	
}

package views;

import java.awt.Rectangle;

import javax.swing.JFrame;

import controller.Control;

public class MainWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	private MenuPanel menuPanel;
	private TutorialPanel gamePanel;
	
	public MainWindow(Rectangle player, Rectangle gun, Rectangle bullet, Control control) {
		this.addKeyListener(control);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setTitle("LastManStanding");

		menuPanel = new MenuPanel(control);

		add(menuPanel);
		
		setVisible(true);
	}
	
	
	public void repaintWIndow(Rectangle player, Rectangle gun, Rectangle bullet) {
		gamePanel.repaintAll(player, gun, bullet);
		repaint();
	}
	
	
}

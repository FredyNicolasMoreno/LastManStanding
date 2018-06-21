package views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JFrame;

import controller.Control;
import models.GameManager;

public class MultiplayerWindow extends JFrame{

	private static final long serialVersionUID = 1L;

	private MultiplayerPanel multiplayerPanel;
	
	public MultiplayerWindow(Rectangle playerLL, Rectangle gun, Rectangle bullets,Control control) {
		
		this.addKeyListener(control);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		
		
		multiplayerPanel = new MultiplayerPanel(control);
		
		add(multiplayerPanel);
	}

	public void repaintWIndow(GameManager game) {
		multiplayerPanel.setAll(game);
		repaint();
	}
	
	public int getPanelWidth() {
		System.out.println(multiplayerPanel.getWidth());
		return multiplayerPanel.getWidth();
	}
	
}

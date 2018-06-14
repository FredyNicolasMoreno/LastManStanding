package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import models.Player;
import views.MainWindow;
import views.TutorialPanel;

public class Control implements ActionListener, KeyListener{

	private MainWindow mainWindow;
	private Player player;
	private TutorialPanel tutorialPanel;
	
	public Control() {
		player = new Player();
		mainWindow = new MainWindow(player.getPlayer(), this);
		tutorialPanel = new TutorialPanel(player.getPlayer(), this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (Actions.valueOf(e.getActionCommand())) {
		case NEW_GAME:
			mainWindow.setVisible(false);
			tutorialPanel.setVisible(true);
			break;

		default:
			break;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			System.out.println("Izq");
			player.moveLeft();
			tutorialPanel.repaintAll(player.getPlayer());
			break;
		case KeyEvent.VK_RIGHT:
			System.out.println("Der");
			player.moveRight();
			tutorialPanel.repaintAll(player.getPlayer());
			break;
		case KeyEvent.VK_SPACE:
			System.out.println("Arriba");
			player.moveUp();
			tutorialPanel.repaintAll(player.getPlayer());
			break;
		case KeyEvent.VK_Z:
			
			break;
		default:
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
	
}

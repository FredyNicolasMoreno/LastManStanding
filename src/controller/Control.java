package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import models.GameManager;
import views.MainWindow;
import views.TutorialPanel;

public class Control implements ActionListener, KeyListener{

	private MainWindow mainWindow;
	private TutorialPanel tutorialPanel;
	private GameManager gameManager;
	
	
	public Control() {
		gameManager = new GameManager();
		mainWindow = new MainWindow(gameManager.getPlayer().getPlayer(), gameManager.getGun().getGun(), gameManager.getBullets().getBullet(), this);
		tutorialPanel = new TutorialPanel(gameManager.getPlayer().getPlayer(), gameManager.getGun().getGun(), gameManager.getBullets().getBullet(), this);
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
			gameManager.moveLeft();
			tutorialPanel.repaintAll(gameManager.getPlayer().getPlayer(), gameManager.getGun().getGun(), gameManager.getBullets().getBullet());
			break;
		case KeyEvent.VK_RIGHT:
			gameManager.moveRight();
			tutorialPanel.repaintAll(gameManager.getPlayer().getPlayer(), gameManager.getGun().getGun(), gameManager.getBullets().getBullet());
			break;
		case KeyEvent.VK_UP:
			gameManager.moveUp();
			tutorialPanel.repaintAll(gameManager.getPlayer().getPlayer(), gameManager.getGun().getGun(), gameManager.getBullets().getBullet());
			break;
		case KeyEvent.VK_DOWN:
			gameManager.moveDown();
			tutorialPanel.repaintAll(gameManager.getPlayer().getPlayer(), gameManager.getGun().getGun(), gameManager.getBullets().getBullet());
			break;
		case KeyEvent.VK_Z:
			gameManager.shoot();
			tutorialPanel.repaintAll(gameManager.getPlayer().getPlayer(), gameManager.getGun().getGun(), gameManager.getBullets().getBullet());
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

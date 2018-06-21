package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import models.GameManager;
import views.MainWindow;
import views.MultiplayerWindow;
import views.TutorialPanel;

public class Control implements ActionListener, KeyListener{

	private MainWindow mainWindow;
	private TutorialPanel tutorialPanel;
	private MultiplayerWindow gameWindow;
	private GameManager gameManager;
	
	
	public Control() {
		gameManager = new GameManager(30);
		mainWindow = new MainWindow(gameManager.getPlayer().getPlayer(), gameManager.getGun().getGun(), gameManager.getBullets().getBullet(), this);
		tutorialPanel = new TutorialPanel(gameManager.getPlayer().getPlayer(), gameManager.getGun().getGun(), gameManager.getBullets().getBullet(), this);
		gameWindow = new MultiplayerWindow(gameManager.getPlayer().getPlayer(), gameManager.getGun().getGun(), gameManager.getBullets().getBullet(), this);
		Timer timer = new Timer(10, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tutorialPanel.repaintAll(gameManager.getPlayer().getPlayer(), gameManager.getGun().getGun(), gameManager.getBullets().getBullet());
				gameWindow.repaintWIndow(gameManager);
			}
		});
		timer.start();
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (Actions.valueOf(e.getActionCommand())) {
		case NEW_GAME:
			mainWindow.setVisible(false);
			tutorialPanel.setVisible(true);
			break;
		case BACK:
			mainWindow.setVisible(true);
			tutorialPanel.setVisible(false);
			break;
		case MULTIPLAYER:
			mainWindow.setVisible(false);
			gameWindow.setVisible(true);
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
			break;
		case KeyEvent.VK_RIGHT:
			gameManager.moveRight();
			break;
		case KeyEvent.VK_UP:
			gameManager.moveUp();
			break;
		case KeyEvent.VK_DOWN:
			gameManager.moveDown();
			break;
		case KeyEvent.VK_Z:
			gameManager.addBullets();
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

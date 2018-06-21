package views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;

import controller.Control;
import models.Bullets;
import models.GameManager;

public class MultiplayerPanel extends JPanel{

	private static final long serialVersionUID = 1L;

	private GameManager gameManager;
	
	public MultiplayerPanel(Control control) {
		this.addKeyListener(control);
		setBackground(Color.BLACK);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		if(gameManager!=null) {
			
			g.setColor(Color.YELLOW);
			g.fillRect(gameManager.getPlayer().getPlayer().x, gameManager.getPlayer().getPlayer().y, (int)gameManager.getPlayer().getPlayer().width, (int)gameManager.getPlayer().getPlayer().height);
			
			for (Bullets bullet : gameManager.getArrayBullets()) {
				g.setColor(Color.WHITE);
				g.fillRect(bullet.getBullet().x, bullet.getBullet().y, (int)bullet.getBullet().width, (int)bullet.getBullet().height);
			}
			
			g.setColor(Color.RED);
			g.fillRect(gameManager.getGun().getGun().x, gameManager.getGun().getGun().y, (int)gameManager.getGun().getGun().width, (int)gameManager.getGun().getGun().height);
			
		}
	}
	
	public void setAll(GameManager game) {
		this.gameManager = game;
		repaint();
		revalidate();
	}
	
	
	
}

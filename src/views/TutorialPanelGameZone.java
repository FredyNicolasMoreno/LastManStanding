package views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;

import controller.Control;

public class TutorialPanelGameZone extends JPanel{

	private static final long serialVersionUID = 1L;

	private Rectangle player;
	private Rectangle bullet;
	private Rectangle guns;
	
	public TutorialPanelGameZone(Rectangle playerLL, Rectangle gun, Rectangle bullets,Control control) {
		this.addKeyListener(control);
		setBackground(Color.BLACK);
		player = new Rectangle(playerLL.x, playerLL.y, playerLL.width, playerLL.height);
		guns = new Rectangle(gun.x, gun.y, gun.width, gun.height);
		bullet = new Rectangle(bullets.x, bullets.y, bullets.width, bullets.height);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.GRAY);
		g.fillRect(0, 350, 1500, 50);
		
		g.setColor(Color.YELLOW);
		g.fillRect(player.x, player.y, (int)player.width, (int)player.height);
		
		g.setColor(Color.WHITE);
		g.fillRect(bullet.x, bullet.y, (int)bullet.width, (int)bullet.height);
		
		g.setColor(Color.RED);
		g.fillRect(guns.x, guns.y, (int)guns.width, (int)guns.height);
	}
	
	public void setAll(Rectangle playerLL, Rectangle gun, Rectangle bullets) {
		this.player = playerLL;
		this.guns = gun;
		this.bullet = bullets;
		repaint();
		revalidate();
	}
}

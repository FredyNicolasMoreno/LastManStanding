package views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;

import controller.Control;

public class TutorialPanelGameZone extends JPanel{

	private static final long serialVersionUID = 1L;

	private Rectangle player;
	
	public TutorialPanelGameZone(Rectangle playerLL, Control control) {
		this.addKeyListener(control);
		setBackground(Color.BLACK);
		player = new Rectangle(playerLL.x, playerLL.y, playerLL.width, playerLL.height);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.GRAY);
		g.fillRect(0, 350, 1500, 50);
		
		g.setColor(Color.YELLOW);
		g.fillRect(player.x, player.y, (int)player.width, (int)player.height);
		
		g.setColor(Color.RED);
		g.fillRect(800, 320, 30, 30);
	}
	
	public void setPlayer(Rectangle playerLL) {
		this.player = playerLL;
		repaint();
		revalidate();
	}
	
}

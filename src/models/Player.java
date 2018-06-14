package models;

import java.awt.Rectangle;

public class Player {

	private Rectangle player;
	
	public Player() {
		player = new Rectangle(0,300,50,50);
	}

	public Rectangle getPlayer() {
		return player;
	}
	
	public void moveRight() {
		player.setLocation(player.x+50, player.y);
	}
	public void moveLeft() {
		player.setLocation(player.x - 50, player.y);
	}
	public void moveUp() {
		player.setLocation(player.x, player.y - 50);
	}

	public void setPlayer(Rectangle player) {
		this.player = player;
	}
	
	
}
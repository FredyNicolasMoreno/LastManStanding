package models;

import java.awt.Rectangle;

public class Gun {


	private Rectangle gun;

	public Gun() {
		gun = new Rectangle(800, 320, 30, 30);
	}

	public void move(Rectangle player, int viewX, int viewY) {
		gun.setLocation(player.x + viewX, player.y + viewY);
	}

	public Rectangle getGun() {
		return gun;
	}
}

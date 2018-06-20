package models;

import java.awt.Rectangle;

public class Bullets {

	private Rectangle bullet;

	public Bullets() {
		
	}
	
	public Bullets(int x, int y) {
		bullet = new Rectangle(x, y, 10, 10);
	}

	public Rectangle getBullet() {
		return bullet;
	}
	
}

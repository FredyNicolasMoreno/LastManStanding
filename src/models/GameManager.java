package models;

import java.awt.Rectangle;
import java.util.ArrayList;

public class GameManager {

	private Gun gun;
	private Player player;
	private Bullets bullet;
	private ArrayList<Bullets> bullets;
	private boolean got = false;
	private boolean impact = false;
	
	public GameManager() {
		player = new Player();
		gun = new Gun();
		bullets = new ArrayList<Bullets>();
		bullet = new Bullets(gun.getGun().x, gun.getGun().y);
	}
	
	
	public void moveLeft() {
		player.moveLeft();
		grab(gun.getGun());
		if(got) {
			gun.move(player.getPlayer(), -30, 0);
		}
		
	}
	
	public void moveRight() {
		player.moveRight();
		grab(gun.getGun());
		if(got) {
			gun.move(player.getPlayer(), 50, 0);
		}
	}
	
	public void moveUp() {
		player.moveUp();
		grab(gun.getGun());
		if(got) {
			gun.move(player.getPlayer(), 0, -30);
		}
	}
	
	public void moveDown() {
		player.moveDown();
		grab(gun.getGun());
		if(got) {
			gun.move(player.getPlayer(), 0, 50);
		}
	}
	

	private void grab(Rectangle gun2) {
		if(!got) {
			if(player.getPlayer().intersects(gun2)) {
				got = true;
			}
		}
	}
	
	private void bulletImpact(Rectangle bullet) {
		if(!impact) {
			if(player.getPlayer().intersects(bullet)) {
				impact = true;
			}
		}
	}
	
	public void shoot() {
		bullet = new Bullets(gun.getGun().x, gun.getGun().y);
		bullets.add(bullet);
		bulletImpact(bullet.getBullet());
		if(gun.getGun().x > bullet.getBullet().x) {
			while (!impact) {
				bullet.getBullet().setLocation(bullet.getBullet().x + 50, bullet.getBullet().y);
			}
		}else if(gun.getGun().x < bullet.getBullet().x) {
			while (!impact) {
				bullet.getBullet().setLocation(bullet.getBullet().x - 50, bullet.getBullet().y);
			}
		}
		System.out.println(impact);
	}


	public Gun getGun() {
		return gun;
	}


	public Player getPlayer() {
		return player;
	}


	public Bullets getBullets() {
		return bullet;
	}


	
}

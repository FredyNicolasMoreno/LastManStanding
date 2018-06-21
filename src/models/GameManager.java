package models;

import java.awt.Rectangle;
import java.util.ArrayList;

import views.MultiplayerWindow;

public class GameManager extends GameThread{

	private Gun gun;
	private Player player;
	private Bullets bullet;
	private ArrayList<Bullets> bullets;
	private MultiplayerWindow multiplayerWindow;
	private boolean got = false;
	private boolean impact = false;
	private boolean viewLeft = false;
	private boolean viewRigth = false;
	private boolean viewUp = false;
	private boolean viewDown = false;
	
	public GameManager(int sleep) {
		super(sleep);
		player = new Player();
		gun = new Gun();
		bullets = new ArrayList<Bullets>();
		bullet = new Bullets(gun.getGun().x, gun.getGun().y);
		start();
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
		for (Bullets bullet : bullets) {
			if(viewLeft) {
				bullet.getBullet().setLocation(bullet.getBullet().x - 50, bullet.getBullet().y);
			}else if(viewRigth){
				bullet.getBullet().setLocation(bullet.getBullet().x + 50, bullet.getBullet().y);
			}else if(viewUp) {
				bullet.getBullet().setLocation(bullet.getBullet().x, bullet.getBullet().y - 50);
			}else if(viewDown) {
				bullet.getBullet().setLocation(bullet.getBullet().x, bullet.getBullet().y + 50);
			}
			if(bullet.getBullet().x > 1500 ||bullet.getBullet().x<0) {
				bullet.getBullet().setLocation(8000, 8000);
			}else if(bullet.getBullet().y > 1800 ||bullet.getBullet().y<0) {
				bullet.getBullet().setLocation(8000, 8000);
			}
		}
	}

	public void addBullets() {
		bullets.add(new Bullets((int)gun.getGun().x, gun.getGun().y));
		if(gun.getGun().x > player.getPlayer().x) {
			viewLeft = false;
			viewRigth = true;
			viewUp = false;
			viewDown = false;
		}else if(gun.getGun().x < player.getPlayer().x) {
			viewLeft = true;
			viewRigth = false;
			viewUp = false;
			viewDown = false;
		}else if(gun.getGun().y < player.getPlayer().y) {
			viewLeft = false;
			viewRigth = false;
			viewUp = true;
			viewDown = false;
		}else if(gun.getGun().y > player.getPlayer().y) {
			viewLeft = false;
			viewRigth = false;
			viewUp = false;
			viewDown = true;
		}
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

	public ArrayList<Bullets> getArrayBullets(){
		return bullets;
	}
	

	@Override
	public void executeTask() {
		shoot();
	}


	
}

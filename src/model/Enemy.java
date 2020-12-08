package model;

import processing.core.PApplet;

public class Enemy extends Character implements Runnable {

	public Enemy(int backX, int posX, int posY, PApplet app) {
		super(backX, posX, posY, app);
	}


	public void move() {
		
	}
	
	
	public void run() {
		move();
	}

}

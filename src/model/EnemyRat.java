package model;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class EnemyRat extends Enemy implements Runnable{

	PImage rat;
	int dirX, vel;
	
	public EnemyRat(int backX, int posX, int posY, int dirX, int vel,PApplet app) {
		super(backX, posX, posY, app);
		// TODO Auto-generated constructor stub
		rat= app.loadImage("./pngs/characters/rat.png");

		this.dirX = 1;
		this.vel = 1;
	}
	
	
	public void run() {
		try {
			Thread.sleep(1000);
			move();
		} catch (InterruptedException e) {
			e.printStackTrace();
			
			}
	}

	
	public void move() {
		posX = posX + dirX*vel;
		if(this.posX >= 20 || this.posX <= 200 || this.posX >= 400 || this.posX <= 500) {
			this.dirX = this.dirX*-1;
		}
	}
	
	public void draw() {
		app.imageMode(PConstants.CENTER);
		app.image(rat, 180*(posX), 175*(posY-1),140,140);
	}
}

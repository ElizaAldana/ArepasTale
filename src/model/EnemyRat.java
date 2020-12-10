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
		//int a = posX;
		posX = posX + vel*dirX;
		if(posX <= 5) {
			dirX = dirX*-1;
		}
		if(posX >= 8) {
			dirX = dirX*-11;
		}
		
	}
	
	public void draw(int backX) {
		app.imageMode(PConstants.CENTER);
		app.image(rat, ((140*(posX))+65)+140*backX, (150+25)*(posY-1) ,140,140);
	}
}

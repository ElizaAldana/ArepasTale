package model;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class EnemyFire extends Enemy implements Runnable{
	
	PImage fire;

	public EnemyFire(int backX, int posX, int posY, PApplet app) {
		super(backX, posX, posY, app);
		fire= app.loadImage("./pngs/characters/fogon.png");

	}

	public void draw(int backX) {
		app.imageMode(PConstants.CENTER);
		app.image(fire, ((140*(posX))+71)+140*backX, (150+20)*(posY-1) ,131,160);
	}
}

package model;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class EnemyKnife extends Enemy{

	PImage cuchillo;
	
	public EnemyKnife(int backX, int posX, int posY, PApplet app) {
		super(backX, posX, posY, app);

			
		cuchillo= app.loadImage("./pngs/characters/cuchillo.png");


	}
	
	public void draw(int backX) {
		app.imageMode(PConstants.CENTER);
		app.image(cuchillo, 180*posX+140*backX, 175*(posY-1) ,45,219);
	}
	

}

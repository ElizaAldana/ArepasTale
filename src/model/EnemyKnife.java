package model;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class EnemyKnife extends Enemy{

	PImage cuchillo;
	//PImage cuchillo2;
	
	public EnemyKnife(int backX, int posX, int posY, PApplet app) {
		super(backX, posX, posY, app);

		
		
		cuchillo= app.loadImage("./pngs/characters/cuchillo.png");
		//cuchillo2= app.loadImage("./pngs/characters/cuchillo2.png");


	}
	
	public void draw(int backX) {
		app.imageMode(PConstants.CENTER);
		app.image(cuchillo, 180*posX+140*backX, 175*(posY-1) ,45,219);
		//app.image(cuchillo2,180*posX+140*backX, 175*(posY-1) ,140,140);
	}
	

}

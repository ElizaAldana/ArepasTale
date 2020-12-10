package model;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Cheese {
	
	PImage cheese;
	PApplet app;
	int posX, posY, backX;
	
	public Cheese(int backX, int posX, int posY, PApplet app) {
		cheese= app.loadImage("./pngs/characters/coin.png");
		this.app = app;
		this.posX = posX;
		this.posY = posY;
	}
	
	

	public void draw(int backX) {
		app.imageMode(PConstants.CENTER);
		app.image(cheese, 210*(posX)+140*backX, 60*(posY-1),100,100);
	}
}

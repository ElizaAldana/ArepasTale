package model;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Arepa extends Character{
	PImage img;
	
	public Arepa(int backX, int posX, int posY, PApplet app) {
		super(backX, posX,  posY, app);
		// TODO Auto-generated constructor stub
		img= app.loadImage("./pngs/characters/arepaSize.png");
		
	}
	
	public void move(int d) {
	
		switch (d) {
		case 0://care
			posY = posY -1;
			
			break;
		case 1:// saltar
			
			posY = posY +1;
			
			
			break;
			}
	}
	public void draw() {
		app.imageMode(PConstants.CORNER);
		app.image(img, 140*(posX), 150*(posY-1),140,140);
	}

	

	
	public int getPosXd() {
		return 140*(posX);
	}

	public int getPosYd() {
		return  150*(posY-1);
	}

}

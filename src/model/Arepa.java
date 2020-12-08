package model;

import processing.core.PApplet;

public class Arepa extends Character {

	public Arepa(int backX, int posX, int posY, PApplet app) {
		super(backX, posX, posY, app);
		// TODO Auto-generated constructor stub
	}

	public void move(int d) {
	
		switch (d) {
		case 0:// saltar
			posY = posY + 50;
			app.delay(3);
			posY = posY + 50;
			break;

		case 1:

			break;

		}
	}

}

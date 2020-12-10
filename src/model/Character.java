package model;

import processing.core.PApplet;

import processing.core.PImage;

abstract class Character {
	public int backX;

	public int posX, posY;	

	protected PApplet app;
	PImage cheese;

	public Character(int backX, int posX, int posY, PApplet app) {
		this.posX = posX;
		this.posY = posY;
		this.app = app;
	

	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return  posY;
	}
}
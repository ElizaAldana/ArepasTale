package model;

import processing.core.PApplet;

import processing.core.PImage;

abstract class Character {
	public int backX;
	public int posX;
	public float posY;
	protected PApplet app;
	PImage cheese;

	public Character(int backX, int posX, float posY2, PApplet app) {
		this.posX = posX;
		this.posY = posY2;
		this.app = app;

	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return (int) posY;
	}
}
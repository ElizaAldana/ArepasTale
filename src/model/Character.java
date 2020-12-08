package model;
import processing.core.PApplet;

abstract class Character {
	public int backX;
public int posX;
public int posY;
protected PApplet app;

public Character(int backX,int posX,int posY, PApplet app) {
	this.posX = posX;
	this.posY = posY;
	this.app=app;
}
public int getPosX() {
	return posX;
}public int getPosY() {
	return posY;
}
}
package model;

import processing.core.PApplet;

public class Nombre implements Comparable <Nombre>{

	private PApplet app;
	private String name;
	
	public Nombre(String name,PApplet app) {
		super();
		this.app=app;
		this.name=name;
		
	}
	public int compareTo(Nombre n) {
		return this.getName().compareTo(n.getName()); 
	}

	public void draw(int x, int y) {
		app.fill(0);
		app.text(this.name, x, y);
		y+=70;
	}
	
	
	//Getters & Setters
	public PApplet getApp() {
		return app;
	}


	public void setApp(PApplet app) {
		this.app = app;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

}

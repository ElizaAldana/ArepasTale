package controller;

import model.Logic;
import processing.core.PApplet;

public class Controller {
	private Logic logica;

	public Controller(PApplet app) {
		this.logica = new Logic(app);
	}
	
	public void mouseClick() {
		this.logica.mouseClicked();
		
	}
	public void draw() {
		this.logica.draw();
	}

	public void move(int i) {
		logica.move(i);
		
	}
	public void sort(int s) {
		logica.sortList(s);
	}
	
	
}

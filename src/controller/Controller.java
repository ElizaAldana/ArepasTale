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
		this.logica.draw();
	}
	
}

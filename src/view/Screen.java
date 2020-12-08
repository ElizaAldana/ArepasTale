package view;

import controlP5.ControlP5;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Screen {

	PApplet app;
	PImage image;
	ControlP5 cp5;
	public  Screen(PApplet app) {
		this.app = app;
		cp5 = new ControlP5(app);
	}
	public void draw() {
		app.imageMode(PConstants.CORNER);
		app.image(image,0,0,app.width,app.height);
	}
}

package view;

import processing.core.PApplet;
import processing.core.PConstants;

public class ScreenGame extends Screen{

	public ScreenGame(PApplet app) {
		super(app);
		image= app.loadImage("pngs/Pantallas/Background.png");
		// TODO Auto-generated constructor stub
	}
	public void draw() {
		app.imageMode(PConstants.CORNER);
		app.image(image,0,0,9004,app.height);
	}
}

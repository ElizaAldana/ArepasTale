package view;

import processing.core.PApplet;

public class ScreenScore extends Screen {

	private int score;
	
	public ScreenScore(PApplet app) {
	super(app);
	image= app.loadImage("pngs/Pantallas/Puntajes.png");
	}

	public void validateScore() {
		app.fill(0);
		app.textSize (20);
		app.text(this.score, 100, 30);
		app.textSize (15);
		app.text("Score:",30,30);
	}
}

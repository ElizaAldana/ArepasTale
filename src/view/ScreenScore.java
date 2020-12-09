package view;

import processing.core.PApplet;

public class ScreenScore extends Screen {

	private int score;
	
	public ScreenScore(PApplet app) {
	super(app);
	image= app.loadImage("pngs/Pantallas/Puntajes.png");
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	
}

package view;

import processing.core.PApplet;
import processing.core.PConstants;

public class ScreenGame extends Screen{
public int BGx;
	public ScreenGame(PApplet app) {
		super(app);
		
		image= app.loadImage("pngs/Pantallas/Background.png");
		BGx=0;
		// TODO Auto-generated constructor stub
	}
	public void draw(int x) {
		app.imageMode(PConstants.CORNER);
		app.image(image,140*(x),0,9004,app.height);
	}
	
}

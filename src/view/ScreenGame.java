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
	public void draw() {
		app.imageMode(PConstants.CORNER);
		app.image(image,BGx,0,9004,app.height);
	}
	public int getBGx() {
		return BGx;
	}
	public void setBGx(int bGx) {
		BGx = bGx;
	}
}

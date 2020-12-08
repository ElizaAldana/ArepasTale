package view;

import controller.Controller;
import processing.core.PApplet;


public class Main extends PApplet {
	
	private Controller control;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main(Main.class.getName());
	}
	int screenNum;
	ScreenSplash splash;
	
	public void settings() {
		size(1000,700);

	}

	public void setup() {
		this.control = new Controller(this);
		screenNum=1;
		splash = new ScreenSplash(this);
	}

	public void draw() {
		System.out.println(mouseX);
		System.out.println(mouseY);
		switch(screenNum) {
		case 1:
			//SPLASH SCREEN
			splash.draw();
			break;
		}
		

	}

	public void keyPressed() {

	}

	public void keyReleased() {
		
	}
	
	public void mouseClicked() {
		this.control.mouseClick();
	}
}

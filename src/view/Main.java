package view;

import controller.Controller;
import processing.core.PApplet;


public class Main extends PApplet {
	
	private Controller control;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main(Main.class.getName());
	}

	public void settings() {
		size(1000, 800);

	}

	public void setup() {
		this.control = new Controller(this);
	}

	public void draw() {
		background(0);
		

	}

	public void keyPressed() {

	}

	public void keyReleased() {
		
	}
	
	public void mouseClicked() {
		this.control.mouseClick();
	}
}

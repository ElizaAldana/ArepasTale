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
		size(1000,700);

	}

	public void setup() {
		this.control = new Controller(this);
	}

	public void draw() {
		this.control.draw();
		//System.out.println(mouseX);
		//System.out.println(mouseY);
	}

	public void keyPressed() {

	}

	public void keyReleased() {
		
	}
	
	public void mouseClicked() {
		this.control.mouseClick();
		
		}

		
	}


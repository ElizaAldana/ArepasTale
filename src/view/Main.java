package view;

import controller.Controller;
import processing.core.PApplet;

public class Main extends PApplet {

	private Controller control;
	boolean keyUse;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main(Main.class.getName());
	}

	public void settings() {
		size(1000, 700);

	}

	public void setup() {
		this.control = new Controller(this);
		keyUse = true;
	}

	public void draw() {
		this.control.draw();


//		System.out.println(mouseX);
//	    System.out.println(mouseY);
	
	
	}

	public void keyPressed() {
		if (keyUse) {
			switch (keyCode) {
			case 87:
				control.move(0);
				keyUse=false;
				break;
			case 65:
				control.move(2);
				keyUse=false;

				break;
			case 68:

				control.move(3);
				keyUse=false;
				break;
			}
		}
	}

	public void keyReleased() {
		keyUse=true;
	}

	public void mouseClicked() {
		this.control.mouseClick();
		this.control.sort(key);

	}

}

package view;

import controlP5.Label;
import controlP5.Textfield;
import processing.core.PApplet;

public class ScreenWin extends Screen{

	public ScreenWin(PApplet app) {
		super(app);
		image= app.loadImage("pngs/Pantallas/Win.png");
		// TODO Auto-generated constructor stub
	}
	public void textFields() {
		cp5.addTextfield("name")
		  .setPosition(225,388)
		  .setSize(380,63)
		  .setFont(app.createFont("Arial Rounded MT Bold",24))
		  .setAutoClear(false)
		  .setColorValue(0xFFF4831A)        //Orange
		  .setColorActive(0xFF18A1DA)         //Dark Blue
		  .setColorBackground(0xffA3E4FF)  //Light Blue
		  .setColorCursor(0xFF18A1DA)      //Dark Blue
		  ;
		 
		 Label labelN = cp5.get(Textfield.class,"name").getCaptionLabel();
			labelN.hide();
		 }
	public void hide() {
		cp5.get("name").hide();
		
	}
	public void clear() {
		cp5.get(Textfield.class,"name").clear();
	}
}

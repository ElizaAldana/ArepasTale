package view;

import controlP5.Label;
import controlP5.Textfield;
import processing.core.PApplet;

public class ScreenReg extends Screen {

	public ScreenReg(PApplet app) {
		super(app);
		image= app.loadImage("pngs/Pantallas/Registro.png");
		// TODO Auto-generated constructor stub
	}
	public void textFields() {
		cp5.addTextfield("user")
		  .setPosition(310,210)
		  .setSize(380,63)
		  .setFont(app.createFont("Arial Rounded MT Bold",24))
		  .setAutoClear(false)
		  .setColorValue(0xFFF4831A)        //Orange
		  .setColorActive(0xFF18A1DA)         //Dark Blue
		  .setColorBackground(0xffA3E4FF)  //Light Blue
		  .setColorCursor(0xFF18A1DA)      //Dark Blue
		  ;
		 
		 cp5.addTextfield("password")
	     .setPosition(310,397)
	     .setSize(380,63)
	     .setFont(app.createFont("Arial Rounded MT Bold",24))
	     .setAutoClear(false)
	     .setColorValue(0xFFF4831A)        //Orange
		  .setColorActive(0xFF18A1DA)         //Dark Blue
		  .setColorBackground(0xffA3E4FF)  //Light Blue
		  .setColorCursor(0xFF18A1DA)      //Dark Blue
		  ;
		 Label labelN = cp5.get(Textfield.class,"user").getCaptionLabel();
			labelN.hide();
			Label labelL = cp5.get(Textfield.class,"password").getCaptionLabel();
			labelL.hide();
		 }
	public void hide() {
		cp5.get("user").hide();
		cp5.get("password").hide();
	}
	public void clear() {
		cp5.get(Textfield.class,"user").clear();
		cp5.get(Textfield.class,"password").clear();
	}
}
